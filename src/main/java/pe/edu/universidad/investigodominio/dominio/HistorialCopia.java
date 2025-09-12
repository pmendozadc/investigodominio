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
    private int id;

    @Column(name = "email")
    private String email;
    @Column(name = "fecha_archivado")
    private OffsetDateTime fechaArchivado;
    @Column(name = "estado")
    private boolean estado;

    @Column(name = "created_by")
    private int createdBy;
    @Column(name = "created_date")
    private OffsetDateTime createdDate;
    @Column(name = "modified_by")
    private int modifiedBy;
    @Column(name = "modified_date")
    private OffsetDateTime modifiedDate;

}