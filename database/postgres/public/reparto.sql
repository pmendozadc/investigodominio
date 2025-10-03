create table reparto
(
    id                 serial
        primary key,
    id_carpeta_reparto varchar(200),
    created_date       timestamp with time zone default CURRENT_TIMESTAMP,
    created_by         varchar(200),
    modified_date      timestamp with time zone,
    modified_by        varchar(200),
    id_platilla        integer,
    activo             boolean                  default true,
    estado             boolean                  default true
);

alter table reparto
    owner to postgres;

create trigger trg_reparto_update
    before update
    on reparto
    for each row
execute procedure establecer_modified_date();

grant delete, insert, references, select, trigger, truncate, update on reparto to anon;

grant delete, insert, references, select, trigger, truncate, update on reparto to authenticated;

grant delete, insert, references, select, trigger, truncate, update on reparto to service_role;

