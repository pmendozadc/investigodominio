-- Tablas de la base de datos
SELECT tablename
FROM pg_catalog.pg_tables
WHERE schemaname = 'public';

-- Detalles de la tabla
SELECT
    column_name,
    data_type,
    character_maximum_length,
    column_default,
    is_nullable
FROM
    information_schema.columns
WHERE
    table_name = 'proyecto';

-- Foreing keys and tables
SELECT
    c.conname AS constraint_name,
    tbl.relname AS referencing_table,
    col.attname AS referencing_column,
    referenced_tbl.relname AS referenced_table,
    referenced_col.attname AS referenced_column
FROM
    pg_constraint c
    JOIN pg_namespace nsp ON nsp.oid = c.connamespace
    JOIN pg_class tbl ON tbl.oid = c.conrelid
    JOIN pg_attribute col ON col.attrelid = c.conrelid AND col.attnum = ANY(c.conkey)
    JOIN pg_class referenced_tbl ON referenced_tbl.oid = c.confrelid
    JOIN pg_attribute referenced_col ON referenced_col.attrelid = c.confrelid
    AND referenced_col.attnum = ANY(c.confkey)
WHERE
    c.contype = 'f' AND
    nsp.nspname = 'public'
ORDER BY
    tbl.relname, c.conname;

-- Usuarios activos y no activos
SELECT
  SUM(CASE WHEN state = 'active' THEN 1 ELSE 0 END) AS activas,
  SUM(CASE WHEN state LIKE 'idle%' THEN 1 ELSE 0 END) AS idle
FROM pg_stat_activity
WHERE backend_type = 'client backend';

-- ---------------------------------------------------------

DROP TABLE IF EXISTS documento_proyecto;
DROP TABLE IF EXISTS proyecto_objetivo_especifico;
DROP TABLE IF EXISTS proyecto;
DROP TABLE IF EXISTS tipo_proyecto;

-- ------- Tabla tipo_proyecto -----------------------------
CREATE TABLE tipo_proyecto(
    id                      INTEGER PRIMARY KEY,
    nombre                  VARCHAR(200),
    estado                  BOOLEAN DEFAULT TRUE,

    created_by              INTEGER,
    created_date            TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    modified_by             INTEGER,
    modified_date           TIMESTAMP WITH TIME ZONE
);

DROP SEQUENCE IF EXISTS tipo_proyecto_id_seq;

CREATE SEQUENCE tipo_proyecto_id_seq
    START WITH 1001
    INCREMENT BY 1
    MINVALUE 1001
    MAXVALUE 999999;

ALTER TABLE
    tipo_proyecto
ALTER
    COLUMN id
    SET DEFAULT nextval('tipo_proyecto_id_seq');

-- ------- Tabla proyecto ----------------------------------
CREATE TABLE proyecto(
    id                      INTEGER PRIMARY KEY,
    nombre                  VARCHAR(200),
    id_lider                INTEGER,
    id_carpeta              VARCHAR(200),
    objetivo_general        VARCHAR(500),
    fecha_creacion          TIMESTAMP WITH TIME ZONE,
    fecha_inicio            TIMESTAMP WITH TIME ZONE,
    fecha_fin               TIMESTAMP WITH TIME ZONE,
    estado                  BOOLEAN DEFAULT TRUE,
    id_hoja_seguimiento     VARCHAR(200),

    id_tipo_proyecto        INTEGER,
    id_grupo_asignado       INTEGER,
    id_estado_proyecto      INTEGER,

    created_by              INTEGER,
    created_date            TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    modified_by             INTEGER,
    modified_date           TIMESTAMP WITH TIME ZONE
);

DROP SEQUENCE IF EXISTS proyecto_id_seq;

CREATE SEQUENCE proyecto_id_seq
    START WITH 1001
    INCREMENT BY 1
    MINVALUE 1001
    MAXVALUE 999999;

ALTER TABLE
    proyecto
ALTER
    COLUMN id
    SET DEFAULT nextval('proyecto_id_seq');

ALTER TABLE
    proyecto
ADD CONSTRAINT
    fk_proyecto_tipo_proyecto
FOREIGN KEY (id_tipo_proyecto) REFERENCES tipo_proyecto(id);

ALTER TABLE
    proyecto
ADD CONSTRAINT
    fk_proyecto_grupo
FOREIGN KEY (id_grupo_asignado) REFERENCES grupo(id);

