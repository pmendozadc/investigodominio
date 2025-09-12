package pe.edu.universidad.investigodominio.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.OffsetDateTime;

@Entity
public class Plantilla {
    @Id
    private int id;
    private String nombre;
    private String tipoDocumento;
    private String idDocumentoSinMarcadores;
    private String idDocumentoConMarcadores;
    private String idDocumentoInstrucciones;
    private OffsetDateTime fechaCreacion;
    private OffsetDateTime createdDate;
    private String createdBy;
    private OffsetDateTime modifiedDate;
    private String modifiedBy;
    private boolean activo;
    private boolean estado;

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public String getIdDocumentoSinMarcadores() {
        return idDocumentoSinMarcadores;
    }

    public String getIdDocumentoConMarcadores() {
        return idDocumentoConMarcadores;
    }

    public String getIdDocumentoInstrucciones() {
        return idDocumentoInstrucciones;
    }

    public OffsetDateTime getFechaCreacion() {
        return fechaCreacion;
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

    public boolean getActivo() {
        return activo;
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

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public void setIdDocumentoSinMarcadores(String idDocumentoSinMarcadores) {
        this.idDocumentoSinMarcadores = idDocumentoSinMarcadores;
    }

    public void setIdDocumentoConMarcadores(String idDocumentoConMarcadores) {
        this.idDocumentoConMarcadores = idDocumentoConMarcadores;
    }

    public void setIdDocumentoInstrucciones(String idDocumentoInstrucciones) {
        this.idDocumentoInstrucciones = idDocumentoInstrucciones;
    }

    public void setFechaCreacion(OffsetDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
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

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}


