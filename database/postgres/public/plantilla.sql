create table plantilla
(
    id                          serial
        primary key,
    nombre                      varchar(200),
    tipo_documento              varchar(200),
    id_documento_sin_marcadores varchar(200),
    id_documento_con_marcadores varchar(200),
    id_documento_instrucciones  varchar(200),
    fecha_creacion              timestamp with time zone default CURRENT_TIMESTAMP,
    created_date                timestamp with time zone default CURRENT_TIMESTAMP,
    created_by                  varchar(200),
    modified_date               timestamp with time zone,
    modified_by                 varchar(200),
    activo                      boolean                  default true not null,
    estado                      boolean                  default true not null
);

alter table plantilla
    owner to postgres;

create index idx_plantilla_doc_sin
    on plantilla (id_documento_sin_marcadores);

create index idx_plantilla_doc_con
    on plantilla (id_documento_con_marcadores);

create index idx_plantilla_doc_inst
    on plantilla (id_documento_instrucciones);

create trigger trg_plantilla_update
    before update
    on plantilla
    for each row
execute procedure establecer_modified_date();

create trigger trg_plantilla_modified
    before update
    on plantilla
    for each row
execute procedure set_modified_date();

grant delete, insert, references, select, trigger, truncate, update on plantilla to anon;

grant delete, insert, references, select, trigger, truncate, update on plantilla to authenticated;

grant delete, insert, references, select, trigger, truncate, update on plantilla to service_role;

