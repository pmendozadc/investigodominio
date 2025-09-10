package pe.edu.universidad.investigodominio.dominio;

import jakarta.persistence.*;
import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
public class Rol {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nombre;

	private boolean estado = true;

	private OffsetDateTime createdDate;

    @ManyToOne
    @JoinColumn(name = "created_by")
    @JsonIgnore
    private Usuario createdBy;

    private OffsetDateTime modifiedDate;

    @ManyToOne
    @JoinColumn(name = "modified_by")
    @JsonIgnore
    private Usuario modifiedBy;
	
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

	public boolean getEstado() { return estado; }
    public void setEstado(boolean estado) { this.estado = estado; }

    public OffsetDateTime getCreatedDate() { return createdDate; }
    public void setCreatedDate(OffsetDateTime createdDate) { this.createdDate = createdDate; }

    public Usuario getCreatedBy() { return createdBy; }
    public void setCreatedBy(Usuario createdBy) { this.createdBy = createdBy; }

    public OffsetDateTime getModifiedDate() { return modifiedDate; }
    public void setModifiedDate(OffsetDateTime modifiedDate) { this.modifiedDate = modifiedDate; }

    public Usuario getModifiedBy() { return modifiedBy; }
    public void setModifiedBy(Usuario modifiedBy) { this.modifiedBy = modifiedBy; }

	@JsonProperty("createdBy")
    public Integer getCreatedById() {
        return createdBy != null ? createdBy.getId() : null;
    }
}
