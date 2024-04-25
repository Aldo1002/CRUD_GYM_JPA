package model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Inscripciones")
public class Inscripciones implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_inscripcion")
    private int idInscripcion;

    @ManyToOne
    @JoinColumn(name = "id_miembro")
    private Miembros miembro;

    @ManyToOne
    @JoinColumn(name = "id_plan")
    private Planes plan;

    @Column(name = "fecha_inicio")
    private Date fechaInicio;

    @Column(name = "fecha_fin")
    private Date fechaFin;

    // Constructores
    public Inscripciones() {
    }

    public Inscripciones(int idInscripcion, Miembros miembro, Planes plan, Date fechaInicio, Date fechaFin) {
        this.idInscripcion = idInscripcion;
        this.miembro = miembro;
        this.plan = plan;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    // Getters y Setters
    public int getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public Miembros getMiembro() {
        return miembro;
    }

    public void setMiembro(Miembros miembro) {
        this.miembro = miembro;
    }

    public Planes getPlan() {
        return plan;
    }

    public void setPlan(Planes plan) {
        this.plan = plan;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Override
    public String toString() {
        return "Inscripcion{" +
                "idInscripcion=" + idInscripcion +
                ", miembro=" + miembro +
                ", plan=" + plan +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                '}';
    }
}

