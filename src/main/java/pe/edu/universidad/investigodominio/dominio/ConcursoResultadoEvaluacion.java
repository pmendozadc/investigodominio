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
public class ConcursoResultadoEvaluacion {
    @Id
    @GeneratedValue(generator="concurso_resultado_evaluacion_id_seq")
    @SequenceGenerator(name="concurso_resultado_evaluacion_id_seq",sequenceName="concurso_resultado_evaluacion_id_seq", allocationSize=1)
    private Integer id;
	    
    private Integer idAsignacionEvaluacion;
    private Double puntajeTotal;
    private String comentarioGeneral;
    
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
	public Double getPuntajeTotal() {
		return puntajeTotal;
	}
	public Integer getIdAsignacionEvaluacion() {
		return idAsignacionEvaluacion;
	}
	public void setIdAsignacionEvaluacion(Integer idAsignacionEvaluacion) {
		this.idAsignacionEvaluacion = idAsignacionEvaluacion;
	}
	public void setPuntajeTotal(Double puntajeTotal) {
		this.puntajeTotal = puntajeTotal;
	}
	public String getComentarioGeneral() {
		return comentarioGeneral;
	}
	public void setComentarioGeneral(String comentarioGeneral) {
		this.comentarioGeneral = comentarioGeneral;
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
