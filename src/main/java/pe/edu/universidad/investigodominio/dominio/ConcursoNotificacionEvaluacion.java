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
public class ConcursoNotificacionEvaluacion {
    @Id
    @GeneratedValue(generator="concurso_notificacion_evaluacion_id_seq")
    @SequenceGenerator(name="concurso_notificacion_evaluacion_id_seq",sequenceName="concurso_notificacion_evaluacion_id_seq", allocationSize=1)
    private Integer id;
    
    private Integer idAsignacionEvaluacion;
    private Integer idPostulacion;
    private String tipoNotificacion;
    private String destinatarioTipo;
    private String destinatarioEmail;
    private String asunto;
    private String mensaje;
    private OffsetDateTime fechaEnvio;
    private Boolean envioExitoso;
    
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
	public Integer getIdPostulacion() {
		return idPostulacion;
	}
	public void setIdPostulacion(Integer idPostulacion) {
		this.idPostulacion = idPostulacion;
	}
	public String getTipoNotificacion() {
		return tipoNotificacion;
	}
	public void setTipoNotificacion(String tipoNotificacion) {
		this.tipoNotificacion = tipoNotificacion;
	}
	public String getDestinatarioTipo() {
		return destinatarioTipo;
	}
	public void setDestinatarioTipo(String destinatarioTipo) {
		this.destinatarioTipo = destinatarioTipo;
	}
	public String getDestinatarioEmail() {
		return destinatarioEmail;
	}
	public void setDestinatarioEmail(String destinatarioEmail) {
		this.destinatarioEmail = destinatarioEmail;
	}
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public OffsetDateTime getFechaEnvio() {
		return fechaEnvio;
	}
	public void setFechaEnvio(OffsetDateTime fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}
	public Boolean getEnvioExitoso() {
		return envioExitoso;
	}
	public void setEnvioExitoso(Boolean envioExitoso) {
		this.envioExitoso = envioExitoso;
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
