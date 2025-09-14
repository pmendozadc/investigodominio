create table copia
(
    id            serial
        primary key,
    nombre        varchar(200),
    responsables  varchar(200),
    estado        boolean                  default true,
    created_by    integer,
    created_date  timestamp with time zone default CURRENT_TIMESTAMP,
    modified_by   integer,
    modified_date timestamp with time zone
);

alter table copia
    owner to postgres;

create trigger trg_copia_update
    before update
    on copia
    for each row
execute procedure establecer_modified_date();

grant delete, insert, references, select, trigger, truncate, update on copia to anon;

grant delete, insert, references, select, trigger, truncate, update on copia to authenticated;

grant delete, insert, references, select, trigger, truncate, update on copia to service_role;

