package pe.edu.universidad.investigodominio.dominio;

import jakarta.persistence.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.time.OffsetDateTime;

@Table(name = "proyecto_objetivo_especifico")
@Entity
@DynamicInsert
@DynamicUpdate
public class ProyectoObjetivoEspecifico {

    @Id
    @GeneratedValue(generator = "proyecto_objetivo_especifico_id_seq")
    @SequenceGenerator(
            name = "proyecto_objetivo_especifico_id_seq",
            sequenceName = "proyecto_objetivo_especifico_id_seq",
            allocationSize = 1
    )
    @Column(name = "id")
    private Integer id;

    @Column(name = "objetivo_especifico")
    private String objetivoEspecifico;
    @Column(name = "estado")
    private Boolean estado;

    // Foreign keys
    @Column(name = "id_proyecto")
    private Integer idProyecto;

    @Column(name = "created_by")
    private Integer createdBy;
    @Column(name = "created_date")
    private OffsetDateTime createdDate;
    @Column(name = "modified_by")
    private Integer modifiedBy;
    @Column(name = "modified_date")
    private OffsetDateTime modifiedDate;

    public Integer getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getObjetivoEspecifico() {
        return objetivoEspecifico;
    }

    public void setObjetivoEspecifico(String objetivoEspecifico) {
        this.objetivoEspecifico = objetivoEspecifico;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Integer getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
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

    public OffsetDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(OffsetDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public ProyectoObjetivoEspecifico() {

    }

    public ProyectoObjetivoEspecifico(
            String objetivoEspecifico,
            Integer idProyecto
    ) {
        this.objetivoEspecifico = objetivoEspecifico;
        this.idProyecto = idProyecto;
    }
}
