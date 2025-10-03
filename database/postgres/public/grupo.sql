create table grupo
(
    id            serial
        primary key,
    nombre        varchar(200),
    estado        boolean                  default true,
    id_carpeta    integer,
    created_by    integer,
    created_date  timestamp with time zone default ((CURRENT_TIMESTAMP AT TIME ZONE 'America/Lima'::text))::timestamp with time zone,
    modified_by   integer,
    modified_date timestamp with time zone
);

alter table grupo
    owner to postgres;

create trigger trg_grupo_update
    before update
    on grupo
    for each row
execute procedure establecer_modified_date();

create trigger trg_rodrigo_grupo_insert_update
    before insert or update
    on grupo
    for each row
execute procedure establecer_modified_date_rodrigo();

grant delete, insert, references, select, trigger, truncate, update on grupo to anon;

grant delete, insert, references, select, trigger, truncate, update on grupo to authenticated;

grant delete, insert, references, select, trigger, truncate, update on grupo to service_role;

