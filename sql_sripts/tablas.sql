SELECT tablename
FROM pg_catalog.pg_tables
WHERE schemaname = 'public';

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
    fecha_creacion          TIMESTAMPTZ,
    fecha_inicio            TIMESTAMPTZ,
    fecha_fin               TIMESTAMPTZ,
    estado                  BOOLEAN DEFAULT TRUE,

    id_tipo_proyecto        INTEGER,
    id_hoja_seguimiento     INTEGER,
    id_grupo_asignado       INTEGER,
    id_estado_proyecto      INTEGER,

    created_by              INTEGER,
    created_date            TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
    modified_by             INTEGER,
    modified_date           TIMESTAMPTZ
);

DROP SEQUENCE IF EXISTS secuencia_proyecto;

CREATE SEQUENCE secuencia_proyecto
    START WITH 101
    INCREMENT BY 1
    MINVALUE 101
    MAXVALUE 999999;

ALTER TABLE
    proyecto
ALTER
    COLUMN id
    SET DEFAULT nextval('secuencia_proyecto');

-- ------- Tabla tipo_proyecto -----------------------------
CREATE TABLE tipo_proyecto(
    id                      INTEGER PRIMARY KEY,
    nombre                  VARCHAR(200),
    estado                  BOOLEAN DEFAULT TRUE,

    created_by              INTEGER,
    created_date            TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
    modified_by             INTEGER,
    modified_date           TIMESTAMPTZ
);

DROP SEQUENCE IF EXISTS secuencia_tipo_proyecto;

CREATE SEQUENCE secuencia_tipo_proyecto
    START WITH 101
    INCREMENT BY 1
    MINVALUE 101
    MAXVALUE 999999;

ALTER TABLE
    tipo_proyecto
ALTER
    COLUMN id
    SET DEFAULT nextval('secuencia_tipo_proyecto');

-- ------- Tabla proyecto_objetivo_especifico --------------
CREATE TABLE proyecto_objetivo_especifico(
    id                      INTEGER PRIMARY KEY,
    objetivo_especifico     VARCHAR(500),
    estado                  BOOLEAN DEFAULT TRUE,

    id_proyecto             INTEGER,

    created_by              INTEGER,
    created_date            TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
    modified_by             INTEGER,
    modified_date           TIMESTAMPTZ
);

DROP SEQUENCE IF EXISTS secuencia_proyecto_objetivo_especifico;

CREATE SEQUENCE secuencia_proyecto_objetivo_especifico
    START WITH 101
    INCREMENT BY 1
    MINVALUE 101
    MAXVALUE 999999;

ALTER TABLE
    proyecto_objetivo_especifico
ALTER
    COLUMN id
    SET DEFAULT nextval('secuencia_proyecto_objetivo_especifico');

-- ------- Tabla documento_proyecto ------------------------
CREATE TABLE documento_proyecto(
    id                      INTEGER PRIMARY KEY,
    titulo                  VARCHAR(200),
    tiene_marcadores        BOOLEAN,
    estado                  BOOLEAN DEFAULT TRUE,

    id_proyecto             INTEGER,

    created_by              INTEGER,
    created_date            TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
    modified_by             INTEGER,
    modified_date           TIMESTAMPTZ
);

DROP SEQUENCE IF EXISTS secuencia_documento_proyecto;

CREATE SEQUENCE secuencia_documento_proyecto
    START WITH 101
    INCREMENT BY 1
    MINVALUE 101
    MAXVALUE 999999;

ALTER TABLE
    documento_proyecto
ALTER
    COLUMN id
    SET DEFAULT nextval('secuencia_documento_proyecto');

-- ---------- Funciones para los triggers ----------------

CREATE OR REPLACE FUNCTION actualizar_modified_date()
RETURNS TRIGGER AS $$
BEGIN
    RAISE NOTICE 'Trigger activado: actualizar_modified_date';
    NEW.modified_date = (CURRENT_TIMESTAMP AT TIME ZONE 'America/Lima')::timestamptz;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- ----------- Triggers ----------------------------------
DROP TRIGGER IF EXISTS trigger_actualizar_proyecto ON proyecto;

CREATE TRIGGER trigger_actualizar_proyecto
BEFORE UPDATE ON proyecto
FOR EACH ROW
EXECUTE FUNCTION actualizar_modified_date();

DROP TRIGGER IF EXISTS trigger_actualizar_tipo_proyecto ON tipo_proyecto;

CREATE TRIGGER trigger_actualizar_tipo_proyecto
BEFORE UPDATE ON tipo_proyecto
FOR EACH ROW
EXECUTE FUNCTION actualizar_modified_date();

DROP TRIGGER IF EXISTS trigger_actualizar_proyecto_objetivo_especifico ON proyecto_objetivo_especifico;

CREATE TRIGGER trigger_actualizar_proyecto_objetivo_especifico
BEFORE UPDATE ON proyecto_objetivo_especifico
FOR EACH ROW
EXECUTE FUNCTION actualizar_modified_date();

DROP TRIGGER IF EXISTS trigger_actualizar_documento_proyecto ON documento_proyecto;

CREATE TRIGGER trigger_actualizar_documento_proyecto
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

update tipo_proyecto set nombre='Proyecto Interno Test' where id=101;

select * from tipo_proyecto;