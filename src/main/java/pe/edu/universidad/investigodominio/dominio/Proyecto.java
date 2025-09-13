package pe.edu.universidad.investigodominio.dominio;

import java.time.OffsetDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@Table(name = "proyecto")
@Entity
public class Proyecto {

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "nombre")
	private String nombre;
	@Column(name = "email_lider")
	private String emailLider;
	@Column(name = "id_carpeta")
	private String idCarpeta;
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

	@Column(name = "id_tipo_proyecto")
	private Integer tipoProyecto;
	@Column(name = "id_hoja_seguimiento")
	private Integer idHojaSeguimiento;
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
		this.tipoProyecto = tipoProyecto;
	}
	
	
}
