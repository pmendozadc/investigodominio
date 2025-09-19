package pe.edu.universidad.investigodominio.dominio;

import jakarta.persistence.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.time.OffsetDateTime;

@Table(name = "relacion_reparto_copia")
@Entity
@DynamicInsert
@DynamicUpdate
public class RelacionRepartoCopia {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "relacion_reparto_copia_id_seq")
    @SequenceGenerator(name = "relacion_reparto_copia_id_seq", sequenceName = "relacion_reparto_copia_id_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "email")
    private String email;
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
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