ALTER TABLE
    proyecto
ADD CONSTRAINT
    fk_proyecto_estado_proyecto
FOREIGN KEY (id_estado_proyecto) REFERENCES estado_proyecto(id);

-- ------- Tabla proyecto_objetivo_especifico --------------
CREATE TABLE proyecto_objetivo_especifico(
    id                      INTEGER PRIMARY KEY,
    objetivo_especifico     VARCHAR(500),
    estado                  BOOLEAN DEFAULT TRUE,

    id_proyecto             INTEGER,

    created_by              INTEGER,
    created_date            TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    modified_by             INTEGER,
    modified_date           TIMESTAMP WITH TIME ZONE
);

DROP SEQUENCE IF EXISTS proyecto_objetivo_especifico_id_seq;

CREATE SEQUENCE proyecto_objetivo_especifico_id_seq
    START WITH 1001
    INCREMENT BY 1
    MINVALUE 1001
    MAXVALUE 999999;

ALTER TABLE
    proyecto_objetivo_especifico
ALTER
    COLUMN id
    SET DEFAULT nextval('proyecto_objetivo_especifico_id_seq');

ALTER TABLE
    proyecto_objetivo_especifico
ADD CONSTRAINT
    fk_objetivo_especifico_proyecto
FOREIGN KEY (id_proyecto) REFERENCES proyecto(id);


-- ------- Tabla documento_proyecto ------------------------
CREATE TABLE documento_proyecto(
    id                      INTEGER PRIMARY KEY,
    titulo                  VARCHAR(200),
    tiene_marcadores        BOOLEAN,
    estado                  BOOLEAN DEFAULT TRUE,

    id_proyecto             INTEGER,

    created_by              INTEGER,
    created_date            TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    modified_by             INTEGER,
    modified_date           TIMESTAMP WITH TIME ZONE
);

DROP SEQUENCE IF EXISTS documento_proyecto_id_seq;

CREATE SEQUENCE documento_proyecto_id_seq
    START WITH 1001
    INCREMENT BY 1
    MINVALUE 1001
    MAXVALUE 999999;

ALTER TABLE
    documento_proyecto
ALTER
    COLUMN id
    SET DEFAULT nextval('documento_proyecto_id_seq');

ALTER TABLE
    documento_proyecto
ADD CONSTRAINT
    fk_documento_proyecto_proyecto
FOREIGN KEY (id_proyecto) REFERENCES proyecto(id);

-- ---------- Funciones para los triggers ----------------

CREATE OR REPLACE FUNCTION insert_nuevo_record ()
RETURNS TRIGGER AS $$
DECLARE
    column_name TEXT;
    update_parts TEXT[] := '{}';
    update_stmt TEXT;
    is_not_null BOOLEAN;
BEGIN

    IF current_setting('triggers.in_update', TRUE) = 'true' THEN
        RETURN NULL;
    END IF;

    RAISE NOTICE 'Trigger activado: after insert para %', TG_TABLE_NAME;

    PERFORM set_config('triggers.in_update', 'true', TRUE);

    EXECUTE 'UPDATE ' || quote_ident(TG_TABLE_NAME) ||
            ' SET created_date = $1 WHERE id = $2'
    USING (CURRENT_TIMESTAMP AT TIME ZONE 'America/Lima')::timestamptz, NEW.id;

    FOR column_name IN
        SELECT c.column_name
        FROM information_schema.columns c
        WHERE c.table_schema = TG_TABLE_SCHEMA
        AND c.table_name = TG_TABLE_NAME
        AND c.data_type IN ('character varying', 'varchar', 'text', 'char', 'character')
    LOOP

        EXECUTE 'SELECT $1.' || quote_ident(column_name) || ' IS NOT NULL' INTO is_not_null USING NEW;

        IF is_not_null THEN

            update_parts := array_append(update_parts,
                            quote_ident(column_name) || ' = UPPER(' ||
                            quote_ident(column_name) || ')');
        END IF;
    END LOOP;

    IF array_length(update_parts, 1) > 0 THEN
        update_stmt := 'UPDATE ' || quote_ident(TG_TABLE_NAME) ||
                     ' SET ' || array_to_string(update_parts, ', ') ||
                     ' WHERE id = $1';
        EXECUTE update_stmt USING NEW.id;
    END IF;

    PERFORM set_config('triggers.in_update', 'false', TRUE);

    RETURN NULL;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION update_record ()
