create table cuenta
(
    id              serial
        primary key,
    email           varchar(200),
    nombre_completo varchar(200),
    created_by      integer,
    created_date    timestamp with time zone default ((CURRENT_TIMESTAMP AT TIME ZONE 'America/Lima'::text))::timestamp with time zone,
    modified_by     integer,
    modified_date   timestamp with time zone,
    estado          boolean                  default true
);

alter table cuenta
    owner to postgres;

create trigger trg_cuenta_update
    before update
    on cuenta
    for each row
execute procedure establecer_modified_date();

create trigger trg_rodrigo_cuenta_insert_update
    before insert or update
    on cuenta
    for each row
execute procedure establecer_modified_date_rodrigo();

grant delete, insert, references, select, trigger, truncate, update on cuenta to anon;

grant delete, insert, references, select, trigger, truncate, update on cuenta to authenticated;

grant delete, insert, references, select, trigger, truncate, update on cuenta to service_role;

