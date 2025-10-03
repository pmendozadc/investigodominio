create table documento_proyecto
(
    id               integer                  default nextval('secuencia_documento_proyecto'::regclass) not null
        primary key,
    titulo           varchar(200),
    tiene_marcadores boolean,
    estado           boolean                  default true,
    id_proyecto      integer,
    created_by       integer,
    created_date     timestamp with time zone default CURRENT_TIMESTAMP,
    modified_by      integer,
    modified_date    timestamp with time zone
);

alter table documento_proyecto
    owner to postgres;

create trigger trigger_actualizar_documento_proyecto
    before update
    on documento_proyecto
    for each row
execute procedure actualizar_modified_date();

grant delete, insert, references, select, trigger, truncate, update on documento_proyecto to anon;

grant delete, insert, references, select, trigger, truncate, update on documento_proyecto to authenticated;

grant delete, insert, references, select, trigger, truncate, update on documento_proyecto to service_role;

