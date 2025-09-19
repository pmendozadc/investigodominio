package pe.edu.universidad.investigodominio.dominio;

import java.time.OffsetDateTime;

import org.hibernate.annotations.DynamicInsert;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
@DynamicInsert
public class Proyecto {

	@Id
	@GeneratedValue(generator="proyecto_id_seq")
	@SequenceGenerator(name="proyecto_id_seq",sequenceName="proyecto_id_seq", allocationSize=1)
	private int id;

	private String nombre;
	private String emailLider;
	private String idCarpeta;
	private String objetivoGeneral;
	private OffsetDateTime fechaCreacion;
	private OffsetDateTime fechaInicio;
	private OffsetDateTime fechaFin;
	private Boolean estado;

	private Integer idTipoProyecto;	
	private Integer idHojaSeguimiento;
	private Integer idGrupoAsignado;
	private Integer idEstadoProyecto;

	private Integer createdBy;
	private OffsetDateTime createdDate;
	private Integer modifiedBy;
	private OffsetDateTime modifiedDate;

	public Proyecto() {

	}

	public Proyecto(
			String nombre,
			String objetivoGeneral,
			OffsetDateTime fechaCreacion,
			Integer tipoProyecto
	) {
		this.nombre = nombre;
		this.objetivoGeneral = objetivoGeneral;
		this.fechaCreacion = fechaCreacion;
		this.idTipoProyecto = tipoProyecto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmailLider() {
		return emailLider;
	}

	public void setEmailLider(String emailLider) {
		this.emailLider = emailLider;
	}

	public String getIdCarpeta() {
		return idCarpeta;
	}

	public void setIdCarpeta(String idCarpeta) {
		this.idCarpeta = idCarpeta;
	}

	public String getObjetivoGeneral() {
		return objetivoGeneral;
	}

	public void setObjetivoGeneral(String objetivoGeneral) {
		this.objetivoGeneral = objetivoGeneral;
	}

	public OffsetDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(OffsetDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public OffsetDateTime getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(OffsetDateTime fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public OffsetDateTime getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(OffsetDateTime fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Integer getIdTipoProyecto() {
		return idTipoProyecto;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public void setIdTipoProyecto(Integer idTipoProyecto) {
		this.idTipoProyecto = idTipoProyecto;
	}

	public Integer getIdHojaSeguimiento() {
		return idHojaSeguimiento;
	}

	public void setIdHojaSeguimiento(Integer idHojaSeguimiento) {
		this.idHojaSeguimiento = idHojaSeguimiento;
	}

	public Integer getIdGrupoAsignado() {
		return idGrupoAsignado;
	}

	public void setIdGrupoAsignado(Integer idGrupoAsignado) {
		this.idGrupoAsignado = idGrupoAsignado;
	}

	public Integer getIdEstadoProyecto() {
		return idEstadoProyecto;
	}

	public void setIdEstadoProyecto(Integer idEstadoProyecto) {
		this.idEstadoProyecto = idEstadoProyecto;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public OffsetDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(OffsetDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public Integer getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public OffsetDateTime getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(OffsetDateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

		
}
