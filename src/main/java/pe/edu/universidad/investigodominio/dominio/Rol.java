package pe.edu.universidad.investigodominio.dominio;

import jakarta.persistence.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.time.OffsetDateTime;

@Entity
@DynamicInsert
@DynamicUpdate
public class Rol {
	@Id
    @GeneratedValue(generator="rol_id_seq")
    @SequenceGenerator(name="rol_id_seq",sequenceName="rol_id_seq", allocationSize=1)
	private Integer id;
	private String nombre;

	private Boolean estado;
    private OffsetDateTime createdDate;
    private Integer createdBy;
    private OffsetDateTime modifiedDate;
    private Integer modifiedBy;

    public Rol() {}

    public Rol(Integer id, String nombre, Boolean estado, OffsetDateTime createdDate, OffsetDateTime modifiedDate, Integer createdBy, Integer modifiedBy) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
    }

    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id; 
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Boolean getEstado() { return estado; }
    public void setEstado(Boolean estado) { this.estado = estado; }

    public OffsetDateTime getCreatedDate() { return createdDate; }
    public void setCreatedDate(OffsetDateTime createdDate) { this.createdDate = createdDate; }

    public Integer getCreatedBy() { return createdBy; }
    public void setCreatedBy(Integer createdBy) { this.createdBy = createdBy; }

    public OffsetDateTime getModifiedDate() { return modifiedDate; }
    public void setModifiedDate(OffsetDateTime modifiedDate) { this.modifiedDate = modifiedDate; }

    public Integer getModifiedBy() { return modifiedBy; }
    public void setModifiedBy(Integer modifiedBy) { this.modifiedBy = modifiedBy; }
}
