
package co.edu.ims.web;

import co.edu.ims.ejbs.AuditoriaEJB;
import co.edu.ims.modelo.Auditoria;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

@ManagedBean
@SessionScoped
public class AuditoriaBean {
    
     @Inject AuditoriaEJB auditoriaEJB;
    
    private List<Auditoria> auditorias;    
    private Auditoria auditoria;
    
    public AuditoriaBean(){        
    }
    
    @PostConstruct
    public void init(){
        auditorias = auditoriaEJB.buscarTodos();
        auditoria = new Auditoria();
    }
    
     public String guardar(){
        System.out.println("guardar...");
        auditoriaEJB.crear(auditoria);        
        init();
        return null;
    }

    public List<Auditoria> getAuditorias() {
        return auditorias;
    }

    public void setAuditorias(List<Auditoria> auditorias) {
        this.auditorias = auditorias;
    }

    public Auditoria getAuditoria() {
        return auditoria;
    }

    public void setAuditoria(Auditoria auditoria) {
        this.auditoria = auditoria;
    }
    
   

    
    
}
