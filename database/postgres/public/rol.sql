create table rol
(
    id            serial
        primary key,
    nombre        varchar(255) not null,
    estado        boolean                  default true,
    created_date  timestamp with time zone default CURRENT_TIMESTAMP,
    created_by    integer
        constraint fk_rol_created_by
            references usuario,
    modified_date timestamp with time zone,
    modified_by   integer
        constraint fk_rol_modified_by
            references usuario
);

alter table rol
    owner to postgres;

create trigger trg_rol_update
    before update
    on rol
    for each row
execute procedure establecer_modified_date();

grant delete, insert, references, select, trigger, truncate, update on rol to anon;

grant delete, insert, references, select, trigger, truncate, update on rol to authenticated;

grant delete, insert, references, select, trigger, truncate, update on rol to service_role;

