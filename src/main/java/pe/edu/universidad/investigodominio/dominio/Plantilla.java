package pe.edu.universidad.investigodominio.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import org.hibernate.annotations.DynamicInsert;

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
    private String datIdDocumentoSinMarcadores;
    private String datIdDocumentoConMarcadores;
    private String datIdDocumentoInstrucciones;
    private OffsetDateTime createdDate;
    private Integer createdBy;
    private OffsetDateTime modifiedDate;
    private Integer modifiedBy;
    private Boolean activo;
    private Boolean estado;
    private String datIdCarpeta;

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
        return datIdDocumentoSinMarcadores;
    }

    public String getIdDocumentoConMarcadores() {
        return datIdDocumentoConMarcadores;
    }

    public String getIdDocumentoInstrucciones() {
        return datIdDocumentoInstrucciones;
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

    public void setIdDocumentoSinMarcadores(String datIdDocumentoSinMarcadores) {
        this.datIdDocumentoSinMarcadores = datIdDocumentoSinMarcadores;
    }

    public void setIdDocumentoConMarcadores(String datIdDocumentoConMarcadores) {
        this.datIdDocumentoConMarcadores = datIdDocumentoConMarcadores;
    }

    public void setIdDocumentoInstrucciones(String datIdDocumentoInstrucciones) {
        this.datIdDocumentoInstrucciones = datIdDocumentoInstrucciones;
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


