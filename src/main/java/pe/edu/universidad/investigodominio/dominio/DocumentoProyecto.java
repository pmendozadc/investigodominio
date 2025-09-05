package pe.edu.universidad.investigodominio.dominio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Data
@Table(name = "documento_proyecto")
@Entity
public class DocumentoProyecto {

    @Id
    @Column(name = "id_documento")
    private Integer idDocumento;

    @Column(name = "titulo")
    private String titulo;
    @Column(name = "tiene_marcadores")
    private Boolean tieneMarcadores;

    // Foreign keys
    @Column(name = "id_proyecto")
    private Integer idProyecto;

    @Column(name = "created_by")
    private Integer createBy;
    @Column(name = "created_date")
    private Date createdDate;
    @Column(name = "modified_by")
    private Integer modifiedBy;
    @Column(name = "modified_date")
    private Date modifiedDate;

    public DocumentoProyecto() {

    }

    public DocumentoProyecto(
            String titulo,
            Boolean tieneMarcadores,
            Integer idProyecto
    ) {
        this.titulo = titulo;
        this.tieneMarcadores = tieneMarcadores;
        this.idProyecto = idProyecto;
    }
}
