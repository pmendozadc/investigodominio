create table etiqueta_proyecto
(
    id              serial
        primary key,
    id_proyecto     integer                                            not null,
    nombre_etiqueta varchar(200)                                       not null,
    estado          boolean                  default true              not null,
    created_by      integer,
    created_date    timestamp with time zone default CURRENT_TIMESTAMP not null,
    modified_by     integer,
    modified_date   timestamp with time zone
);

alter table etiqueta_proyecto
    owner to postgres;

create index idx_epr_id_proyecto
    on etiqueta_proyecto (id_proyecto);

create index idx_epr_nombre_etiqueta
    on etiqueta_proyecto (nombre_etiqueta);

create trigger trg_etiqueta_proyecto_modified
    before update
    on etiqueta_proyecto
    for each row
execute procedure set_modified_date();

grant delete, insert, references, select, trigger, truncate, update on etiqueta_proyecto to anon;

grant delete, insert, references, select, trigger, truncate, update on etiqueta_proyecto to authenticated;

grant delete, insert, references, select, trigger, truncate, update on etiqueta_proyecto to service_role;

