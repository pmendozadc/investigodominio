package pe.edu.universidad.investigodominio.dominio;

import jakarta.persistence.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import java.time.ZonedDateTime;

@Entity
@Table(name = "grupo")  // Agregar esto
@DynamicInsert
@DynamicUpdate
public class Grupo {

    @Id
    @GeneratedValue(generator="grupo_id_seq")
    @SequenceGenerator(name="grupo_id_seq", sequenceName="grupo_id_seq", allocationSize=1)

    private Integer id;
    private String nombre;
    private Boolean estado = true;
    private String datIdCarpeta;
    private Integer createdBy;
    private ZonedDateTime createdDate;
    private Integer modifiedBy;
    private ZonedDateTime modifiedDate;

    public Grupo() {
    }

    public Grupo(String nombre, Integer id, Boolean estado, String datIdCarpeta,
                 Integer createdBy, ZonedDateTime createdDate,
                 Integer modifiedBy, ZonedDateTime modifiedDate) {
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

    public String getDatIdCarpeta() {  // ⭐ Cambia el nombre del getter
        return datIdCarpeta;
    }

    public void setDatIdCarpeta(String datIdCarpeta) {  // ⭐ Cambia el nombre del setter
        this.datIdCarpeta = datIdCarpeta;
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