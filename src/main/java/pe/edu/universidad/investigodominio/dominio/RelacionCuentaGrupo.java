package pe.edu.universidad.investigodominio.dominio;

import jakarta.persistence.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.time.OffsetDateTime;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "relacion_cuenta_grupo")
public class RelacionCuentaGrupo {

    @Id
    @GeneratedValue(generator = "relacion_cuenta_grupo_id_seq")
    @SequenceGenerator(name = "relacion_cuenta_grupo_id_seq", sequenceName = "relacion_cuenta_grupo_id_seq", allocationSize = 1)
    private Integer id;

    private Integer idGrupo;
    private Integer idCuenta;
    private Boolean estado;
    private Integer createdBy;
    private OffsetDateTime createdDate;
    private Integer modifiedBy;
    private OffsetDateTime modifiedDate;

    public RelacionCuentaGrupo() {}

    public RelacionCuentaGrupo(Integer id, Integer idGrupo, Integer idCuenta, Boolean estado,
                               Integer createdBy, OffsetDateTime createdDate,
                               Integer modifiedBy, OffsetDateTime modifiedDate) {
        this.id = id;
        this.idGrupo = idGrupo;
        this.idCuenta = idCuenta;
        this.estado = estado;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
    }

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

    public Integer getIdCuenta() {
        return idCuenta;
    }
    public void setIdCuenta(Integer idCuenta) {
        this.idCuenta = idCuenta;
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

    public OffsetDateTime getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(OffsetDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getModifiedBy() {
        return modifiedBy;
    }
    public void setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public OffsetDateTime getModifiedDate() {
        return modifiedDate;
    }
    public void setModifiedDate(OffsetDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}