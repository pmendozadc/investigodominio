package pe.edu.universidad.investigodominio.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.OffsetDateTime;

@Entity
public class HistorialCopia {

    @Id
    private int idHistorialCopia;

    private int idReparto;
    private int idCopia;
    private int idPlantilla;
    private String email;
    private OffsetDateTime fechaArchivado;
    private int createdBy;
    private OffsetDateTime createdDate;
    private int modifiedBy;
    private OffsetDateTime modifiedDate;

    public int getIdHistorialCopia() {
        return idHistorialCopia;
    }

    public void setIdHistorialCopia(int idHistorialCopia) {
        this.idHistorialCopia = idHistorialCopia;
    }

    public int getIdReparto() {
        return idReparto;
    }

    public void setIdReparto(int idReparto) {
        this.idReparto = idReparto;
    }

    public int getIdCopia() {
        return idCopia;
    }

    public void setIdCopia(int idCopia) {
        this.idCopia = idCopia;
    }

    public int getIdPlantilla() {
        return idPlantilla;
    }

    public void setIdPlantilla(int idPlantilla) {
        this.idPlantilla = idPlantilla;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public OffsetDateTime getFechaArchivado() {
        return fechaArchivado;
    }

    public void setFechaArchivado(OffsetDateTime fechaArchivado) {
        this.fechaArchivado = fechaArchivado;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public OffsetDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(OffsetDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public int getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(int modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public OffsetDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(OffsetDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}