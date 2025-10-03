package pe.edu.universidad.investigodominio.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.OffsetDateTime;

@Entity
@DynamicInsert
public class Informe {
    @Id
    @GeneratedValue(generator="informe_id_seq")
    @SequenceGenerator(name="informe_id_seq",sequenceName="informe_id_seq", allocationSize=1)
    private Integer id;
    private String nombre;
    private String idDocumento;
    private String idImagen;
    private OffsetDateTime createdDate;
    private Integer createdBy;
    private OffsetDateTime modifiedDate;
    private Integer modifiedBy;
    private Boolean estado;

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getIdDocumento() {
        return idDocumento;
    }

    public String getIdImagen() {
        return idImagen;
    }

    public OffsetDateTime getCreatedDate() {
        return createdDate;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public OffsetDateTime getModifiedDate() {
        return modifiedDate;
    }

    public Integer getModifiedBy() {
        return modifiedBy;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIdDocumento(String idDocumento) {
        this.idDocumento = idDocumento;
    }

    public void setIdImagen(String idImagen) {
        this.idImagen = idImagen;
    }

    public void setCreatedDate(OffsetDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public void setModifiedDate(OffsetDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public void setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
