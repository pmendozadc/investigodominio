package pe.edu.universidad.investigodominio.dominio;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.ZonedDateTime;

@Entity

@DynamicInsert
public class Cuenta {

    @Id
    @GeneratedValue(generator="cuenta_id_seq")
    @SequenceGenerator(name="cuenta_id_seq",sequenceName="cuenta_id_seq", allocationSize=1)

    private Integer id;

    @Column(name = "email")
    private String email;

    @Column(name = "nombre_completo")
    private String nombreCompleto;  // CamelCase

    @Column(name = "created_by")
    private Integer createdBy;  // CamelCase

    @CreationTimestamp
    @Column(name = "created_date", updatable = false)
    private ZonedDateTime createdDate;  // CamelCase + ZonedDateTime para TIMESTAMPTZ

    @Column(name = "modified_by")
    private Integer modifiedBy;  // CamelCase

    @UpdateTimestamp
    @Column(name = "modified_date")
    private ZonedDateTime modifiedDate;  // CamelCase + ZonedDateTime para TIMESTAMPTZ

    @Column(name = "estado")
    private Boolean estado;  // Columna para borrado lógico (DEFAULT true en BD)

    // Getters y Setters
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

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public ZonedDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(ZonedDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public ZonedDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(ZonedDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}