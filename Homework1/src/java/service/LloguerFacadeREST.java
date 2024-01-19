package service;

import java.util.List;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import model.entities.Lloguer;
import authn.Secured;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.core.Response;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import model.entities.Usuari;

@Stateless
@Path("rest/api/v1/lloguer")
public class LloguerFacadeREST extends AbstractFacade<Lloguer> {

    @PersistenceContext(unitName = "Homework1PU")
    private EntityManager em;

    public LloguerFacadeREST() {
        super(Lloguer.class);
    }
    
    @GET
    @Secured
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response find(@PathParam("id") Long id) {
        return Response.ok().entity(super.find(id)).build();
    }
    
    
    @GET
    @Secured
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<Lloguer> findAll() {
        return super.findAll();
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}

