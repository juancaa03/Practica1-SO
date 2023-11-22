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
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    // Otros métodos opcionales según las especificaciones
}
