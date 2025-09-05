package pe.edu.universidad.investigodominio.dominio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Data
@Table(name = "proyecto_objetivo_especifico")
@Entity
public class ProyectoObjetivoEspecifico {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "objetivo_especifico")
    private String objetivoEspecifico;

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

    public ProyectoObjetivoEspecifico() {

    }

    public ProyectoObjetivoEspecifico(
            String objetivoEspecifico,
            Integer idProyecto
    ) {
        this.objetivoEspecifico = objetivoEspecifico;
        this.idProyecto = idProyecto;
    }
}
