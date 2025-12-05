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
public class ConcursoPostulacion {
    @Id
    @GeneratedValue(generator="concurso_postulacion_id_seq")
    @SequenceGenerator(name="concurso_postulacion_id_seq",sequenceName="concurso_postulacion_id_seq", allocationSize=1)
    private Integer id;
    
    private Integer idConcurso;
    private String codigo;
    private String titulo;
    private String resumen;
    private String datDocumentoUrl;
    private String datSheetUrl;
    private Integer duracionMeses;
    private Double presupuesto;
    private String estadoPostulacion;
    private OffsetDateTime fechaPostulacion;
    
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
	public Integer getIdConcurso() {
		return idConcurso;
	}
	public void setIdConcurso(Integer idConcurso) {
		this.idConcurso = idConcurso;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getResumen() {
		return resumen;
	}
	public void setResumen(String resumen) {
		this.resumen = resumen;
	}
	public String getDatDocumentoUrl() {
		return datDocumentoUrl;
	}
	public void setDatDocumentoUrl(String datDocumentoUrl) {
		this.datDocumentoUrl = datDocumentoUrl;
	}
	public String getDatSheetUrl() {
		return datSheetUrl;
	}
	public void setDatSheetUrl(String datSheetUrl) {
		this.datSheetUrl = datSheetUrl;
	}
	public Integer getDuracionMeses() {
		return duracionMeses;
	}
	public void setDuracionMeses(Integer duracionMeses) {
		this.duracionMeses = duracionMeses;
	}
	public Double getPresupuesto() {
		return presupuesto;
	}
	public void setPresupuesto(Double presupuesto) {
		this.presupuesto = presupuesto;
	}
	public String getEstadoPostulacion() {
		return estadoPostulacion;
	}
	public void setEstadoPostulacion(String estadoPostulacion) {
		this.estadoPostulacion = estadoPostulacion;
	}
	public OffsetDateTime getFechaPostulacion() {
		return fechaPostulacion;
	}
	public void setFechaPostulacion(OffsetDateTime fechaPostulacion) {
		this.fechaPostulacion = fechaPostulacion;
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
