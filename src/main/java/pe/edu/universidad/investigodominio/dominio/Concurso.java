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
public class Concurso {
    @Id
    @GeneratedValue(generator="concurso_id_seq")
    @SequenceGenerator(name="concurso_id_seq",sequenceName="concurso_id_seq", allocationSize=1)
    private Integer id;
    
    private String codigo;
    private String titulo;
    private String datUrlPostulacion;
    private String descripcion;
    private String tipo;
    private Integer anio;
    private LocalDate fechaPublicacion;
    private LocalDate fechaInicioPostulacion;
    private LocalDate fechaFinPostulacion;
    private LocalDate fechaResultado;
    private Double presupuestoMaximo;
    
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
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDatUrlPostulacion() {
		return datUrlPostulacion;
	}
	public void setDatUrlPostulacion(String datUrlPostulacion) {
		this.datUrlPostulacion = datUrlPostulacion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Integer getAnio() {
		return anio;
	}
	public void setAnio(Integer anio) {
		this.anio = anio;
	}
	public LocalDate getFechaPublicacion() {
		return fechaPublicacion;
	}
	public void setFechaPublicacion(LocalDate fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}
	public LocalDate getFechaInicioPostulacion() {
		return fechaInicioPostulacion;
	}
	public void setFechaInicioPostulacion(LocalDate fechaInicioPostulacion) {
		this.fechaInicioPostulacion = fechaInicioPostulacion;
	}
	public LocalDate getFechaFinPostulacion() {
		return fechaFinPostulacion;
	}
	public void setFechaFinPostulacion(LocalDate fechaFinPostulacion) {
		this.fechaFinPostulacion = fechaFinPostulacion;
	}
	public LocalDate getFechaResultado() {
		return fechaResultado;
	}
	public void setFechaResultado(LocalDate fechaResultado) {
		this.fechaResultado = fechaResultado;
	}
	public Double getPresupuestoMaximo() {
		return presupuestoMaximo;
	}
	public void setPresupuestoMaximo(Double presupuestoMaximo) {
		this.presupuestoMaximo = presupuestoMaximo;
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
