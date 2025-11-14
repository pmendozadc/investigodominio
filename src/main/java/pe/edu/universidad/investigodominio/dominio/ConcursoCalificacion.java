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
public class ConcursoCalificacion {
    @Id
    @GeneratedValue(generator="concurso_calificacion_id_seq")
    @SequenceGenerator(name="concurso_calificacion_id_seq",sequenceName="concurso_calificacion_id_seq", allocationSize=1)
    private Integer id;
    
    private Integer idAsignacionEvaluacion;
    private Integer idCriterioEvaluacion;
    private Integer puntaje;
    private String comentario;
    private Double ponderacionAplicada;
    private Double puntajePonderado;
    
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
	public Integer getIdAsignacionEvaluacion() {
		return idAsignacionEvaluacion;
	}
	public void setIdAsignacionEvaluacion(Integer idAsignacionEvaluacion) {
		this.idAsignacionEvaluacion = idAsignacionEvaluacion;
	}
	public Integer getIdCriterioEvaluacion() {
		return idCriterioEvaluacion;
	}
	public void setIdCriterioEvaluacion(Integer idCriterioEvaluacion) {
		this.idCriterioEvaluacion = idCriterioEvaluacion;
	}
	public Integer getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(Integer puntaje) {
		this.puntaje = puntaje;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public Double getPonderacionAplicada() {
		return ponderacionAplicada;
	}
	public void setPonderacionAplicada(Double ponderacionAplicada) {
		this.ponderacionAplicada = ponderacionAplicada;
	}
	public Double getPuntajePonderado() {
		return puntajePonderado;
	}
	public void setPuntajePonderado(Double puntajePonderado) {
		this.puntajePonderado = puntajePonderado;
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
