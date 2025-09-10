package pe.edu.universidad.investigodominio.dominio;

import jakarta.persistence.*;
import java.time.OffsetDateTime;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;

    private String apellido;

    @Column(unique = true, nullable = false)
    private String dni;

    @Column(unique = true, nullable = false)
    private String email;

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

    @ManyToOne
    @JoinColumn(name = "rol_id", nullable = false)
    @JsonIgnore
    private Rol rol;

    // Getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

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

    public Rol getRol() { return rol; }
    public void setRol(Rol rol) { this.rol = rol; }
    
    @JsonProperty("createdBy")
    public Integer getCreatedById() {
        return createdBy != null ? createdBy.getId() : null;
    }

    @JsonProperty("rolId")
    public Integer getRolId() {
        return rol != null ? rol.getId() : null;
    }
}