RETURNS TRIGGER AS $$
DECLARE
    column_name TEXT;
    update_parts TEXT[] := '{}';
    update_stmt TEXT;
    is_not_null BOOLEAN;
BEGIN

    IF current_setting('triggers.in_update', TRUE) = 'true' THEN
        RETURN NULL;
    END IF;

    RAISE NOTICE 'Trigger activado: after update para %', TG_TABLE_NAME;

    PERFORM set_config('triggers.in_update', 'true', TRUE);

    EXECUTE 'UPDATE ' || quote_ident(TG_TABLE_NAME) ||
            ' SET modified_date = $1 WHERE id = $2'
    USING (CURRENT_TIMESTAMP AT TIME ZONE 'America/Lima')::timestamptz, NEW.id;

    FOR column_name IN
        SELECT c.column_name
        FROM information_schema.columns c
        WHERE c.table_schema = TG_TABLE_SCHEMA
        AND c.table_name = TG_TABLE_NAME
        AND c.data_type IN ('character varying', 'varchar', 'text', 'char', 'character')
    LOOP

        EXECUTE 'SELECT $1.' || quote_ident(column_name) || ' IS NOT NULL' INTO is_not_null USING NEW;

        IF is_not_null THEN

            update_parts := array_append(update_parts,
                            quote_ident(column_name) || ' = UPPER(' ||
                            quote_ident(column_name) || ')');
        END IF;
    END LOOP;

    IF array_length(update_parts, 1) > 0 THEN
        update_stmt := 'UPDATE ' || quote_ident(TG_TABLE_NAME) ||
                     ' SET ' || array_to_string(update_parts, ', ') ||
                     ' WHERE id = $1';
        EXECUTE update_stmt USING NEW.id;
    END IF;

    PERFORM set_config('triggers.in_update', 'false', TRUE);

    RETURN NULL;
END;
$$ LANGUAGE plpgsql;


-- ----------- Triggers ----------------------------------

DROP TRIGGER IF EXISTS trigger_insert_proyecto
    ON proyecto;

CREATE TRIGGER trigger_insert_proyecto
AFTER INSERT ON proyecto
FOR EACH ROW
EXECUTE FUNCTION insert_nuevo_record();

DROP TRIGGER IF EXISTS trigger_insert_tipo_proyecto
    ON tipo_proyecto;

CREATE TRIGGER trigger_insert_tipo_proyecto
AFTER INSERT ON tipo_proyecto
FOR EACH ROW
EXECUTE FUNCTION insert_nuevo_record();

DROP TRIGGER IF EXISTS trigger_insert_proyecto_objetivo_especifico
    ON proyecto_objetivo_especifico;

CREATE TRIGGER trigger_insert_proyecto_objetivo_especifico
AFTER INSERT ON proyecto_objetivo_especifico
FOR EACH ROW
EXECUTE FUNCTION insert_nuevo_record();

DROP TRIGGER IF EXISTS trigger_insert_documento_proyecto
    ON documento_proyecto;

CREATE TRIGGER trigger_insert_documento_proyecto
AFTER INSERT ON documento_proyecto
FOR EACH ROW
EXECUTE FUNCTION insert_nuevo_record();

-- updates --------------------------------------------

DROP TRIGGER IF EXISTS trigger_update_proyecto
    ON proyecto;

CREATE TRIGGER trigger_update_proyecto
AFTER UPDATE ON proyecto
FOR EACH ROW
EXECUTE FUNCTION update_record();

DROP TRIGGER IF EXISTS trigger_update_tipo_proyecto
    ON tipo_proyecto;

CREATE TRIGGER trigger_update_tipo_proyecto
AFTER UPDATE ON tipo_proyecto
FOR EACH ROW
EXECUTE FUNCTION update_record();

DROP TRIGGER IF EXISTS trigger_update_proyecto_objetivo_especifico
    ON proyecto_objetivo_especifico;

CREATE TRIGGER trigger_update_proyecto_objetivo_especifico
AFTER UPDATE ON proyecto_objetivo_especifico
FOR EACH ROW
EXECUTE FUNCTION update_record();

DROP TRIGGER IF EXISTS trigger_update_documento_proyecto
    ON documento_proyecto;

CREATE TRIGGER trigger_update_documento_proyecto
AFTER UPDATE ON documento_proyecto
FOR EACH ROW
EXECUTE FUNCTION update_record();

