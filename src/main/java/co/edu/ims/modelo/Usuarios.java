
package co.edu.ims.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Usuarios implements Serializable{
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_usuario;
    private String nombreUsuarios;
    private String correo;
    private String contrasena;
    
    private Persona persona;
    
    @ManyToMany
    @JoinTable(
            name="Auditoria",
            joinColumns = @JoinColumn(name ="usuario_id"),
            inverseJoinColumns=@JoinColumn(name="rol_id")) 
    private List<Rol> roles = new ArrayList<>();
    
    // Lista / Conjunto de Roles (Ver modelo Lista de generos para una pelicula)
    
    

    public Usuarios() {
    }

    public Usuarios(Integer id_usuario, String nombreUsuarios, String correo, String contrasena) {
        this.id_usuario = id_usuario;
        this.nombreUsuarios = nombreUsuarios;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombreUsuarios() {
        return nombreUsuarios;
    }

    public void setNombreUsuarios(String nombreUsuarios) {
        this.nombreUsuarios = nombreUsuarios;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    
    
}
