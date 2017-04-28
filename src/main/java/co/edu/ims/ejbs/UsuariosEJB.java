package co.edu.ims.ejbs;

import co.edu.ims.modelo.Usuarios;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Stateless
@Path("/usuarios")
public class UsuariosEJB {

    @PersistenceContext(unitName = "controlAccesoPU")
    protected EntityManager em;

    @GET
    @Produces("application/json")
    @Path("{id}")
    
    public Usuarios buscar(@PathParam("id") Integer id) {
        System.out.println("pasa por aqui...");
        return em.find(Usuarios.class, id);

    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Usuarios agregar(Usuarios entity) {
        em.persist(entity);
        em.flush();
        return entity;
    }

}
