package pe.edu.universidad.investigodominio.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import org.hibernate.annotations.DynamicInsert;

import java.time.OffsetDateTime;

@Entity
@DynamicInsert
public class PlanTesisPorTarea {
    @Id
    @GeneratedValue(generator="plan_tesis_por_tarea_id_seq")
    @SequenceGenerator(name="plan_tesis_por_tarea_id_seq",sequenceName="plan_tesis_por_tarea_id_seq", allocationSize=1)
    private Integer id;
    
    private String titulo;
    private String tema;
    private String area;
    private String datClaseId;
    private String nombreClase;
    private String docente;
    private String semestre;
    private Integer anio;
    private String estadoRevision;
    private String observaciones;
    private OffsetDateTime fechaEntrega;
    private OffsetDateTime fechaExtraccion;
    private String documentoTipo;
    private String datDocumentoUrl;
    private String documentoEstado;
    private String tareaNombre;
    private String datTareaId;
    private String estudianteCuenta;
    private String idTipoOrigen;
    
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
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTema() {
		return tema;
	}
	public void setTema(String tema) {
		this.tema = tema;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getDatClaseId() {
		return datClaseId;
	}
	public void setDatClaseId(String datClaseId) {
		this.datClaseId = datClaseId;
	}
	public String getNombreClase() {
		return nombreClase;
	}
	public void setNombreClase(String nombreClase) {
		this.nombreClase = nombreClase;
	}
	public String getDocente() {
		return docente;
	}
	public void setDocente(String docente) {
		this.docente = docente;
	}
	public String getSemestre() {
		return semestre;
	}
	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}
	public Integer getAnio() {
		return anio;
	}
	public void setAnio(Integer anio) {
		this.anio = anio;
	}
	public String getEstadoRevision() {
		return estadoRevision;
	}
	public void setEstadoRevision(String estadoRevision) {
		this.estadoRevision = estadoRevision;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public OffsetDateTime getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(OffsetDateTime fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	public OffsetDateTime getFechaExtraccion() {
		return fechaExtraccion;
	}
	public void setFechaExtraccion(OffsetDateTime fechaExtraccion) {
		this.fechaExtraccion = fechaExtraccion;
	}
	public String getDocumentoTipo() {
		return documentoTipo;
	}
	public void setDocumentoTipo(String documentoTipo) {
		this.documentoTipo = documentoTipo;
	}
	public String getDatDocumentoUrl() {
		return datDocumentoUrl;
	}
	public void setDatDocumentoUrl(String datDocumentoUrl) {
		this.datDocumentoUrl = datDocumentoUrl;
	}
	public String getDocumentoEstado() {
		return documentoEstado;
	}
	public void setDocumentoEstado(String documentoEstado) {
		this.documentoEstado = documentoEstado;
	}
	public String getTareaNombre() {
		return tareaNombre;
	}
	public void setTareaNombre(String tareaNombre) {
		this.tareaNombre = tareaNombre;
	}
	public String getDatTareaId() {
		return datTareaId;
	}
	public void setDatTareaId(String datTareaId) {
		this.datTareaId = datTareaId;
	}
	public String getEstudianteCuenta() {
		return estudianteCuenta;
	}
	public void setEstudianteCuenta(String estudianteCuenta) {
		this.estudianteCuenta = estudianteCuenta;
	}
	public String getIdTipoOrigen() {
		return idTipoOrigen;
	}
	public void setIdTipoOrigen(String idTipoOrigen) {
		this.idTipoOrigen = idTipoOrigen;
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
