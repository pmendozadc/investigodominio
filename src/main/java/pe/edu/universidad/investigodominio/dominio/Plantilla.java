package pe.edu.universidad.investigodominio.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Plantilla {
    
    @Id
	private int id;
    private String nombre;
    private String idDocumentoSinMarcadores;
    private String idDocumentoConMarcadores;
    private String idDocumentoIstrucciones;
    private String created_by;
    private String created_date;
    private String modified_by;
    private String modified_date;
    private boolean state;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdDocumentoSinMarcadores() {
        return idDocumentoSinMarcadores;
    }

    public void setIdDocumentoSinMarcadores(String idDocumentoSinMarcadores) {
        this.idDocumentoSinMarcadores = idDocumentoSinMarcadores;
    }

    public String getIdDocumentoConMarcadores() {
        return idDocumentoConMarcadores;
    }

    public void setIdDocumentoConMarcadores(String idDocumentoConMarcadores) {
        this.idDocumentoConMarcadores = idDocumentoConMarcadores;
    }

    public String getIdDocumentoIstrucciones() {
        return idDocumentoIstrucciones;
    }

    public void setIdDocumentoIstrucciones(String idDocumentoIstrucciones) {
        this.idDocumentoIstrucciones = idDocumentoIstrucciones;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public String getCreated_date() {
        return created_date;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }

    public String getModified_by() {
        return modified_by;
    }

    public void setModified_by(String modified_by) {
        this.modified_by = modified_by;
    }

    public String getModified_date() {
        return modified_date;
    }

    public void setModified_date(String modified_date) {
        this.modified_date = modified_date;
    }

    public boolean isState() {
        return state;
    }
    
    public void setState(boolean state) {
        this.state = state;
    }
}
