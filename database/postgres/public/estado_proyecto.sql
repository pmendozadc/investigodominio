create table estado_proyecto
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

alter table estado_proyecto
    owner to postgres;

create trigger trg_estado_proyecto_update
    before update
    on estado_proyecto
    for each row
execute procedure establecer_modified_date();

grant delete, insert, references, select, trigger, truncate, update on estado_proyecto to anon;

grant delete, insert, references, select, trigger, truncate, update on estado_proyecto to authenticated;

grant delete, insert, references, select, trigger, truncate, update on estado_proyecto to service_role;

