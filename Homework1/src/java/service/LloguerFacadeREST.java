/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import authn.Secured;
import jakarta.ejb.Stateless;
import jakarta.ws.rs.Path;
import model.entities.Lloguer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import model.entities.*;

@Stateless
@Path("rest/api/v1/rental")
public class LloguerFacadeREST extends AbstractFacade<Lloguer> {

    @PersistenceContext(unitName = "Homework1PU")
    private EntityManager em;
    
    public LloguerFacadeREST() {
        super(Lloguer.class);
    }
    
    /*@POST
    @Secured
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createSale(@QueryParam("store") String store, SaleRequest saleReq){
        Lloguer newSale = new Lloguer();
        Usuari cust = em.find(Usuari.class, saleReq.getCustomerId());
        if(cust == null) return Response.status(Response.Status.NOT_FOUND).entity("Customer not found").build();
        Botiga store2 = findStore(store);
        if(store2 == null) return Response.status(Response.Status.NOT_FOUND).entity("Store not found").build();
        
        Collection<Lloguer> auxProductList = new ArrayList<>();
        for(SaleRequestUnit saleReqUnit : saleReq.getProducts()){
            Videojoc auxProduct = store2.findProduct(saleReqUnit.getProductId());
            if(auxProduct == null) return Response.status(Response.Status.NOT_FOUND).entity("Product not found in store").build();
            RebutLloguer auxProductSale = 
                    new RebutLloguer(auxProduct, newSale, saleReqUnit.getQuantity(), saleReqUnit.getSize(), saleReqUnit.getSweetener());
            auxProductList.add(auxProductSale);
            em.persist(auxProductSale);
        }
        
        newSale.setUsuari(cust);
        newSale.setBotiga(store2);
        newSale.setVideojoc((Videojoc) auxProductList);

        em.persist(newSale);
        return Response.status(Response.Status.CREATED).build();
    }*/
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Secured
    @Path("{id}")
    public Response getSale(@PathParam("id") Long id) {
        Lloguer sl = em.find(Lloguer.class, id);
        if(sl == null) return Response.status(Response.Status.NOT_FOUND).build();
        Usuari tempCust = sl.getUsuari();
        sl.setUsuari(tempCust);
        
        return Response.ok().entity(sl).build();
    }
    
    public Botiga findStore(String cityName){
        try{
            Botiga s = (Botiga) em.createNamedQuery("Store.findStoreByName").setParameter("cityName", cityName).getSingleResult();
            return s;
        }
        catch(Exception e){
            return null;
        }
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
