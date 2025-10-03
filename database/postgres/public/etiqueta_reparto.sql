create table etiqueta_reparto
(
    id              serial
        primary key,
    id_reparto      integer                                            not null,
    nombre_etiqueta varchar(200)                                       not null,
    estado          boolean                  default true              not null,
    created_by      integer,
    created_date    timestamp with time zone default CURRENT_TIMESTAMP not null,
    modified_by     integer,
    modified_date   timestamp with time zone
);

alter table etiqueta_reparto
    owner to postgres;

create index idx_er_id_reparto
    on etiqueta_reparto (id_reparto);

create index idx_er_nombre_etiqueta
    on etiqueta_reparto (nombre_etiqueta);

create trigger trg_etiqueta_reparto_modified
    before update
    on etiqueta_reparto
    for each row
execute procedure set_modified_date();

grant delete, insert, references, select, trigger, truncate, update on etiqueta_reparto to anon;

grant delete, insert, references, select, trigger, truncate, update on etiqueta_reparto to authenticated;

grant delete, insert, references, select, trigger, truncate, update on etiqueta_reparto to service_role;

