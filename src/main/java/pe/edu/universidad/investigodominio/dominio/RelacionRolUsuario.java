package pe.edu.universidad.investigodominio.dominio;

import jakarta.persistence.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.time.OffsetDateTime;

@Entity
@DynamicInsert
@DynamicUpdate
public class RelacionRolUsuario {
    @Id
    @GeneratedValue(generator="relacion_rol_usuario_id_seq")
    @SequenceGenerator(name="relacion_rol_usuario_id_seq",sequenceName="relacion_rol_usuario_id_seq", allocationSize=1)
    private int id;

    private Boolean estado;
    private OffsetDateTime createdDate;
    private Integer createdBy;
    private OffsetDateTime modifiedDate;
    private Integer modifiedBy;

    private Integer id_usuario;
    private Integer id_rol;

    public RelacionRolUsuario() {}

    public RelacionRolUsuario(int id, Boolean estado, Integer id_rol, Integer id_usuario, Integer modifiedBy, Integer createdBy, OffsetDateTime modifiedDate, OffsetDateTime createdDate) {
        this.id = id;
        this.estado = estado;
        this.id_rol = id_rol;
        this.id_usuario = id_usuario;
        this.modifiedBy = modifiedBy;
        this.createdBy = createdBy;
        this.modifiedDate = modifiedDate;
        this.createdDate = createdDate;
    }



    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Boolean getEstado() { return estado; }
    public void setEstado(Boolean estado) { this.estado = estado; }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Integer getId_rol() {
        return id_rol;
    }

    public void setId_rol(Integer id_rol) {
        this.id_rol = id_rol;
    }

    public OffsetDateTime getCreatedDate() { return createdDate; }
    public void setCreatedDate(OffsetDateTime createdDate) { this.createdDate = createdDate; }

    public Integer getCreatedBy() { return createdBy; }
    public void setCreatedBy(Integer createdBy) { this.createdBy = createdBy; }

    public OffsetDateTime getModifiedDate() { return modifiedDate; }
    public void setModifiedDate(OffsetDateTime modifiedDate) { this.modifiedDate = modifiedDate; }

    public Integer getModifiedBy() { return modifiedBy; }
    public void setModifiedBy(Integer modifiedBy) { this.modifiedBy = modifiedBy; }
}
