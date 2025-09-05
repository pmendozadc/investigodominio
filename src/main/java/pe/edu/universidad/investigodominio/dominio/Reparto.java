package pe.edu.universidad.investigodominio.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Reparto {
    
    @Id
	private int id;
    private String idCarpetaReparto;
    private String created_by;
    private String created_date;
    private String modified_by;
    private String modified_date;
    private int idPlatilla;
    private boolean state;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdCarpetaReparto() {
        return idCarpetaReparto;
    }

    public void setIdCarpetaReparto(String idCarpetaReparto) {
        this.idCarpetaReparto = idCarpetaReparto;
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

    public int getIdPlatilla() {
        return idPlatilla;
    }

    public void setIdPlatilla(int idPlatilla) {
        this.idPlatilla = idPlatilla;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
