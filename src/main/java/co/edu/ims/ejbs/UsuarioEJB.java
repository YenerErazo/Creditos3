package co.edu.ims.ejbs;

import co.edu.ims.modelo.Auditoria;
import co.edu.ims.modelo.Rol;
import co.edu.ims.modelo.Usuario;
import java.util.Date;
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
@Path("/usuario")
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
    public List<Usuario> buscarTodos(){
        String jpql = "SELECT usu FROM Usuario usu";
        TypedQuery<Usuario> q = em.createQuery(jpql, Usuario.class);
        List<Usuario> resultado = q.getResultList();
        return resultado;
    }
    
    @GET
    @Path("/nombre/{nombre}")
    @Produces("application/json")
    public List<Usuario> buscarPorNombre(@PathParam("nombre") String nombre){
    String jpql = "SELECT usu FROM Usuario usu WHERE usu.nombre LIKE :uNombre";
        TypedQuery<Usuario> q = em.createQuery(jpql, Usuario.class);
        q.setParameter("uNombre", "%"+nombre+"%");
        List<Usuario> resultado = q.getResultList();
        return resultado;
            
}

   @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Usuario actualizar(Usuario u){
        em.merge(u);
        return u;
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
    
    @PUT
    @Produces("application/json")
    @Consumes("application/json")
    
    public Usuario crear(Usuario u){
        em.persist(u);
        em.flush();
        return u;
    }
    
    @POST
    @Path("/asignarrol/{idUsu}/{idRol}")
    @Produces("application/json")
    public Auditoria asiganarRol(Auditoria a){
        em.persist(a);
        em.flush();       
        return a;
    }
    
    


   
}
