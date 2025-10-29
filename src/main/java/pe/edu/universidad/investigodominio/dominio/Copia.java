package pe.edu.universidad.investigodominio.dominio;

import jakarta.persistence.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import java.time.ZonedDateTime;

@Entity
@DynamicInsert
@DynamicUpdate
public class Copia {

    @Id
    @GeneratedValue(generator="copia_id_seq")
    @SequenceGenerator(name="copia_id_seq", sequenceName="copia_id_seq", allocationSize=1)
    private Integer id;

    private String nombre;
    private String responsables;
    private String datIdDocumento;
    private Integer idReparto;
    private Boolean estado;
    private Integer createdBy;
    private ZonedDateTime createdDate;
    private Integer modifiedBy;
    private ZonedDateTime modifiedDate;

    private Boolean activo;

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Boolean getActivo() {
        return activo;
    }

    public Copia() {
    }

    public Copia(Integer id, String nombre, String responsables, String datIdDocumento, Integer idReparto, Boolean estado, Integer createdBy, ZonedDateTime createdDate, Integer modifiedBy, ZonedDateTime modifiedDate) {
        this.id = id;
        this.nombre = nombre;
        this.responsables = responsables;
        this.datIdDocumento = datIdDocumento;
        this.idReparto = idReparto;
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

    public String getResponsables() {
        return responsables;
    }

    public void setResponsables(String responsables) {
        this.responsables = responsables;
    }

    public String getDatIdDocumento() {
        return datIdDocumento;
    }

    public void setDatIdDocumento(String datIdDocumento) {
        this.datIdDocumento = datIdDocumento;
    }

    public Integer getIdReparto() {
        return idReparto;
    }

    public void setIdReparto(Integer idReparto) {
        this.idReparto = idReparto;
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