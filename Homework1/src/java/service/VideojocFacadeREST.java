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
import model.entities.Videojoc;
import authn.Secured;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.ws.rs.core.Response;

@Stateless
@Path("rest/api/v1/videojoc")
public class VideojocFacadeREST extends AbstractFacade<Videojoc> {

    @PersistenceContext(unitName = "Homework1PU")
    private EntityManager em;

    public VideojocFacadeREST() {
        super(Videojoc.class);
    }
    
    /*@GET
    @Secured
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response find(@PathParam("id") Long id) {
        return Response.ok().entity(super.find(id)).build();
    }*/
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAllVideojocs() {
        try {
            // Utiliza una consulta para obtener todos los videojuegos ordenados por nombre
            TypedQuery<Videojoc> query = em.createQuery("SELECT v FROM Videojoc v ORDER BY v.nom", Videojoc.class);
            List<Videojoc> videojocs = query.getResultList();
            return Response.ok(videojocs).build();
        } catch (Exception e) {
            // Manejar la excepción y devolver el código de error correspondiente
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error al obtener los videojuegos").build();
        }
    }
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Secured
    public Response addVideojoc(Videojoc videojoc) {
        try {
            // Verificar si el videojuego ya existe
            if (existeixVideojoc(videojoc.getNom())) {
                return Response.status(Response.Status.CONFLICT).entity("El videojuego ya existe").build();
            }

            // Si no existe, persistir el nuevo videojuego
            create(videojoc);

            // Devolver el código de estado 201 Created
            return Response.status(Response.Status.CREATED).build();
        } catch (Exception e) {
            // Manejar la excepción y devolver el código de error correspondiente
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error al agregar el videojuego").build();
        }
    }
    
    private boolean existeixVideojoc(String nom) {
        TypedQuery<Long> query = em.createQuery(
                "SELECT COUNT(v) FROM Videojoc v WHERE v.nom = :nom", Long.class)
                .setParameter("nom", nom);
        
        return query.getSingleResult() > 0;
    }
    /*@GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Videojoc> findAll() {
        return super.findAll();
    }*/
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}


