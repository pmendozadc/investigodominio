package pe.edu.universidad.investigodominio.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import org.hibernate.annotations.DynamicInsert;

import java.time.OffsetDateTime;

@Entity
@DynamicInsert
public class PlanTesisPorKeywordHistorial {
    @Id
    @GeneratedValue(generator="plan_tesis_por_keyword_historial_id_seq")
    @SequenceGenerator(name="plan_tesis_por_keyword_historial_id_seq",sequenceName="plan_tesis_por_keyword_historial_id_seq", allocationSize=1)
    private Integer id;
    
    private Integer idPlanTesisHistorial;
    private Integer idKeyword;
    
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
	public OffsetDateTime getCreatedDate() {
		return createdDate;
	}
	public Integer getIdPlanTesisHistorial() {
		return idPlanTesisHistorial;
	}
	public void setIdPlanTesisHistorial(Integer idPlanTesisHistorial) {
		this.idPlanTesisHistorial = idPlanTesisHistorial;
	}
	public void setCreatedDate(OffsetDateTime createdDate) {
		this.createdDate = createdDate;
	}
	public Integer getIdKeyword() {
		return idKeyword;
	}
	public void setIdKeyword(Integer idKeyword) {
		this.idKeyword = idKeyword;
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
