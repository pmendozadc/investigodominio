create table proyecto_objetivo_especifico
(
    id                  integer                  default nextval('secuencia_proyecto_objetivo_especifico'::regclass) not null
        primary key,
    objetivo_especifico varchar(500),
    estado              boolean                  default true,
    id_proyecto         integer,
    created_by          integer,
    created_date        timestamp with time zone default CURRENT_TIMESTAMP,
    modified_by         integer,
    modified_date       timestamp with time zone
);

alter table proyecto_objetivo_especifico
    owner to postgres;

create trigger trigger_actualizar_proyecto_objetivo_especifico
    before update
    on proyecto_objetivo_especifico
    for each row
execute procedure actualizar_modified_date();

grant delete, insert, references, select, trigger, truncate, update on proyecto_objetivo_especifico to anon;

grant delete, insert, references, select, trigger, truncate, update on proyecto_objetivo_especifico to authenticated;

grant delete, insert, references, select, trigger, truncate, update on proyecto_objetivo_especifico to service_role;

