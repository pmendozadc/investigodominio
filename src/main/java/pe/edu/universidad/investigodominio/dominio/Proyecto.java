package pe.edu.universidad.investigodominio.dominio;

import java.time.OffsetDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Proyecto {

	@Id
	private int id;
	
	private String nombre;

	private OffsetDateTime fechaInicio;
	
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

	public OffsetDateTime getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(OffsetDateTime fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	
	
}
