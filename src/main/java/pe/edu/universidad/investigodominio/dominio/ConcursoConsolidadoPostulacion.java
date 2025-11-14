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
public class ConcursoConsolidadoPostulacion {
    @Id
    @GeneratedValue(generator="concurso_consolidado_postulacion_id_seq")
    @SequenceGenerator(name="concurso_consolidado_postulacion_id_seq",sequenceName="concurso_consolidado_postulacion_id_seq", allocationSize=1)
    private Integer id;
    
    private Integer idPostulacion;
    private Integer numEvaluadoresAsignados;
    private Integer numEvaluacionesCompletadas;
    private Integer numEvaluacionesPendientes;
    private Integer numEvaluacionesVencidas;
    private Double puntajePromedio;
    private String decisionFinal;
    private String observaciones;
    
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
	public Integer getNumEvaluadoresAsignados() {
		return numEvaluadoresAsignados;
	}
	public void setNumEvaluadoresAsignados(Integer numEvaluadoresAsignados) {
		this.numEvaluadoresAsignados = numEvaluadoresAsignados;
	}
	public Integer getNumEvaluacionesCompletadas() {
		return numEvaluacionesCompletadas;
	}
	public void setNumEvaluacionesCompletadas(Integer numEvaluacionesCompletadas) {
		this.numEvaluacionesCompletadas = numEvaluacionesCompletadas;
	}
	public Integer getNumEvaluacionesPendientes() {
		return numEvaluacionesPendientes;
	}
	public void setNumEvaluacionesPendientes(Integer numEvaluacionesPendientes) {
		this.numEvaluacionesPendientes = numEvaluacionesPendientes;
	}
	public Integer getNumEvaluacionesVencidas() {
		return numEvaluacionesVencidas;
	}
	public void setNumEvaluacionesVencidas(Integer numEvaluacionesVencidas) {
		this.numEvaluacionesVencidas = numEvaluacionesVencidas;
	}
	public Double getPuntajePromedio() {
		return puntajePromedio;
	}
	public void setPuntajePromedio(Double puntajePromedio) {
		this.puntajePromedio = puntajePromedio;
	}
	public String getDecisionFinal() {
		return decisionFinal;
	}
	public void setDecisionFinal(String decisionFinal) {
		this.decisionFinal = decisionFinal;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
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
