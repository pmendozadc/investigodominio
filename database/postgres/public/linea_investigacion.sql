create table linea_investigacion
(
    id            serial
        primary key,
    nombre        varchar(200) not null,
    estado        boolean                  default true,
    created_by    integer,
    created_date  timestamp with time zone default CURRENT_TIMESTAMP,
    modified_by   integer,
    modified_date timestamp with time zone
);

alter table linea_investigacion
    owner to postgres;

create trigger trg_linea_investigacion_update
    before update
    on linea_investigacion
    for each row
execute procedure establecer_modified_date();

grant delete, insert, references, select, trigger, truncate, update on linea_investigacion to anon;

grant delete, insert, references, select, trigger, truncate, update on linea_investigacion to authenticated;

grant delete, insert, references, select, trigger, truncate, update on linea_investigacion to service_role;

