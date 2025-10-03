package pe.edu.universidad.investigodominio.dominio;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.ZonedDateTime;

@Entity
@DynamicInsert
@DynamicUpdate
public class RelacionCuentaGrupo {

    @Id
    @GeneratedValue(generator="relacion_cuenta_grupo_id_seq")
    @SequenceGenerator(name="relacion_cuenta_grupo_id_seq",sequenceName="relacion_cuenta_grupo_id_seq", allocationSize=1)

    private Integer id;
    private Integer idGrupo;  // CamelCase (era id_grupo)
    private String idCuenta;
    private Boolean estado;  // Ahora es Boolean (ya convertimos en BD)
    private Integer createdBy;  // CamelCase
    private ZonedDateTime createdDate;  // CamelCase + ZonedDateTime
    private Integer modifiedBy;  // CamelCase
    private ZonedDateTime modifiedDate;  // CamelCase + ZonedDateTime

    public RelacionCuentaGrupo() {

    }

    public RelacionCuentaGrupo(Integer id, String idCuenta, Integer idGrupo, Boolean estado, ZonedDateTime createdDate, Integer createdBy, Integer modifiedBy, ZonedDateTime modifiedDate) {
        this.id = id;
        this.idCuenta = idCuenta;
        this.idGrupo = idGrupo;
        this.estado = estado;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getEmail() {
        return idCuenta;
    }

    public void setEmail(String email) {
        this.idCuenta = email;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public ZonedDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(ZonedDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public ZonedDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(ZonedDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}