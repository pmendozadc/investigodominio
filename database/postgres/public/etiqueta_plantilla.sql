create table etiqueta_plantilla
(
    id            serial
        primary key,
    id_plantilla  integer                                            not null,
    id_etiqueta   integer                                            not null,
    estado        boolean                  default true              not null,
    created_by    integer,
    created_date  timestamp with time zone default CURRENT_TIMESTAMP not null,
    modified_by   integer,
    modified_date timestamp with time zone
);

alter table etiqueta_plantilla
    owner to postgres;

create index idx_ep_id_plantilla
    on etiqueta_plantilla (id_plantilla);

create index idx_ep_id_etiqueta
    on etiqueta_plantilla (id_etiqueta);

create trigger trg_etiqueta_plantilla_modified
    before update
    on etiqueta_plantilla
    for each row
execute procedure set_modified_date();

grant delete, insert, references, select, trigger, truncate, update on etiqueta_plantilla to anon;

grant delete, insert, references, select, trigger, truncate, update on etiqueta_plantilla to authenticated;

grant delete, insert, references, select, trigger, truncate, update on etiqueta_plantilla to service_role;

