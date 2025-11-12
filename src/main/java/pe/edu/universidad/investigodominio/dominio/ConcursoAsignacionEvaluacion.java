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
public class ConcursoAsignacionEvaluacion {
    @Id
    @GeneratedValue(generator="concurso_asignacion_evaluacion_id_seq")
    @SequenceGenerator(name="concurso_asignacion_evaluacion_id_seq",sequenceName="concurso_asignacion_evaluacion_id_seq", allocationSize=1)
    private Integer id;
    
    private Integer idPostulacion;
    private Integer idEvaluador;
    private LocalDate fechaAsignacion;
    private LocalDate fechaLimite;
    private LocalDate fechaLimiteOriginal;
    private Integer numExtensiones;
    private String estadoEvaluacion;
    private OffsetDateTime fechacompletada;
    private String datTokenAcceso;
    private String datEvaluacionUrl;
    private String rolEvaluador;
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
	public Integer getIdEvaluador() {
		return idEvaluador;
	}
	public void setIdEvaluador(Integer idEvaluador) {
		this.idEvaluador = idEvaluador;
	}
	public LocalDate getFechaAsignacion() {
		return fechaAsignacion;
	}
	public void setFechaAsignacion(LocalDate fechaAsignacion) {
		this.fechaAsignacion = fechaAsignacion;
	}
	public LocalDate getFechaLimite() {
		return fechaLimite;
	}
	public void setFechaLimite(LocalDate fechaLimite) {
		this.fechaLimite = fechaLimite;
	}
	public LocalDate getFechaLimiteOriginal() {
		return fechaLimiteOriginal;
	}
	public void setFechaLimiteOriginal(LocalDate fechaLimiteOriginal) {
		this.fechaLimiteOriginal = fechaLimiteOriginal;
	}
	public Integer getNumExtensiones() {
		return numExtensiones;
	}
	public void setNumExtensiones(Integer numExtensiones) {
		this.numExtensiones = numExtensiones;
	}
	public String getEstadoEvaluacion() {
		return estadoEvaluacion;
	}
	public void setEstadoEvaluacion(String estadoEvaluacion) {
		this.estadoEvaluacion = estadoEvaluacion;
	}
	public OffsetDateTime getFechacompletada() {
		return fechacompletada;
	}
	public void setFechacompletada(OffsetDateTime fechacompletada) {
		this.fechacompletada = fechacompletada;
	}
	public String getDatTokenAcceso() {
		return datTokenAcceso;
	}
	public void setDatTokenAcceso(String datTokenAcceso) {
		this.datTokenAcceso = datTokenAcceso;
	}
	public String getDatEvaluacionUrl() {
		return datEvaluacionUrl;
	}
	public void setDatEvaluacionUrl(String datEvaluacionUrl) {
		this.datEvaluacionUrl = datEvaluacionUrl;
	}
	public String getRolEvaluador() {
		return rolEvaluador;
	}
	public void setRolEvaluador(String rolEvaluador) {
		this.rolEvaluador = rolEvaluador;
	}
    
    
}
