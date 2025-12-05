package pe.edu.universidad.investigodominio.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import org.hibernate.annotations.DynamicInsert;

import java.time.LocalDate;
import java.time.OffsetDateTime;

@Entity
@DynamicInsert
public class ConcursoPostulacionDocumento {
    @Id
    @GeneratedValue(generator="concurso_postulacion_documento_id_seq")
    @SequenceGenerator(name="concurso_postulacion_documento_id_seq",sequenceName="concurso_postulacion_documento_id_seq", allocationSize=1)
    private Integer id;
    
    private Integer idPostulacion;
    private String nombreDocumento;
    private String datArchivoUrl;
    private String tipo;
    private Double tamanioKb;
    
    private OffsetDateTime createdDate;
    private Integer createdBy;
    private OffsetDateTime modifiedDate;
    private Integer modifiedBy;
    private Boolean estado;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdPostulacion() {
		return idPostulacion;
	}
	public void setIdPostulacion(Integer idPostulacion) {
		this.idPostulacion = idPostulacion;
	}
	public String getNombreDocumento() {
		return nombreDocumento;
	}
	public void setNombreDocumento(String nombreDocumento) {
		this.nombreDocumento = nombreDocumento;
	}
	public String getDatArchivoUrl() {
		return datArchivoUrl;
	}
	public void setDatArchivoUrl(String datArchivoUrl) {
		this.datArchivoUrl = datArchivoUrl;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Double getTamanioKb() {
		return tamanioKb;
	}
	public void setTamanioKb(Double tamanioKb) {
		this.tamanioKb = tamanioKb;
	}
	public OffsetDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(OffsetDateTime createdDate) {
		this.createdDate = createdDate;
	}
	public Integer getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	public OffsetDateTime getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(OffsetDateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public Integer getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
    
    
}
