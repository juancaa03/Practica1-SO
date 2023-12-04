/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import authn.Secured;
import jakarta.ejb.Stateless;
import jakarta.ws.rs.Path;
import model.entities.Usuari;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import authn.Secured;
import jakarta.ws.rs.QueryParam;


@Stateless
@Path("/rest/api/v1/usuari")

public class UsuariFacadeREST extends AbstractFacade<Usuari> {

    @PersistenceContext(unitName = "Homework1PU")
    private EntityManager em;
    
    public UsuariFacadeREST() {
        super(Usuari.class);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCustomers() {
        List<Usuari> custList = em.createNamedQuery("Customer.allCustomers").getResultList();
        GenericEntity<List<Usuari>> gc = new GenericEntity<List<Usuari>>(custList){};
        return Response.ok().entity(gc).build();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getCustomer(@PathParam("id") Long id) {
        Usuari cust = em.find(Usuari.class, id);
        if(cust == null) return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok().entity(cust).build();
    }
    
    @PUT
    @Path("{id}")
    @Secured
    @Consumes({MediaType.APPLICATION_JSON})
    public Response updateCustomer(@PathParam("id") Long id, Usuari newCustData) {
        Usuari cust = em.find(Usuari.class, id);
        if(cust == null) return Response.status(Response.Status.NOT_FOUND).build();
        
        String userName = newCustData.getNomUsuari();
        String email = newCustData.getCorreu();
        String password = newCustData.getContrasenya();
        
        /*if(userName == null || email == null || password == null)
            return Response.status(Response.Status.BAD_REQUEST).entity("Parameter/s missing.").build();
        if(userName.isEmpty() || email.isEmpty() || password.isEmpty())
            return Response.status(Response.Status.BAD_REQUEST).entity("Cannot have empty fields.").build();*/
        
        cust.setNomUsuari(userName);
        cust.setCorreu(email);
        cust.setContrasenya(password);
        
        em.persist(cust);
        return Response.noContent().build();
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
