package pe.edu.universidad.investigodominio.dominio;

import java.time.OffsetDateTime;

import org.hibernate.annotations.DynamicInsert;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
@DynamicInsert
public class ConcursoDashboard {
    @Id
    @GeneratedValue(generator="concurso_dashboard_id_seq")
    @SequenceGenerator(name="concurso_dashboard_id_seq",sequenceName="concurso_dashboard_id_seq", allocationSize=1)
    private Integer id;
    
    private Integer idConcurso;
    private Integer totalPropuestas;
    private Integer propuestasValidadas;
    private Integer propuestasRechazadas;
    private Integer propuestasPendientes;
    private Integer evaluadoresAsignados;
    private Integer evaluacionesCompletadas;
    private Integer evaluacionesVencidas;
    private Integer evaluacionesPendientes;
    private Integer tareasPendientes;
    private Boolean alertaPlazosProximos;
    private Double porcentajeAvance;
    private OffsetDateTime fechaUltimaActualizacion;
    
    
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
	public Integer getTotalPropuestas() {
		return totalPropuestas;
	}
	public void setTotalPropuestas(Integer totalPropuestas) {
		this.totalPropuestas = totalPropuestas;
	}
	public Integer getPropuestasValidadas() {
		return propuestasValidadas;
	}
	public void setPropuestasValidadas(Integer propuestasValidadas) {
		this.propuestasValidadas = propuestasValidadas;
	}
	public Integer getPropuestasRechazadas() {
		return propuestasRechazadas;
	}
	public void setPropuestasRechazadas(Integer propuestasRechazadas) {
		this.propuestasRechazadas = propuestasRechazadas;
	}
	public Integer getPropuestasPendientes() {
		return propuestasPendientes;
	}
	public void setPropuestasPendientes(Integer propuestasPendientes) {
		this.propuestasPendientes = propuestasPendientes;
	}
	public Integer getEvaluadoresAsignados() {
		return evaluadoresAsignados;
	}
	public void setEvaluadoresAsignados(Integer evaluadoresAsignados) {
		this.evaluadoresAsignados = evaluadoresAsignados;
	}
	public Integer getEvaluacionesCompletadas() {
		return evaluacionesCompletadas;
	}
	public void setEvaluacionesCompletadas(Integer evaluacionesCompletadas) {
		this.evaluacionesCompletadas = evaluacionesCompletadas;
	}
	public Integer getEvaluacionesVencidas() {
		return evaluacionesVencidas;
	}
	public void setEvaluacionesVencidas(Integer evaluacionesVencidas) {
		this.evaluacionesVencidas = evaluacionesVencidas;
	}
	public Integer getEvaluacionesPendientes() {
		return evaluacionesPendientes;
	}
	public void setEvaluacionesPendientes(Integer evaluacionesPendientes) {
		this.evaluacionesPendientes = evaluacionesPendientes;
	}
	public Integer getTareasPendientes() {
		return tareasPendientes;
	}
	public void setTareasPendientes(Integer tareasPendientes) {
		this.tareasPendientes = tareasPendientes;
	}
	public Boolean getAlertaPlazosProximos() {
		return alertaPlazosProximos;
	}
	public void setAlertaPlazosProximos(Boolean alertaPlazosProximos) {
		this.alertaPlazosProximos = alertaPlazosProximos;
	}
	public Double getPorcentajeAvance() {
		return porcentajeAvance;
	}
	public void setPorcentajeAvance(Double porcentajeAvance) {
		this.porcentajeAvance = porcentajeAvance;
	}
	public OffsetDateTime getFechaUltimaActualizacion() {
		return fechaUltimaActualizacion;
	}
	public void setFechaUltimaActualizacion(OffsetDateTime fechaUltimaActualizacion) {
		this.fechaUltimaActualizacion = fechaUltimaActualizacion;
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
