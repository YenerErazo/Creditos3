
package co.edu.ims.ejbs;

import co.edu.ims.modelo.Auditoria;
import co.edu.ims.modelo.Persona;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Stateless
@Path("/auditoria")
public class AuditoriaEJB {
    
   
     @PersistenceContext(unitName = "controlAccesoPU")
    protected EntityManager em;
        
    @GET
    @Produces("application/json")
    @Path("{id}")
    public Auditoria buscar(@PathParam("id") Integer id){
        System.out.println("pasa por aqui...");
       return em.find(Auditoria.class , id);
        
    }
    
    @GET
    @Produces("application/json")
    public List<Auditoria> buscarTodos(){
        String jpql = "SELECT aud FROM Auditoria aud";
        TypedQuery<Auditoria> q = em.createQuery(jpql, Auditoria.class);
        List<Auditoria> resultado = q.getResultList();
        return resultado;
    }
    
    
    
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Auditoria actualizar(Auditoria aud){
        em.merge(aud);
        return aud;
    }
    @PUT
    @Produces("application/json")
    @Consumes("application/json")
    
    public Auditoria crear(Auditoria aud){
        em.persist(aud);
        em.flush();
        return aud;
    }
    
    
    @DELETE
    @Path("(id)")
    @Produces("application/json")
    public String eliminar(@PathParam("id") Integer pId){
        Auditoria aud = em.find(Auditoria.class, pId);
        if(aud != null){
            em.remove(aud);
        }
        return "()";
    }
    
}
    
    
    
