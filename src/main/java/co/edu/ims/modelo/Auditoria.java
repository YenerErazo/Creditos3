package co.edu.ims.modelo;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Auditoria {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Boolean estado;
    private Date fechaInicio;
    private Date fechaFin;
    
    @OneToMany 
    private Usuario id_usuario;
    
    @OneToMany
    private Rol id_rol;

    public Auditoria() {
    }

    public Auditoria(Usuario id_usuario, Rol id_rol, Boolean estado, Date fechaInicio, Date fechaFin) {
        this.id_usuario = id_usuario;
        this.id_rol = id_rol;
        this.estado = estado;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Usuario getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Rol getId_rol() {
        return id_rol;
    }

    public void setId_rol(Rol id_rol) {
        this.id_rol = id_rol;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
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
    
    
    
}
