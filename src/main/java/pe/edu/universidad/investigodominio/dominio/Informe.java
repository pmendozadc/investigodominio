package pe.edu.universidad.investigodominio.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.OffsetDateTime;

@Entity
public class Informe {
    @Id
    private int id;
    private String nombre;
    private String idDocumento;
    private String idImagen;
    private OffsetDateTime createdDate;
    private String createdBy;
    private OffsetDateTime modifiedDate;
    private String modifiedBy;
    private boolean estado;

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

    public String getCreatedBy() {
        return createdBy;
    }

    public OffsetDateTime getModifiedDate() {
        return modifiedDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public boolean getEstado() {
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

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public void setModifiedDate(OffsetDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
