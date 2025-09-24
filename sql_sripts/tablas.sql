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
    table_name = 'rol';

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
    JOIN pg_attribute referenced_col ON referenced_col.attrelid = c.confrelid AND referenced_col.attnum = ANY(c.confkey)
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




DROP TABLE IF EXISTS proyecto;
DROP TABLE IF EXISTS tipo_proyecto;
DROP TABLE IF EXISTS proyecto_objetivo_especifico;
DROP TABLE IF EXISTS documento_proyecto;

-- ------- Tabla proyecto ----------------------------------
CREATE TABLE proyecto(
    id                      INTEGER PRIMARY KEY,
    nombre                  VARCHAR(200),
    email_lider             VARCHAR(200),
    id_carpeta              VARCHAR(200),
    objetivo_general        VARCHAR(500),
    fecha_creacion          TIMESTAMP WITH TIME ZONE,
    fecha_inicio            TIMESTAMP WITH TIME ZONE,
    fecha_fin               TIMESTAMP WITH TIME ZONE,
    estado                  BOOLEAN DEFAULT TRUE,

    id_tipo_proyecto        INTEGER,
    id_hoja_seguimiento     INTEGER,
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

-- ---------- Funciones para los triggers ----------------

CREATE OR REPLACE FUNCTION actualizar_modified_date()
RETURNS TRIGGER AS
$$
BEGIN
    RAISE NOTICE 'Trigger activado: actualizar_modified_date';
    NEW.modified_date = (CURRENT_TIMESTAMP AT TIME ZONE 'America/Lima')::timestamptz;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- ----------- Triggers ----------------------------------

DROP TRIGGER IF EXISTS trigger_create_proyecto ON proyecto;

CREATE TRIGGER trigger_create_proyecto
BEFORE INSERT ON proyecto
FOR EACH ROW
EXECUTE FUNCTION actualizar_modified_date();

DROP TRIGGER IF EXISTS trigger_update_tipo_proyecto ON tipo_proyecto;

CREATE TRIGGER trigger_update_tipo_proyecto
BEFORE UPDATE ON tipo_proyecto
FOR EACH ROW
EXECUTE FUNCTION actualizar_modified_date();

DROP TRIGGER IF EXISTS trigger_update_proyecto_objetivo_especifico ON proyecto_objetivo_especifico;

CREATE TRIGGER trigger_update_proyecto_objetivo_especifico
BEFORE UPDATE ON proyecto_objetivo_especifico
FOR EACH ROW
EXECUTE FUNCTION actualizar_modified_date();

DROP TRIGGER IF EXISTS trigger_update_documento_proyecto
ON documento_proyecto;

CREATE TRIGGER trigger_update_documento_proyecto
BEFORE UPDATE ON documento_proyecto
FOR EACH ROW
EXECUTE FUNCTION actualizar_modified_date();


DROP TRIGGER IF EXISTS trigger_update_proyecto ON proyecto;

CREATE TRIGGER trigger_update_proyecto
BEFORE UPDATE ON proyecto
FOR EACH ROW
EXECUTE FUNCTION actualizar_modified_date();

DROP TRIGGER IF EXISTS trigger_update_tipo_proyecto ON tipo_proyecto;

CREATE TRIGGER trigger_update_tipo_proyecto
BEFORE UPDATE ON tipo_proyecto
FOR EACH ROW
EXECUTE FUNCTION actualizar_modified_date();

DROP TRIGGER IF EXISTS trigger_update_proyecto_objetivo_especifico ON proyecto_objetivo_especifico;

CREATE TRIGGER trigger_update_proyecto_objetivo_especifico
BEFORE UPDATE ON proyecto_objetivo_especifico
FOR EACH ROW
EXECUTE FUNCTION actualizar_modified_date();

DROP TRIGGER IF EXISTS trigger_update_documento_proyecto ON documento_proyecto;

CREATE TRIGGER trigger_update_documento_proyecto
BEFORE UPDATE ON documento_proyecto
FOR EACH ROW
EXECUTE FUNCTION actualizar_modified_date();

-- ---------- Mock Data-----------------------------------

insert into tipo_proyecto
(nombre, created_by)
values (
        'Proyecto Interno', 1
);

insert into proyecto
(nombre, email_lider, id_carpeta, objetivo_general, fecha_inicio, fecha_fin, id_tipo_proyecto, id_hoja_seguimiento, id_grupo_asignado, id_estado_proyecto, created_by)
values (
    'Proyecto 1','lider@mail.com', 'asdf', 'objetivo general 1', null, null, 1, null, null, null, 1
);

insert into documento_proyecto
(titulo, tiene_marcadores, id_proyecto, created_by)
values (
    'documento 1', false, 1, 1
);

insert into proyecto_objetivo_especifico
(objetivo_especifico, id_proyecto, created_by)
values (
    'Objetivo específico 1', 1, 1
);

select * from tipo_proyecto;
select * from proyecto;
select * from documento_proyecto;
select * from proyecto_objetivo_especifico;

-- update tipo_proyecto set nombre='Proyecto Interno Test' where id=101;


