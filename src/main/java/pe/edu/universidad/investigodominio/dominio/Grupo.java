package pe.edu.universidad.investigodominio.dominio;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.ZonedDateTime;

@Entity
@DynamicInsert
@DynamicUpdate
public class Grupo {

    @Id
    @GeneratedValue(generator="grupo_id_seq")
    @SequenceGenerator(name="grupo_id_seq",sequenceName="grupo_id_seq", allocationSize=1)

    private Integer id;
    private String nombre;
    private Boolean estado = true;  // Ahora es Boolean (ya convertimos en BD)
    private Integer datIdCarpeta;  // CamelCase (era id_carpeta)
    private Integer createdBy;  // CamelCase
    private ZonedDateTime createdDate;  // CamelCase + ZonedDateTime
    private Integer modifiedBy;  // CamelCase
    private ZonedDateTime modifiedDate;  // CamelCase + ZonedDateTime

    public Grupo() {

    }

    public Grupo(String nombre, Integer id, Boolean estado, Integer datIdCarpeta, Integer createdBy, ZonedDateTime createdDate, Integer modifiedBy, ZonedDateTime modifiedDate) {
        this.nombre = nombre;
        this.id = id;
        this.estado = estado;
        this.datIdCarpeta = datIdCarpeta;
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

    public Integer getIdCarpeta() {
        return datIdCarpeta;
    }

    public void setIdCarpeta(Integer idCarpeta) {
        this.datIdCarpeta = idCarpeta;
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