package pe.edu.universidad.investigodominio.dominio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

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
    private String estado;

    @Column(name = "created_by")
    private Integer createdBy;
    @Column(name = "created_date")
    private Date createdDate;
    @Column(name = "modified_by")
    private Integer modifiedBy;
    @Column(name = "modified_date")
    private Date modifiedDate;

    public TipoProyecto() {

    }

    public TipoProyecto(
            String nombre
    ) {
        this.nombre = nombre;
    }
}
