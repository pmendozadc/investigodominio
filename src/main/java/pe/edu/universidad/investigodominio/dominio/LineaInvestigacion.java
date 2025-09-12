package pe.edu.universidad.investigodominio.dominio;

import java.time.OffsetDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class LineaInvestigacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;

    private Boolean estado = true;

    private Integer createdBy;

    private OffsetDateTime createdDate;

    private Integer modifiedBy;

    private OffsetDateTime modifiedDate;

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
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
