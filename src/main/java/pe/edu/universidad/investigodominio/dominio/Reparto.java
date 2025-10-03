package pe.edu.universidad.investigodominio.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import org.hibernate.annotations.DynamicInsert;

import java.time.OffsetDateTime;

@Entity
@DynamicInsert
public class Reparto {
    @Id
    @GeneratedValue(generator="reparto_id_seq")
    @SequenceGenerator(name="reparto_id_seq",sequenceName="reparto_id_seq", allocationSize=1)
    private Integer id;
    private String datIdCarpetaReparto;
    private OffsetDateTime createdDate;
    private Integer createdBy;
    private OffsetDateTime modifiedDate;
    private Integer modifiedBy;
    private Integer idPlantilla;
    private Integer idGrupo;
    private Boolean activo;
    private Boolean estado;

    public Integer getId() {
        return id;
    }

    public String getIdCarpetaReparto() {
        return datIdCarpetaReparto;
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

    public Integer getIdGrupo() {
        return idGrupo;
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

    public void setIdCarpetaReparto(String datIdCarpetaReparto) {
        this.datIdCarpetaReparto = datIdCarpetaReparto;
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

    public void setIdGrupo(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
