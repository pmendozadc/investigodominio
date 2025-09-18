package pe.edu.universidad.investigodominio.dominio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.DynamicInsert;

import java.time.OffsetDateTime;

@Table(name = "copia")
@Entity
@DynamicInsert
public class Copia {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "responsables")
    private String responsables;
    @Column(name = "estado")
    private Boolean estado;

    @Column(name = "created_by")
    private Integer createdBy;
    @Column(name = "created_date")
    private OffsetDateTime createdDate;
    @Column(name = "modified_by")
    private Integer modifiedBy;
    @Column(name = "modified_date")
    private OffsetDateTime modifiedDate;


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getResponsables() {
        return responsables;
    }
    public void setResponsables(String responsables) {
        this.responsables = responsables;
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