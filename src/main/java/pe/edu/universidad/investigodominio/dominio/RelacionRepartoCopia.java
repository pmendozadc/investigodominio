package pe.edu.universidad.investigodominio.dominio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@Table(name = "relacion_reparto_copia")
@Entity
public class RelacionRepartoCopia {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "email")
    private String email;
    @Column(name = "estado")
    private boolean estado = true;

    @Column(name = "created_by")
    private int createdBy;
    @Column(name = "created_date", insertable = false, updatable = false)
    private OffsetDateTime createdDate;
    @Column(name = "modified_by")
    private int modifiedBy;
    @Column(name = "modified_date", insertable = false, updatable = false)
    private OffsetDateTime modifiedDate;

}