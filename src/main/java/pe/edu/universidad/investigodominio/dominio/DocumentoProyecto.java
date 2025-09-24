package pe.edu.universidad.investigodominio.dominio;

import jakarta.persistence.*;
import org.hibernate.annotations.DynamicInsert;

import java.time.OffsetDateTime;

@Table(name = "documento_proyecto")
@Entity
@DynamicInsert
public class DocumentoProyecto {

    @Id
    @GeneratedValue(generator = "documento_proyecto_id_seq")
    @SequenceGenerator(
            name = "documento_proyecto_id_seq",
            sequenceName = "documento_proyecto_id_seq",
            allocationSize = 1
    )
    @Column(name = "id")
    private Integer id;

    @Column(name = "titulo")
    private String titulo;
    @Column(name = "tiene_marcadores")
    private Boolean tieneMarcadores;
    @Column(name = "estado")
    private Boolean estado;

    // Foreign keys
    @Column(name = "id_proyecto")
    private Integer idProyecto;

    @Column(name = "created_by")
    private Integer createdBy;
    @Column(name = "created_date")
    private OffsetDateTime createdDate;
    @Column(name = "modified_by")
    private Integer modifiedBy;
    @Column(name = "modified_date")
    private OffsetDateTime modifiedDate;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Boolean getTieneMarcadores() {
        return tieneMarcadores;
    }

    public void setTieneMarcadores(Boolean tieneMarcadores) {
        this.tieneMarcadores = tieneMarcadores;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Integer getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
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
