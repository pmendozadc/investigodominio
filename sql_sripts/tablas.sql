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

-- ------- Tabla proyecto ----------------------------------
CREATE TABLE proyecto(
    id                      SERIAL PRIMARY KEY,
    nombre                  VARCHAR(200),
    email_lider             VARCHAR(200),
    id_carperta             VARCHAR(200),
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

