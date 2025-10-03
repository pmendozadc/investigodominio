create table informe
(
    id            serial
        primary key,
    nombre        varchar(200),
    id_documento  varchar(200),
    id_imagen     varchar(200),
    created_date  timestamp with time zone default CURRENT_TIMESTAMP,
    created_by    varchar(200),
    modified_date timestamp with time zone,
    modified_by   varchar(200),
    estado        boolean                  default true
);

alter table informe
    owner to postgres;

create trigger trg_informe_update
    before update
    on informe
    for each row
execute procedure establecer_modified_date();

grant delete, insert, references, select, trigger, truncate, update on informe to anon;

grant delete, insert, references, select, trigger, truncate, update on informe to authenticated;

grant delete, insert, references, select, trigger, truncate, update on informe to service_role;

