/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import jakarta.ejb.Stateless;
import jakarta.ws.rs.Path;
import model.entities.Lloguer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Stateless
@Path("rest/api/v1/lloguer")
public class LloguerFacadeREST extends AbstractFacade<Lloguer> {

    @PersistenceContext(unitName = "Homework1PU")
    private EntityManager em;
    
    public LloguerFacadeREST() {
        super(Lloguer.class);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Lloguer find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @POST
    @Path("/rental")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public RentalResponse rentGames(List<Integer> gameIds) {
        // Implementa la lógica para formalizar el lloguer y retorna la respuesta adecuada
    }
    
    // Otros métodos opcio
