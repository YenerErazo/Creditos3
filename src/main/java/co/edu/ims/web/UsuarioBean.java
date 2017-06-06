package co.edu.ims.web;

import co.edu.ims.ejbs.AuditoriaEJB;
import co.edu.ims.ejbs.PersonaEJB;
import co.edu.ims.ejbs.RolEJB;
import co.edu.ims.ejbs.UsuarioEJB;
import co.edu.ims.modelo.Auditoria;
import co.edu.ims.modelo.Persona;
import co.edu.ims.modelo.Rol;
import co.edu.ims.modelo.Usuario;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;


@ManagedBean
@RequestScoped
public class UsuarioBean {
    
     @Inject UsuarioEJB usuarioEJB;
     @Inject PersonaEJB personaEJB;
     @Inject AuditoriaEJB auditoriaEJB;
     @Inject RolEJB rolEJB;
    
    private List<Usuario> usuarios;
    private List<Persona> personas;
    private List<Rol> roles;
    private Usuario usuario;
    private Auditoria auditoria;
    private Rol rol;

    public UsuarioBean() {
    }
    
    
    @PostConstruct
    public void init(){
        usuarios = usuarioEJB.buscarTodos();
        personas = personaEJB.buscarTodos();
        roles = rolEJB.buscarTodos();
        usuario = new Usuario();
        rol = new Rol();
    }
    
    public String guardar(){
        System.out.println("guardar...");
        Persona p = personaEJB.buscar(usuario.getPersona().getIdentificacion());
        usuario.setPersona(p);
        usuarioEJB.crear(usuario);        
        init();
        return null;
    }
    public String asignarRol(){
        Rol r = rolEJB.buscar(rol.getIdRol());
        Usuario u = usuarioEJB.buscar(usuario.getIdUsuario());
        auditoria.setId_rol(r);
        auditoria.setId_usuario(u);
        auditoria.setEstado(true);
        auditoria.setFechaInicio(null);
        auditoria.setFechaFin(null);
        auditoriaEJB.crear(auditoria);
        init();
        return null;
        
    }
    
 

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UsuarioEJB getUsuarioEJB() {
        return usuarioEJB;
    }

    public void setUsuarioEJB(UsuarioEJB usuarioEJB) {
        this.usuarioEJB = usuarioEJB;
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }
    
    
    
}
