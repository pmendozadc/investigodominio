package pe.edu.universidad.investigodominio.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.OffsetDateTime;

@Entity
@DynamicInsert
public class Reparto {
    @Id
    @GeneratedValue(generator="reparto_id_seq")
    @SequenceGenerator(name="reparto_id_seq",sequenceName="reparto_id_seq", allocationSize=1)
    private int id;
    private String idCarpetaReparto;
    private OffsetDateTime createdDate;
    private int createdBy;
    private OffsetDateTime modifiedDate;
    private int modifiedBy;
    private int idPlatilla;
    private Boolean activo;
    private Boolean estado;

    public int getId() {
        return id;
    }

    public String getIdCarpetaReparto() {
        return idCarpetaReparto;
    }

    public OffsetDateTime getCreatedDate() {
        return createdDate;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public OffsetDateTime getModifiedDate() {
        return modifiedDate;
    }

    public int getModifiedBy() {
        return modifiedBy;
    }

    public int getIdPlatilla() {
        return idPlatilla;
    }

    public Boolean getActivo() {
        return activo;
    }

    public Boolean getEstado() {
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

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public void setModifiedDate(OffsetDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public void setModifiedBy(int modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public void setIdPlatilla(int idPlatilla) {
        this.idPlatilla = idPlatilla;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
