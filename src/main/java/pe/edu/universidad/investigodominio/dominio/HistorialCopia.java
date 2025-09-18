package pe.edu.universidad.investigodominio.dominio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@Table(name = "historial_copia")
@Entity
public class HistorialCopia {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "email")
    private String email;
    @Column(name = "fecha_archivado")
    private OffsetDateTime fechaArchivado;
    @Column(name = "estado")
    private Boolean estado = true;

    @Column(name = "created_by")
    private Integer createdBy;
    @Column(name = "created_date", insertable = false, updatable = false)
    private OffsetDateTime createdDate;
    @Column(name = "modified_by")
    private Integer modifiedBy;
    @Column(name = "modified_date", insertable = false, updatable = false)
    private OffsetDateTime modifiedDate;

}