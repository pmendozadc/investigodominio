create function actualizar_modified_date() returns trigger
    language plpgsql
as
$$
BEGIN
    RAISE NOTICE 'Trigger activado: actualizar_modified_date';
    NEW.modified_date = (CURRENT_TIMESTAMP AT TIME ZONE 'America/Lima')::timestamptz;
    RETURN NEW;
END;
$$;

alter function actualizar_modified_date() owner to postgres;

grant execute on function actualizar_modified_date() to anon;

grant execute on function actualizar_modified_date() to authenticated;

grant execute on function actualizar_modified_date() to service_role;

