create function set_modified_timestamp() returns trigger
    language plpgsql
as
$$
BEGIN
  NEW.modified_date := CURRENT_TIMESTAMP;
  RETURN NEW;
END;
$$;

alter function set_modified_timestamp() owner to postgres;

grant execute on function set_modified_timestamp() to anon;

grant execute on function set_modified_timestamp() to authenticated;

grant execute on function set_modified_timestamp() to service_role;

