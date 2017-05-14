package co.edu.ims.modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Rol implements Serializable{
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String nombre_rol;
    
    

    public Rol() {
    }

    public Rol(String nombre_rol) {
        this.nombre_rol = nombre_rol;
    }

    public String getNombre_rol() {
        return nombre_rol;
    }

    public void setNombre_rol(String nombre_rol) {
        this.nombre_rol = nombre_rol;
    }
    
    
    
    
    
    
}
