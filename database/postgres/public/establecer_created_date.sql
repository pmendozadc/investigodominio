create function establecer_created_date() returns trigger
    language plpgsql
as
$$
BEGIN
  NEW.created_date = (CURRENT_TIMESTAMP AT TIME ZONE 'America/Lima')::timestamptz;
  RETURN NEW;
END;
$$;

alter function establecer_created_date() owner to postgres;

grant execute on function establecer_created_date() to anon;

grant execute on function establecer_created_date() to authenticated;

grant execute on function establecer_created_date() to service_role;

