/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import jakarta.ejb.Stateless;
import jakarta.ws.rs.Path;
import model.entities.Videojoc;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Stateless
@Path("rest/api/v1/videojoc")
public class VideojocFacadeREST extends AbstractFacade<Videojoc> {

    @PersistenceContext(unitName = "Homework1PU")
    private EntityManager em;
    
    public VideojocFacadeREST() {
        super(Videojoc.class);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getProduct(@PathParam("id") Long id) {
        Videojoc prod = em.find(Videojoc.class, id);
        if(prod == null) return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok().entity(prod).build();
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
