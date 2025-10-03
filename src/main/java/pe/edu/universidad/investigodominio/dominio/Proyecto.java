package pe.edu.universidad.investigodominio.dominio;

import java.time.OffsetDateTime;
import org.hibernate.annotations.DynamicInsert;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import org.hibernate.annotations.DynamicUpdate;

@Table(name = "proyecto")
@Entity
@DynamicInsert
@DynamicUpdate
public class Proyecto {

	@Id
	@GeneratedValue(generator = "proyecto_id_seq")
	@SequenceGenerator(
			name = "proyecto_id_seq",
			sequenceName = "proyecto_id_seq",
			allocationSize = 1
	)
	@Column(name = "id")
	private Integer id;

	@Column(name = "nombre")
	private String nombre;
	@Column(name = "id_cuenta_lider")
	private String idCuentaLider;
	@Column(name = "dat_id_carpeta")
	private String datIdCarpeta;
	@Column(name = "objetivo_general")
	private String objetivoGeneral;
	@Column(name = "fechaCreacion")
	private OffsetDateTime fechaCreacion;
	@Column(name = "fecha_inicio")
	private OffsetDateTime fechaInicio;
	@Column(name = "fecha_fin")
	private OffsetDateTime fechaFin;
	@Column(name = "estado")
	private Boolean estado;
	@Column(name = "dat_id_hoja_seguimiento")
	private String datIdHojaSeguimiento;

	@Column(name = "id_tipo_proyecto")
	private Integer idTipoProyecto;
	@Column(name = "id_grupo_asignado")
	private Integer idGrupoAsignado;
	@Column(name = "id_estado_proyecto")
	private Integer idEstadoProyecto;

	@Column(name = "created_by")
	private Integer createdBy;
	@Column(name = "created_date")
	private OffsetDateTime createdDate;
	@Column(name = "modified_by")
	private Integer modifiedBy;
	@Column(name = "modified_date")
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

	public OffsetDateTime getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(OffsetDateTime fechaFin) {
		this.fechaFin = fechaFin;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIdCuentaLider() {
		return idCuentaLider;
	}

	public void setIdCuentaLider(String idCuentaLider) {
		this.idCuentaLider = idCuentaLider;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDatIdCarpeta() {
		return datIdCarpeta;
	}

	public void setDatIdCarpeta(String datIdCarpeta) {
		this.datIdCarpeta = datIdCarpeta;
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

	public String getDatIdHojaSeguimiento() {
		return datIdHojaSeguimiento;
	}

	public void setDatIdHojaSeguimiento(String datIdHojaSeguimiento) {
		this.datIdHojaSeguimiento = datIdHojaSeguimiento;
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
