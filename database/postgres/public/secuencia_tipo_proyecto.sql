create sequence secuencia_tipo_proyecto
    minvalue 101
    maxvalue 999999;

alter sequence secuencia_tipo_proyecto owner to postgres;

grant select, update, usage on sequence secuencia_tipo_proyecto to anon;

grant select, update, usage on sequence secuencia_tipo_proyecto to authenticated;

grant select, update, usage on sequence secuencia_tipo_proyecto to service_role;

