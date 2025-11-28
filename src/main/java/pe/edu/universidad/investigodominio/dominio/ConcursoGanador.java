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
public class ConcursoGanador {
    @Id
    @GeneratedValue(generator="concurso_ganador_id_seq")
    @SequenceGenerator(name="concurso_ganador_id_seq",sequenceName="concurso_ganador_id_seq", allocationSize=1)
    private Integer id;
    
    private Integer idConcurso;
    private Integer idPostulacion;
    private Integer puesto;
    private Double puntajeFinal;
    private Boolean esGanador;
    private String observaciones;
    
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
	public Integer getIdConcurso() {
		return idConcurso;
	}
	public void setIdConcurso(Integer idConcurso) {
		this.idConcurso = idConcurso;
	}
	public Integer getIdPostulacion() {
		return idPostulacion;
	}
	public void setIdPostulacion(Integer idPostulacion) {
		this.idPostulacion = idPostulacion;
	}
	public Integer getPuesto() {
		return puesto;
	}
	public void setPuesto(Integer puesto) {
		this.puesto = puesto;
	}
	public Double getPuntajeFinal() {
		return puntajeFinal;
	}
	public void setPuntajeFinal(Double puntajeFinal) {
		this.puntajeFinal = puntajeFinal;
	}
	public Boolean getEsGanador() {
		return esGanador;
	}
	public void setEsGanador(Boolean esGanador) {
		this.esGanador = esGanador;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
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
