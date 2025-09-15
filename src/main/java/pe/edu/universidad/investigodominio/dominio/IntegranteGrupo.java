package pe.edu.universidad.investigodominio.dominio;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.ZonedDateTime;

@Entity
@Table(name = "integrante_grupo")
public class IntegranteGrupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "id_grupo")
    private Integer idGrupo;  // CamelCase (era id_grupo)

    @Column(name = "email")
    private String email;

    @Column(name = "estado")
    private Boolean estado = true;  // Ahora es Boolean (ya convertimos en BD)

    @Column(name = "created_by")
    private Integer createdBy;  // CamelCase

    @CreationTimestamp
    @Column(name = "created_date", updatable = false)
    private ZonedDateTime createdDate;  // CamelCase + ZonedDateTime

    @Column(name = "modified_by")
    private Integer modifiedBy;  // CamelCase

    @UpdateTimestamp
    @Column(name = "modified_date")
    private ZonedDateTime modifiedDate;  // CamelCase + ZonedDateTime

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
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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