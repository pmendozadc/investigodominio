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
    private int id;
    private String nombre;
    private String idDocumento;
    private String idImagen;
    private OffsetDateTime createdDate;
    private int createdBy;
    private OffsetDateTime modifiedDate;
    private int modifiedBy;
    private Boolean estado;

    public int getId() {
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

    public int getCreatedBy() {
        return createdBy;
    }

    public OffsetDateTime getModifiedDate() {
        return modifiedDate;
    }

    public int getModifiedBy() {
        return modifiedBy;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setId(int id) {
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

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public void setModifiedDate(OffsetDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public void setModifiedBy(int modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
