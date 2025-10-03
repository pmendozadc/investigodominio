package pe.edu.universidad.investigodominio.dominio;

import jakarta.persistence.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.time.OffsetDateTime;

@Entity
@DynamicInsert
@DynamicUpdate
public class EtiquetaPlantilla {

    @Id
    @GeneratedValue(generator = "etiqueta_plantilla_id_seq")
    @SequenceGenerator(name = "etiqueta_plantilla_id_seq", sequenceName = "etiqueta_plantilla_id_seq", allocationSize = 1)
    private Integer id;

    private Integer idPlantilla;
    private Integer idEtiqueta;
    private Boolean estado;
    private Integer createdBy;
    private OffsetDateTime createdDate;
    private Integer modifiedBy;
    private OffsetDateTime modifiedDate;

    public EtiquetaPlantilla() {}

    public EtiquetaPlantilla(Integer id, Integer idPlantilla, Integer idEtiqueta, Boolean estado,
                             Integer createdBy, OffsetDateTime createdDate,
                             Integer modifiedBy, OffsetDateTime modifiedDate) {
        this.id = id;
        this.idPlantilla = idPlantilla;
        this.idEtiqueta = idEtiqueta;
        this.estado = estado;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdPlantilla() {
        return idPlantilla;
    }
    public void setIdPlantilla(Integer idPlantilla) {
        this.idPlantilla = idPlantilla;
    }

    public Integer getIdEtiqueta() {
        return idEtiqueta;
    }
    public void setIdEtiqueta(Integer idEtiqueta) {
        this.idEtiqueta = idEtiqueta;
    }

    public Boolean getEstado() {
        return estado;
    }
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }
    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public OffsetDateTime getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(OffsetDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getModifiedBy() {
        return modifiedBy;
    }
    public void setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public OffsetDateTime getModifiedDate() {
        return modifiedDate;
    }
    public void setModifiedDate(OffsetDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
