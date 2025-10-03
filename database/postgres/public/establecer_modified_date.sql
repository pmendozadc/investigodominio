create function establecer_modified_date() returns trigger
    language plpgsql
as
$$
BEGIN
  NEW.modified_date = (CURRENT_TIMESTAMP AT TIME ZONE 'America/Lima')::timestamptz;
  RETURN NEW;
END;
$$;

alter function establecer_modified_date() owner to postgres;

grant execute on function establecer_modified_date() to anon;

grant execute on function establecer_modified_date() to authenticated;

grant execute on function establecer_modified_date() to service_role;

