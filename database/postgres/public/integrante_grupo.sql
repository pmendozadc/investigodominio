create table integrante_grupo
(
    id            serial
        primary key,
    id_grupo      integer,
    email         varchar(200),
    estado        boolean                  default true,
    created_by    integer,
    created_date  timestamp with time zone default ((CURRENT_TIMESTAMP AT TIME ZONE 'America/Lima'::text))::timestamp with time zone,
    modified_by   integer,
    modified_date timestamp with time zone
);

alter table integrante_grupo
    owner to postgres;

create trigger trg_integrante_grupo_update
    before update
    on integrante_grupo
    for each row
execute procedure establecer_modified_date();

create trigger trg_rodrigo_integrante_grupo_insert_update
    before insert or update
    on integrante_grupo
    for each row
execute procedure establecer_modified_date_rodrigo();

grant delete, insert, references, select, trigger, truncate, update on integrante_grupo to anon;

grant delete, insert, references, select, trigger, truncate, update on integrante_grupo to authenticated;

grant delete, insert, references, select, trigger, truncate, update on integrante_grupo to service_role;

