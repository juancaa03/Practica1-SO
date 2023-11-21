/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import jakarta.ejb.Stateless;
import jakarta.ws.rs.Path;
import model.entities.Videojoc;
import jakarta.persistence.EntityManager;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Stateless
@Path("rest/api/v1/videojoc")
public class VideojocFacadeREST extends AbstractFacade<Videojoc> {

    public VideojocFacadeREST() {
        super(Videojoc.class);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Videojoc> findAll() {
        // Implementa la lógica para obtener la lista de videojuegos
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Videojoc find(@PathParam("id") Integer id) {
        // Implementa la lógica para obtener un videojuego por ID
    }

    @GET
    @Path("/search")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Videojoc> searchGames(
            @QueryParam("type") String type,
            @QueryParam("console") String console) {
        // Implementa la lógica para buscar videojuegos según los parámetros
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createGame(Videojoc entity) {
        // Implementa la lógica para crear un nuevo videojuego
    }
    
    // Otros métodos opcionales según las especificaciones
}
