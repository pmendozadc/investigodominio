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
    private Integer id;
    private String idCarpetaReparto;
    private OffsetDateTime createdDate;
    private Integer createdBy;
    private OffsetDateTime modifiedDate;
    private Integer modifiedBy;
    private Integer idPlantilla;
    private Boolean activo;
    private Boolean estado;

    public Integer getId() {
        return id;
    }

    public String getIdCarpetaReparto() {
        return idCarpetaReparto;
    }

    public OffsetDateTime getCreatedDate() {
        return createdDate;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public OffsetDateTime getModifiedDate() {
        return modifiedDate;
    }

    public Integer getModifiedBy() {
        return modifiedBy;
    }

    public Integer getIdPlatilla() {
        return idPlantilla;
    }

    public Boolean getActivo() {
        return activo;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setIdCarpetaReparto(String idCarpetaReparto) {
        this.idCarpetaReparto = idCarpetaReparto;
    }

    public void setCreatedDate(OffsetDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public void setModifiedDate(OffsetDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public void setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public void setIdPlatilla(Integer idPlantilla) {
        this.idPlantilla = idPlantilla;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
