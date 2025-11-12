package pe.edu.universidad.investigodominio.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import org.hibernate.annotations.DynamicInsert;

import java.time.OffsetDateTime;

@Entity
@DynamicInsert
public class PlanTesisLineaInvestigacion {
    @Id
    @GeneratedValue(generator="plan_tesis_linea_investigacion_id_seq")
    @SequenceGenerator(name="plan_tesis_linea_investigacion_id_seq",sequenceName="plan_tesis_linea_investigacion_id_seq", allocationSize=1)
    private Integer id;
    
    private Integer idPlanTesis;
    private Integer idLineaInvestigacion;
    
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
	public Integer getIdPlanTesis() {
		return idPlanTesis;
	}
	public void setIdPlanTesis(Integer idPlanTesis) {
		this.idPlanTesis = idPlanTesis;
	}
	public Integer getIdLineaInvestigacion() {
		return idLineaInvestigacion;
	}
	public void setIdLineaInvestigacion(Integer idLineaInvestigacion) {
		this.idLineaInvestigacion = idLineaInvestigacion;
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
