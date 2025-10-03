create sequence secuencia_proyecto
    minvalue 101
    maxvalue 999999;

alter sequence secuencia_proyecto owner to postgres;

grant select, update, usage on sequence secuencia_proyecto to anon;

grant select, update, usage on sequence secuencia_proyecto to authenticated;

grant select, update, usage on sequence secuencia_proyecto to service_role;

