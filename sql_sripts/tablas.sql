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
    information_schema.columns c
WHERE
    table_name = 'tmp';

DROP TABLE IF EXISTS proyecto;

-- ------- Tabla proyecto ----------------------------------
CREATE TABLE proyecto(
    id                      SERIAL PRIMARY KEY,
    nombre                  VARCHAR(200),
    email_lider             VARCHAR(200),
    id_carpeta             VARCHAR(200),
    objetivo_general        VARCHAR(500),
    fecha_creacion          TIMESTAMPTZ,
    fecha_inicio            TIMESTAMPTZ,
    fecha_fin               TIMESTAMPTZ,

    id_tipo_proyecto        INTEGER,
    id_hoja_seguimiento     INTEGER,
    id_grupo_asignado       INTEGER,
    id_estado_proyecto      INTEGER,

    created_by              INTEGER,
    created_date            TIMESTAMPTZ,
    modified_by             INTEGER,
    modified_date           TIMESTAMPTZ
);

-- ------- Tabla tipo_proyecto -----------------------------
CREATE TABLE tipo_proyecto(
    id                      SERIAL PRIMARY KEY,
    nombre                  VARCHAR(200),

    created_by              INTEGER,
    created_date            TIMESTAMPTZ,
    modified_by             INTEGER,
    modified_date           TIMESTAMPTZ
);

-- ------- Tabla proyecto_objetivo_especifico --------------
CREATE TABLE proyecto_objetivo_especifico(
    id                      SERIAL PRIMARY KEY,
    objetivo_especifico     VARCHAR(500),

    id_proyecto             INTEGER,

    created_by              INTEGER,
    created_date            TIMESTAMPTZ,
    modified_by             INTEGER,
    modified_date           TIMESTAMPTZ
);

-- ------- Tabla documento_proyecto ------------------------
CREATE TABLE documento_proyecto(
    id_documento            SERIAL PRIMARY KEY,
    titulo                  VARCHAR(200),
    tiene_marcadores        BOOLEAN,

    id_proyecto             INTEGER,

    created_by              INTEGER,
    created_date            TIMESTAMPTZ,
    modified_by             INTEGER,
    modified_date           TIMESTAMPTZ
);

insert into tipo_proyecto (nombre, created_by, created_date, modified_by, modified_date )
values (
        'Proyecto Interno', 1, now(), null, null
);

insert into proyecto
( nombre, email_lider, id_carpeta, objetivo_general, fecha_creacion, fecha_inicio, fecha_fin, id_tipo_proyecto, id_hoja_seguimiento, id_grupo_asignado, id_estado_proyecto, created_by, created_date, modified_by, modified_date)
values (
        'Proyecto 1','lider@mail.com', 'asdf', 'objetivo general 1', now(), null, null, 1, null, null, null, 1, now(), null, null
       );

insert into documento_proyecto (titulo, tiene_marcadores, id_proyecto, created_by, created_date, modified_by, modified_date)
values (
        'documento 1', false, 1, 1, now(), null, null
       );

insert into proyecto_objetivo_especifico (objetivo_especifico, id_proyecto, created_by, created_date, modified_by, modified_date)
values ('Objetivo específico 1', 1, 1, now(), null, null);

select * from tipo_proyecto;
select * from proyecto;
select * from documento_proyecto;
select * from proyecto_objetivo_especifico;
