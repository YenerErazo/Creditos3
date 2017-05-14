package co.edu.ims.ejbs;

import co.edu.ims.modelo.Persona;
import co.edu.ims.modelo.Usuario;
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
@Path("/usuarios")
public class UsuarioEJB {

    @PersistenceContext(unitName = "controlAccesoPU")
    protected EntityManager em;

    @GET
    @Produces("application/json")
    @Path("{id}")
    
    public Usuario buscar(@PathParam("id") Integer id) {
        System.out.println("pasa por aqui...");
        return em.find(Usuario.class, id);

    }
    
    @GET
    @Produces("application/json")
    public List<Usuario> buscar(){
        String jpql = "SELECT usu FROM Usuario usu";
        TypedQuery<Usuario> q = em.createQuery(jpql, Usuario.class);
        List<Usuario> resultado = q.getResultList();
        return resultado;
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Usuario agregar(Usuario entity) {
        em.persist(entity);
        em.flush();
        return entity;
    }
    
    @DELETE
    @Path("(id)")
    @Produces("application/json")
    public String eliminar(@PathParam("id") Integer pId){
        Usuario u = em.find(Usuario.class, pId);
        if(u != null){
            em.remove(u);
        }
        return "()";
    }

}
