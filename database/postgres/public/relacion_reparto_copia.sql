create table relacion_reparto_copia
(
    id            serial
        primary key,
    email         varchar(200),
    estado        boolean                  default true,
    created_by    integer,
    created_date  timestamp with time zone default CURRENT_TIMESTAMP,
    modified_by   integer,
    modified_date timestamp with time zone
);

alter table relacion_reparto_copia
    owner to postgres;

create trigger trg_relacion_reparto_copia_update
    before update
    on relacion_reparto_copia
    for each row
execute procedure establecer_modified_date();

grant delete, insert, references, select, trigger, truncate, update on relacion_reparto_copia to anon;

grant delete, insert, references, select, trigger, truncate, update on relacion_reparto_copia to authenticated;

grant delete, insert, references, select, trigger, truncate, update on relacion_reparto_copia to service_role;

