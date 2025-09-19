CREATE OR REPLACE FUNCTION establecer_modified_date()
RETURNS TRIGGER AS $$
BEGIN
  NEW.modified_date = (CURRENT_TIMESTAMP AT TIME ZONE 'America/Lima')::timestamptz;
  RETURN NEW;
END;
$$ LANGUAGE plpgsql;

--INSERT
CREATE OR REPLACE TRIGGER trg_copia_insert
BEFORE INSERT ON copia
FOR EACH ROW
EXECUTE FUNCTION establecer_created_date();

CREATE OR REPLACE TRIGGER trg_historial_copia_insert
BEFORE INSERT ON historial_copia
FOR EACH ROW
EXECUTE FUNCTION establecer_created_date();

CREATE OR REPLACE TRIGGER trg_relacion_reparto_copia_insert
BEFORE INSERT ON relacion_reparto_copia
FOR EACH ROW
EXECUTE FUNCTION establecer_created_date();

--UPDATE
CREATE OR REPLACE TRIGGER trg_copia_update
BEFORE UPDATE ON copia
FOR EACH ROW
EXECUTE FUNCTION establecer_modified_date();

CREATE OR REPLACE TRIGGER trg_historial_copia_update
BEFORE UPDATE ON historial_copia
FOR EACH ROW
EXECUTE FUNCTION establecer_modified_date();

CREATE OR REPLACE TRIGGER trg_relacion_reparto_copia_update
BEFORE UPDATE ON relacion_reparto_copia
FOR EACH ROW
EXECUTE FUNCTION establecer_modified_date();
