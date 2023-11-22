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
@Path("lloguer")
public class LloguerFacadeREST extends AbstractFacade<Lloguer> {

    @PersistenceContext(unitName = "Homework1PU")
    private EntityManager em;
    
    public LloguerFacadeREST() {
        super(Lloguer.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
