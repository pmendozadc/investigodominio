create table etiqueta
(
    id            serial
        primary key,
    nombre        varchar(200)                                       not null,
    descripcion   text,
    color         varchar(50),
    estado        boolean                  default true              not null,
    created_by    integer,
    created_date  timestamp with time zone default CURRENT_TIMESTAMP not null,
    modified_by   integer,
    modified_date timestamp with time zone
);

alter table etiqueta
    owner to postgres;

create index idx_etiqueta_nombre
    on etiqueta (nombre);

create trigger trg_etiqueta_modified
    before update
    on etiqueta
    for each row
execute procedure set_modified_date();

grant delete, insert, references, select, trigger, truncate, update on etiqueta to anon;

grant delete, insert, references, select, trigger, truncate, update on etiqueta to authenticated;

grant delete, insert, references, select, trigger, truncate, update on etiqueta to service_role;

