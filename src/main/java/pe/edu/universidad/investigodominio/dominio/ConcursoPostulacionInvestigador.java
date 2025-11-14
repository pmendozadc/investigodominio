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
public class ConcursoPostulacionInvestigador {
    @Id
    @GeneratedValue(generator="concurso_postulacion_investigador_id_seq")
    @SequenceGenerator(name="concurso_postulacion_investigador_id_seq",sequenceName="concurso_postulacion_investigador_id_seq", allocationSize=1)
    private Integer id;
    
    private Integer idPostulacion;
    private String nombre;
    private String dni;
    private String correo;
    private String dedicacion;
    private String unidadAcademica;
    private String rol;
    private String datOrcidUrl;
    private String datCtiVitaeUrl;
    
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
	public Integer getIdPostulacion() {
		return idPostulacion;
	}
	public void setIdPostulacion(Integer idPostulacion) {
		this.idPostulacion = idPostulacion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getDedicacion() {
		return dedicacion;
	}
	public void setDedicacion(String dedicacion) {
		this.dedicacion = dedicacion;
	}
	public String getUnidadAcademica() {
		return unidadAcademica;
	}
	public void setUnidadAcademica(String unidadAcademica) {
		this.unidadAcademica = unidadAcademica;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public String getDatOrcidUrl() {
		return datOrcidUrl;
	}
	public void setDatOrcidUrl(String datOrcidUrl) {
		this.datOrcidUrl = datOrcidUrl;
	}
	public String getDatCtiVitaeUrl() {
		return datCtiVitaeUrl;
	}
	public void setDatCtiVitaeUrl(String datCtiVitaeUrl) {
		this.datCtiVitaeUrl = datCtiVitaeUrl;
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
