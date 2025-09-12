CREATE TABLE copia (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(200),
    responsables VARCHAR(200),
    estado BOOL DEFAULT TRUE,

    created_by INT,
    created_date TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
    modified_by INT,
    modified_date TIMESTAMPTZ
);

CREATE TABLE historial_copia (
    id SERIAL PRIMARY KEY,
    email VARCHAR(200),
    fecha_archivado TIMESTAMPTZ,
    estado BOOL DEFAULT TRUE,

    created_by INT,
    created_date TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
    modified_by INT,
    modified_date TIMESTAMPTZ
);

CREATE TABLE relacion_reparto_copia (
    id SERIAL PRIMARY KEY,
    email VARCHAR(200),
    estado BOOL DEFAULT TRUE,

    created_by INT,
    created_date TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
    modified_by INT,
    modified_date TIMESTAMPTZ
);


