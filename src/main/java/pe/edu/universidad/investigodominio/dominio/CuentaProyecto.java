package pe.edu.universidad.investigodominio.dominio;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.ZonedDateTime;

@Entity
@DynamicInsert
public class CuentaProyecto {

    @Id
    @GeneratedValue(generator="cuenta_proyecto_id_seq")
    @SequenceGenerator(name="cuenta_proyecto_id_seq",sequenceName="cuenta_proyecto_id_seq", allocationSize=1)

    private Integer id;

    @Column(name = "id_cuenta")
    private Integer idCuenta;

    @Column(name = "id_proyecto")
    private Integer idProyecto;  // CamelCase (era id_proyecto)

    @Column(name = "estado")
    private Boolean estado;  // Ahora es Boolean (ya convertimos en BD)

    @Column(name = "created_by")
    private Integer createdBy;  // CamelCase

    @CreationTimestamp
    @Column(name = "created_date", updatable = false)
    private ZonedDateTime createdDate;  // CamelCase + ZonedDateTime

    @Column(name = "modified_by")
    private Integer modifiedBy;  // CamelCase

    @UpdateTimestamp
    @Column(name = "modified_date")
    private ZonedDateTime modifiedDate;  // CamelCase + ZonedDateTime

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Integer idCuenta) {
        this.idCuenta = idCuenta;
    }

    public Integer getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
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
}