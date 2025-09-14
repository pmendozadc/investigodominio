package pe.edu.universidad.investigodominio.dominio;

import jakarta.persistence.*;
import java.time.OffsetDateTime;


@Entity
public class Rol {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nombre;

	private boolean estado = true;

    @Column(insertable = false, updatable = false)
    private OffsetDateTime createdDate;

    @JoinColumn(name = "created_by")
    private Integer createdBy;

    @Column(insertable = false, updatable = false)
    private OffsetDateTime modifiedDate;

    @JoinColumn(name = "modified_by")
    private Integer modifiedBy;
	
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

    public Integer getCreatedBy() { return createdBy; }
    public void setCreatedBy(Integer createdBy) { this.createdBy = createdBy; }

    public OffsetDateTime getModifiedDate() { return modifiedDate; }
    public void setModifiedDate(OffsetDateTime modifiedDate) { this.modifiedDate = modifiedDate; }

    public Integer getModifiedBy() { return modifiedBy; }
    public void setModifiedBy(Integer modifiedBy) { this.modifiedBy = modifiedBy; }

}
