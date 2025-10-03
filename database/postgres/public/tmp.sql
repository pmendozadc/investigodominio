create table tmp
(
    id            integer not null
        primary key,
    nombre        varchar(200),
    created_by    integer,
    created_date  timestamp with time zone,
    modified_by   integer,
    modified_date timestamp with time zone
);

alter table tmp
    owner to postgres;

create trigger trg_tmp_insert
    before insert
    on tmp
    for each row
execute procedure establecer_created_date();

create trigger trg_tmp_update
    before update
    on tmp
    for each row
execute procedure establecer_modified_date();

grant delete, insert, references, select, trigger, truncate, update on tmp to anon;

grant delete, insert, references, select, trigger, truncate, update on tmp to authenticated;

grant delete, insert, references, select, trigger, truncate, update on tmp to service_role;

