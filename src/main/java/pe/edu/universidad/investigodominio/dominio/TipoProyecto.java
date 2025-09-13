package pe.edu.universidad.investigodominio.dominio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.Date;

@Data
@Table(name = "tipo_proyecto")
@Entity
public class TipoProyecto {
    @Id
    @Column(name = "id")
    Integer id;

    @Column(name = "nombre")
    String nombre;
    @Column(name = "estado")
    private Boolean estado;

    @Column(name = "created_by")
    private Integer createdBy;
    @Column(name = "created_date")
    private OffsetDateTime createdDate;
    @Column(name = "modified_by")
    private Integer modifiedBy;
    @Column(name = "modified_date")
    private OffsetDateTime modifiedDate;

    public TipoProyecto() {

    }

    public TipoProyecto(
            String nombre
    ) {
        this.nombre = nombre;
    }
}
