create table proyecto
(
    id                  integer                  default nextval('secuencia_proyecto'::regclass) not null
        primary key,
    nombre              varchar(200),
    email_lider         varchar(200),
    id_carpeta          varchar(200),
    objetivo_general    varchar(500),
    fecha_creacion      timestamp with time zone,
    fecha_inicio        timestamp with time zone,
    fecha_fin           timestamp with time zone,
    estado              boolean                  default true,
    id_tipo_proyecto    integer,
    id_hoja_seguimiento integer,
    id_grupo_asignado   integer,
    id_estado_proyecto  integer,
    created_by          integer,
    created_date        timestamp with time zone default CURRENT_TIMESTAMP,
    modified_by         integer,
    modified_date       timestamp with time zone
);

alter table proyecto
    owner to postgres;

create trigger trigger_actualizar_proyecto
    before update
    on proyecto
    for each row
execute procedure actualizar_modified_date();

grant delete, insert, references, select, trigger, truncate, update on proyecto to anon;

grant delete, insert, references, select, trigger, truncate, update on proyecto to authenticated;

grant delete, insert, references, select, trigger, truncate, update on proyecto to service_role;

