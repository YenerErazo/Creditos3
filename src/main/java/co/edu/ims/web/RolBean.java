package co.edu.ims.web;

import co.edu.ims.ejbs.RolEJB;
import co.edu.ims.modelo.Rol;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

@ManagedBean
@SessionScoped
public class RolBean {
    
    @Inject RolEJB rolEJB;
    
    private List<Rol> roles;    
    private Rol rol;
    
    public RolBean(){        
    }
    
    @PostConstruct
    public void init(){
        roles = rolEJB.buscarTodos();
        rol = new Rol();
    }
    
    public String guardar(){
        System.out.println("guardar...");
        rolEJB.crear(rol);        
        init();
        return null;
    }
    
    public String buscarRol(){
        rolEJB.buscarTodos();
        init();
        return null;
    }
    
    

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles= roles;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }  
    
}
