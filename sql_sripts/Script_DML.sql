-- ---------- DML -----------------------------------

-- Select tablas

select * from tipo_proyecto;
select * from proyecto;
select * from documento_proyecto;
select * from proyecto_objetivo_especifico;

-- Vaciar tablas

DELETE FROM proyecto_objetivo_especifico;
DELETE FROM documento_proyecto;
DELETE FROM proyecto;
DELETE FROM tipo_proyecto;

-- Resetear las secuencias

ALTER SEQUENCE proyecto_id_seq RESTART WITH 1001;
ALTER SEQUENCE proyecto_id_seq RESTART WITH 1001;
ALTER SEQUENCE proyecto_id_seq RESTART WITH 1001;
ALTER SEQUENCE proyecto_id_seq RESTART WITH 1001;

-- Población de tablas

insert into tipo_proyecto(
    nombre, created_by
) values
(   'Proyecto Interno', 1),
(   'Proyecto Externo', 1),
(   'Proyecto Interno 3', 1),
(   'Proyecto Interno 4', 1),
(   'Proyecto Interno 5', 1),
(   'Proyecto Interno 6', 1),
(   'Proyecto Interno 7', 1),
(   'Proyecto Interno 8', 1),
(   'Proyecto Interno 9', 1),
(   'Proyecto Interno 10', 1);

insert into proyecto(
    nombre, id_lider, id_carpeta, objetivo_general, fecha_inicio, fecha_fin, id_tipo_proyecto,
    id_hoja_seguimiento, id_grupo_asignado, id_estado_proyecto, created_by
) values
(   'Proyecto 1',1001, 'asdf', 'objetivo general 1',
    null, null, 1001,
    null, null, null, 1 ),
(   'Proyecto 2',1001, 'asdf', 'objetivo general 2',
    null, null, 1001,
    null, null, null, 1 ),
(   'Proyecto 3',1001, 'asdf', 'objetivo general 3',
    null, null, 1001,
    null, null, null, 1 ),
(   'Proyecto 4',1001, 'asdf', 'objetivo general 4',
    null, null, 1002,
    null, null, null, 1 ),
(   'Proyecto 5',1001, 'asdf', 'objetivo general 5',
    null, null, 1002,
    null, null, null, 1 ),
(   'Proyecto 6',1001, 'asdf', 'objetivo general 6',
    null, null, 1002,
    null, null, null, 1 ),
(   'Proyecto 7',1001, 'asdf', 'objetivo general 7',
    null, null, 1002,
    null, null, null, 1 ),
(   'Proyecto 8',1001, 'asdf', 'objetivo general 8',
    null, null, 1003,
    null, null, null, 1 ),
(   'Proyecto 9',1001, 'asdf', 'objetivo general 9',
    null, null, 1004,
    null, null, null, 1 ),
(   'Proyecto 10',1001, 'asdf', 'objetivo general 10',
    null, null, 1005,
    null, null, null, 1 );


insert into documento_proyecto (titulo, tiene_marcadores, id_proyecto, created_by)
values
(    'Documento Proyecto 1', false, 1001, 1),
(    'Documento Proyecto 2', false, 1002, 1),
(    'Documento Proyecto 3', false, 1003, 1),
(    'Documento Proyecto 4', false, 1004, 1),
(    'Documento Proyecto 5', false, 1005, 1),
(    'Documento Proyecto 6', false, 1006, 1),
(    'Documento Proyecto 7', false, 1007, 1),
(    'Documento Proyecto 8', false, 1008, 1),
(    'Documento Proyecto 9', false, 1009, 1),
(    'Documento Proyecto 10', false, 1010, 1);

insert into proyecto_objetivo_especifico (
    objetivo_especifico, id_proyecto, created_by
) values
('Objetivo específico 1', 1001, 1),
('Objetivo específico 2', 1002, 1),
('Objetivo específico 3', 1003, 1),
('Objetivo específico 4', 1004, 1),
('Objetivo específico 5', 1005, 1),
('Objetivo específico 6', 1006, 1),
('Objetivo específico 7', 1007, 1),
('Objetivo específico 8', 1008, 1),
('Objetivo específico 9', 1009, 1),
('Objetivo específico 10', 1010, 1);
