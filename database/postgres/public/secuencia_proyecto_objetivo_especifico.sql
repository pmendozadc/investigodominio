create sequence secuencia_proyecto_objetivo_especifico
    minvalue 101
    maxvalue 999999;

alter sequence secuencia_proyecto_objetivo_especifico owner to postgres;

grant select, update, usage on sequence secuencia_proyecto_objetivo_especifico to anon;

grant select, update, usage on sequence secuencia_proyecto_objetivo_especifico to authenticated;

grant select, update, usage on sequence secuencia_proyecto_objetivo_especifico to service_role;

