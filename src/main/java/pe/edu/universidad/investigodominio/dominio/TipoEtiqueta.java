package pe.edu.universidad.investigodominio.dominio;

import jakarta.persistence.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import java.time.ZonedDateTime;

@Entity
@DynamicInsert
@DynamicUpdate
public class TipoEtiqueta {

    @Id
    @GeneratedValue(generator="tipo_etiqueta_id_seq")
    @SequenceGenerator(name="tipo_etiqueta_id_seq", sequenceName="tipo_etiqueta_id_seq", allocationSize=1)
    private Integer id;

    private String nombre;
    private Boolean estado;
    private Integer createdBy;
    private ZonedDateTime createdDate;
    private Integer modifiedBy;
    private ZonedDateTime modifiedDate;

    public TipoEtiqueta() {
    }

    public TipoEtiqueta(Integer id, String nombre, Boolean estado, Integer createdBy, ZonedDateTime createdDate, Integer modifiedBy, ZonedDateTime modifiedDate) {
        this.id = id;
        this.nombre = nombre;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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