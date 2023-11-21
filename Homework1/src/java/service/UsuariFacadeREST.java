/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import jakarta.ejb.Stateless;
import jakarta.ws.rs.Path;
import model.entities.Usuari;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Stateless
@Path("rest/api/v1/ususari")
public class UsuariFacadeREST extends AbstractFacade<Usuari> {

    @PersistenceContext(unitName = "Homework1PU")
    private EntityManager em;
    
    public UsuariFacadeREST() {
        super(Usuari.class);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuari> findAll() {
        // Implementa la lógica para obtener la lista de usuarios
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Usuari find(@PathParam("id") Integer id) {
        // Implementa la lógica para obtener un usuario por ID
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") Integer id, Usuari entity) {
        // Implementa la lógica para modificar un usuario
    }
    
    // Otros métodos opcionales según las especificaciones
}
