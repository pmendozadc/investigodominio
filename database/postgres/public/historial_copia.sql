create table historial_copia
(
    id              serial
        primary key,
    email           varchar(200),
    fecha_archivado timestamp with time zone,
    estado          boolean                  default true,
    created_by      integer,
    created_date    timestamp with time zone default CURRENT_TIMESTAMP,
    modified_by     integer,
    modified_date   timestamp with time zone
);

alter table historial_copia
    owner to postgres;

create trigger trg_historial_copia_update
    before update
    on historial_copia
    for each row
execute procedure establecer_modified_date();

grant delete, insert, references, select, trigger, truncate, update on historial_copia to anon;

grant delete, insert, references, select, trigger, truncate, update on historial_copia to authenticated;

grant delete, insert, references, select, trigger, truncate, update on historial_copia to service_role;

