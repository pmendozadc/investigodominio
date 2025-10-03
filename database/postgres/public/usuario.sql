create table usuario
(
    id            serial
        primary key,
    nombre        varchar(255) not null,
    apellido      varchar(255) not null,
    dni           varchar(50)  not null,
    email         varchar(255) not null,
    estado        boolean                  default true,
    created_date  timestamp with time zone default CURRENT_TIMESTAMP,
    created_by    integer
        constraint fk_usuario_created_by
            references usuario,
    modified_date timestamp with time zone,
    modified_by   integer
        constraint fk_usuario_modified_by
            references usuario,
    rol_id        integer
        references rol
);

alter table usuario
    owner to postgres;

create trigger trg_usuario_update
    before update
    on usuario
    for each row
execute procedure establecer_modified_date();

grant delete, insert, references, select, trigger, truncate, update on usuario to anon;

grant delete, insert, references, select, trigger, truncate, update on usuario to authenticated;

grant delete, insert, references, select, trigger, truncate, update on usuario to service_role;

