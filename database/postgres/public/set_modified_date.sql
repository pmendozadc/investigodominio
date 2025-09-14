create function set_modified_date() returns trigger
    language plpgsql
as
$$
BEGIN
  NEW.modified_date = (CURRENT_TIMESTAMP AT TIME ZONE 'America/Lima')::timestamptz;
  RETURN NEW;
END;
$$;

alter function set_modified_date() owner to postgres;

grant execute on function set_modified_date() to anon;

grant execute on function set_modified_date() to authenticated;

grant execute on function set_modified_date() to service_role;

