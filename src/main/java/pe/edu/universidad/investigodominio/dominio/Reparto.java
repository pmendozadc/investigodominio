package pe.edu.universidad.investigodominio.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.OffsetDateTime;

@Entity
public class Reparto {
    @Id
    private int id;
    private String idCarpetaReparto;
    private OffsetDateTime createdDate;
    private String createdBy;
    private OffsetDateTime modifiedDate;
    private String modifiedBy;
    private int idPlatilla;
    private boolean activo;
    private boolean estado;

    public int getId() {
        return id;
    }

    public String getIdCarpetaReparto() {
        return idCarpetaReparto;
    }

    public OffsetDateTime getCreatedDate() {
        return createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public OffsetDateTime getModifiedDate() {
        return modifiedDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public int getIdPlatilla() {
        return idPlatilla;
    }

    public boolean getActivo() {
        return activo;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdCarpetaReparto(String idCarpetaReparto) {
        this.idCarpetaReparto = idCarpetaReparto;
    }

    public void setCreatedDate(OffsetDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public void setModifiedDate(OffsetDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public void setIdPlatilla(int idPlatilla) {
        this.idPlatilla = idPlatilla;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
