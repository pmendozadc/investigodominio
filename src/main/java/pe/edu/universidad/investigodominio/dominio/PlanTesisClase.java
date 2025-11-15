package pe.edu.universidad.investigodominio.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import org.hibernate.annotations.DynamicInsert;

import java.time.OffsetDateTime;

@Entity
@DynamicInsert
public class PlanTesisClase {
    @Id
    @GeneratedValue(generator="plan_tesis_clase__id_seq")
    @SequenceGenerator(name="plan_tesis_clase__id_seq",sequenceName="plan_tesis_clase__id_seq", allocationSize=1)
    private Integer id;
    private String nombre;
    private String datGoogleClassId;
    private Integer semestreAnio;
    private String carrera;
    private Integer anio;
    private OffsetDateTime fechaCreacion;
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
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDatGoogleClassId() {
		return datGoogleClassId;
	}
	public void setDatGoogleClassId(String datGoogleClassId) {
		this.datGoogleClassId = datGoogleClassId;
	}
	public Integer getSemestreAnio() {
		return semestreAnio;
	}
	public void setSemestreAnio(Integer semestreAnio) {
		this.semestreAnio = semestreAnio;
	}
	public String getCarrera() {
		return carrera;
	}
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	public Integer getAnio() {
		return anio;
	}
	public void setAnio(Integer anio) {
		this.anio = anio;
	}
	public OffsetDateTime getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(OffsetDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
}
