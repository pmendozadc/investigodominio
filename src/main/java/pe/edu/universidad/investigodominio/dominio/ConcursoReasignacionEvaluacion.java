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
public class ConcursoReasignacionEvaluacion {
    @Id
    @GeneratedValue(generator="concurso_reasignacion_evaluacion_id_seq")
    @SequenceGenerator(name="concurso_reasignacion_evaluacion_id_seq",sequenceName="concurso_reasignacion_evaluacion_id_seq", allocationSize=1)
    private Integer id;
    
    private Integer idAsignacionAnterior;
    private Integer idEvaluadorAnterior;
    private Integer idPostulacion;
    private String motivoReasignacion;
    private String descripcionMotivo;
    private String datDocumentoUrl;
    private Integer idAsignacionNueva;
    private Integer reasignadoPor;
    private OffsetDateTime fechaReasignacion;
    
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
	public Integer getIdAsignacionAnterior() {
		return idAsignacionAnterior;
	}
	public void setIdAsignacionAnterior(Integer idAsignacionAnterior) {
		this.idAsignacionAnterior = idAsignacionAnterior;
	}
	public Integer getIdEvaluadorAnterior() {
		return idEvaluadorAnterior;
	}
	public void setIdEvaluadorAnterior(Integer idEvaluadorAnterior) {
		this.idEvaluadorAnterior = idEvaluadorAnterior;
	}
	public Integer getIdPostulacion() {
		return idPostulacion;
	}
	public void setIdPostulacion(Integer idPostulacion) {
		this.idPostulacion = idPostulacion;
	}
	public String getMotivoReasignacion() {
		return motivoReasignacion;
	}
	public void setMotivoReasignacion(String motivoReasignacion) {
		this.motivoReasignacion = motivoReasignacion;
	}
	public String getDescripcionMotivo() {
		return descripcionMotivo;
	}
	public void setDescripcionMotivo(String descripcionMotivo) {
		this.descripcionMotivo = descripcionMotivo;
	}
	public String getDatDocumentoUrl() {
		return datDocumentoUrl;
	}
	public void setDatDocumentoUrl(String datDocumentoUrl) {
		this.datDocumentoUrl = datDocumentoUrl;
	}
	public Integer getIdAsignacionNueva() {
		return idAsignacionNueva;
	}
	public void setIdAsignacionNueva(Integer idAsignacionNueva) {
		this.idAsignacionNueva = idAsignacionNueva;
	}
	public Integer getReasignadoPor() {
		return reasignadoPor;
	}
	public void setReasignadoPor(Integer reasignadoPor) {
		this.reasignadoPor = reasignadoPor;
	}
	public OffsetDateTime getFechaReasignacion() {
		return fechaReasignacion;
	}
	public void setFechaReasignacion(OffsetDateTime fechaReasignacion) {
		this.fechaReasignacion = fechaReasignacion;
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
