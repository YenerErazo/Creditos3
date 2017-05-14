
package co.edu.ims.ejbs;

import co.edu.ims.modelo.Persona;
import co.edu.ims.modelo.Rol;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Stateless
@Path("/rol")
public class RolEJB {
    
    
     @PersistenceContext(unitName = "controlAccesoPU")
    protected EntityManager em;
        
    @GET
    @Produces("application/json")
    @Path("{id}")
    public Rol buscar(@PathParam("id") Integer id){
        System.out.println("pasa por aqui...");
       return em.find(Rol.class , id);
        
    }
    
    @GET
    @Produces("application/json")
    public List<Rol> buscar(){
        String jpql = "SELECT rol FROM Rol rol";
        TypedQuery<Rol> q = em.createQuery(jpql, Rol.class);
        List<Rol> resultado = q.getResultList();
        return resultado;
    }
    
    
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Rol agregar(Rol entity){
        em.persist(entity);
        em.flush();
        return entity;
    }
    
    @DELETE
    @Path("(id)")
    @Produces("application/json")
    public String eliminar(@PathParam("id") Integer pId){
        Rol r = em.find(Rol.class, pId);
        if(r != null){
            em.remove(r);
        }
        return "()";
    }
    
}
