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
public class ConcursoExtensionPlazo {
    @Id
    @GeneratedValue(generator="concurso_extension_plazo_id_seq")
    @SequenceGenerator(name="concurso_extension_plazo_id_seq",sequenceName="concurso_extension_plazo_id_seq", allocationSize=1)
    private Integer id;
    
    private Integer idAsignacionEvaluacion;
    private LocalDate fechaLimiteAnterior;
    private LocalDate fechaLimiteNueva;
    private String motivo;
    private Integer diasExtension;
    private Integer numeroExtension;
    private Integer aprobadoPor;
    private OffsetDateTime fechaAprobacion;
    
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
	public LocalDate getFechaLimiteAnterior() {
		return fechaLimiteAnterior;
	}
	public void setFechaLimiteAnterior(LocalDate fechaLimiteAnterior) {
		this.fechaLimiteAnterior = fechaLimiteAnterior;
	}
	public LocalDate getFechaLimiteNueva() {
		return fechaLimiteNueva;
	}
	public void setFechaLimiteNueva(LocalDate fechaLimiteNueva) {
		this.fechaLimiteNueva = fechaLimiteNueva;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public Integer getDiasExtension() {
		return diasExtension;
	}
	public void setDiasExtension(Integer diasExtension) {
		this.diasExtension = diasExtension;
	}
	public Integer getNumeroExtension() {
		return numeroExtension;
	}
	public void setNumeroExtension(Integer numeroExtension) {
		this.numeroExtension = numeroExtension;
	}
	public Integer getAprobadoPor() {
		return aprobadoPor;
	}
	public void setAprobadoPor(Integer aprobadoPor) {
		this.aprobadoPor = aprobadoPor;
	}
	public OffsetDateTime getFechaAprobacion() {
		return fechaAprobacion;
	}
	public void setFechaAprobacion(OffsetDateTime fechaAprobacion) {
		this.fechaAprobacion = fechaAprobacion;
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
