create function establecer_modified_date_rodrigo() returns trigger
    language plpgsql
as
$$
BEGIN
  NEW.modified_date = (CURRENT_TIMESTAMP AT TIME ZONE 'America/Lima')::timestamptz;
  RETURN NEW;
END;
$$;

alter function establecer_modified_date_rodrigo() owner to postgres;

grant execute on function establecer_modified_date_rodrigo() to anon;

grant execute on function establecer_modified_date_rodrigo() to authenticated;

grant execute on function establecer_modified_date_rodrigo() to service_role;

