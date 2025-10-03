create table tipo_proyecto
(
    id            integer                  default nextval('secuencia_tipo_proyecto'::regclass) not null
        primary key,
    nombre        varchar(200),
    estado        boolean                  default true,
    created_by    integer,
    created_date  timestamp with time zone default CURRENT_TIMESTAMP,
    modified_by   integer,
    modified_date timestamp with time zone
);

alter table tipo_proyecto
    owner to postgres;

create trigger trigger_actualizar_tipo_proyecto
    before update
    on tipo_proyecto
    for each row
execute procedure actualizar_modified_date();

grant delete, insert, references, select, trigger, truncate, update on tipo_proyecto to anon;

grant delete, insert, references, select, trigger, truncate, update on tipo_proyecto to authenticated;

grant delete, insert, references, select, trigger, truncate, update on tipo_proyecto to service_role;

