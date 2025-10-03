package pe.edu.universidad.investigodominio.dominio;

import jakarta.persistence.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.time.OffsetDateTime;

@Entity
@DynamicInsert
@DynamicUpdate
public class Parametro {

    @Id
    @GeneratedValue(generator = "parametro_id_seq")
    @SequenceGenerator(name = "parametro_id_seq", sequenceName = "parametro_id_seq", allocationSize = 1)
    private Integer id;

    private String nombre;
    private String datValor;
    private Boolean estado;
    private Integer createdBy;
    private OffsetDateTime createdDate;
    private Integer modifiedBy;
    private OffsetDateTime modifiedDate;

    public Parametro() {}

    public Parametro(Integer id, String nombre, String datValor, Boolean estado,
                     Integer createdBy, OffsetDateTime createdDate,
                     Integer modifiedBy, OffsetDateTime modifiedDate) {
        this.id = id;
        this.nombre = nombre;
        this.datValor = datValor;
        this.estado = estado;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
    }

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

    public String getDatValor() {
        return datValor;
    }
    public void setDatValor(String datValor) {
        this.datValor = datValor;
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
