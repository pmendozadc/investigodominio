package pe.edu.universidad.investigodominio.dominio;

import jakarta.persistence.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import java.time.ZonedDateTime;

@Entity
@DynamicInsert
@DynamicUpdate
public class CuentaProyecto {

    @Id
    @GeneratedValue(generator = "cuenta_proyecto_id_seq")
    @SequenceGenerator(name = "cuenta_proyecto_id_seq", sequenceName = "cuenta_proyecto_id_seq", allocationSize = 1)
    private Integer id;

    private Integer idProyecto;
    private Integer idCuenta;
    private Boolean estado;
    private Integer createdBy;
    private ZonedDateTime createdDate;
    private Integer modifiedBy;
    private ZonedDateTime modifiedDate;

    public CuentaProyecto() {
    }

    public CuentaProyecto(Integer id, Integer idProyecto, Integer idCuenta, Boolean estado, Integer createdBy, ZonedDateTime createdDate, Integer modifiedBy, ZonedDateTime modifiedDate) {
        this.id = id;
        this.idProyecto = idProyecto;
        this.idCuenta = idCuenta;
        this.estado = estado;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    public Integer getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Integer idCuenta) {
        this.idCuenta = idCuenta;
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

}