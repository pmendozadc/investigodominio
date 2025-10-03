package pe.edu.universidad.investigodominio.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.OffsetDateTime;

@Entity
@DynamicInsert
public class Plantilla {
    @Id
    @GeneratedValue(generator="plantilla_id_seq")
    @SequenceGenerator(name="plantilla_id_seq",sequenceName="plantilla_id_seq", allocationSize=1)
    private Integer id;
    private String nombre;
    private String tipoDocumento;
    private String idDocumentoSinMarcadores;
    private String idDocumentoConMarcadores;
    private String idDocumentoInstrucciones;
    private OffsetDateTime createdDate;
    private Integer createdBy;
    private OffsetDateTime modifiedDate;
    private Integer modifiedBy;
    private Boolean activo;
    private Boolean estado;

    public Integer getId() {
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

    public Boolean getActivo() {
        return activo;
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

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}


