create table relacion_proyecto_linea_investigacion
(
    id                     serial
        primary key,
    id_proyecto            integer,
    id_linea_investigacion integer,
    estado                 boolean                  default true,
    created_by             integer,
    created_date           timestamp with time zone default CURRENT_TIMESTAMP,
    modified_by            integer,
    modified_date          timestamp with time zone
);

alter table relacion_proyecto_linea_investigacion
    owner to postgres;

create trigger trg_relacion_proyecto_linea_investigacion_update
    before update
    on relacion_proyecto_linea_investigacion
    for each row
execute procedure establecer_modified_date();

grant delete, insert, references, select, trigger, truncate, update on relacion_proyecto_linea_investigacion to anon;

grant delete, insert, references, select, trigger, truncate, update on relacion_proyecto_linea_investigacion to authenticated;

grant delete, insert, references, select, trigger, truncate, update on relacion_proyecto_linea_investigacion to service_role;

