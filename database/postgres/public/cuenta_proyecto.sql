create table cuenta_proyecto
(
    id            serial
        primary key,
    email         varchar(200),
    id_proyecto   integer,
    estado        boolean                  default true,
    created_by    integer,
    created_date  timestamp with time zone default ((CURRENT_TIMESTAMP AT TIME ZONE 'America/Lima'::text))::timestamp with time zone,
    modified_by   integer,
    modified_date timestamp with time zone
);

alter table cuenta_proyecto
    owner to postgres;

create trigger trg_cuenta_proyecto_update
    before update
    on cuenta_proyecto
    for each row
execute procedure establecer_modified_date();

create trigger trg_rodrigo_cuenta_proyecto_insert_update
    before insert or update
    on cuenta_proyecto
    for each row
execute procedure establecer_modified_date_rodrigo();

grant delete, insert, references, select, trigger, truncate, update on cuenta_proyecto to anon;

grant delete, insert, references, select, trigger, truncate, update on cuenta_proyecto to authenticated;

grant delete, insert, references, select, trigger, truncate, update on cuenta_proyecto to service_role;

