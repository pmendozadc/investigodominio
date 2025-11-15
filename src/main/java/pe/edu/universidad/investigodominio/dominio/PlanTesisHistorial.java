package pe.edu.universidad.investigodominio.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import org.hibernate.annotations.DynamicInsert;

import java.time.OffsetDateTime;

@Entity
@DynamicInsert
public class PlanTesisHistorial {
    @Id
    @GeneratedValue(generator="plan_tesis_historial_id_seq")
    @SequenceGenerator(name="plan_tesis_historial_id_seq",sequenceName="plan_tesis_historial_id_seq", allocationSize=1)
    private Integer id;
    
    private Integer idPlanTesisOriginal;
    private String titulo;
    private String datDocumentoUrl;
    private OffsetDateTime fechaEntrega;
    private Integer idClase;
    
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
	public String getDatDocumentoUrl() {
		return datDocumentoUrl;
	}
	public Integer getIdClase() {
		return idClase;
	}
	public void setIdClase(Integer idClase) {
		this.idClase = idClase;
	}
	public void setDatDocumentoUrl(String datDocumentoUrl) {
		this.datDocumentoUrl = datDocumentoUrl;
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
	public Integer getIdPlanTesisOriginal() {
		return idPlanTesisOriginal;
	}
	public void setIdPlanTesisOriginal(Integer idPlanTesisOriginal) {
		this.idPlanTesisOriginal = idPlanTesisOriginal;
	}
	public OffsetDateTime getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(OffsetDateTime fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	
    
}
