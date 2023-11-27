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
import java.util.List;

@Stateless
@Path("lloguer")
public class LloguerFacadeREST extends AbstractFacade<Lloguer> {

    @PersistenceContext(unitName = "Homework1PU")
    private EntityManager em;
    
    public LloguerFacadeREST() {
        super(Lloguer.class);
    }
    
    @POST
    @Secured
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createSale(@QueryParam("store") String store, SaleRequest saleReq){
        Sale newSale = new Sale();
        Customer cust = em.find(Customer.class, saleReq.getCustomerId());
        if(cust == null) return Response.status(Response.Status.NOT_FOUND).entity("Customer not found").build();
        Store store2 = findStore(store);
        if(store2 == null) return Response.status(Response.Status.NOT_FOUND).entity("Store not found").build();
        
        Collection<ProductSale> auxProductList = new ArrayList<>();
        for(SaleRequestUnit saleReqUnit : saleReq.getProducts()){
            Product auxProduct = store2.findProduct(saleReqUnit.getProductId());
            if(auxProduct == null) return Response.status(Response.Status.NOT_FOUND).entity("Product not found in store").build();
            ProductSale auxProductSale = 
                    new ProductSale(auxProduct, newSale, saleReqUnit.getQuantity(), saleReqUnit.getSize(), saleReqUnit.getSweetener());
            auxProductList.add(auxProductSale);
            em.persist(auxProductSale);
        }
        
        newSale.setCust(cust);
        newSale.setStore(store2);
        newSale.setProducts(auxProductList);

        em.persist(newSale);
        return Response.status(Response.Status.CREATED).build();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Secured
    @Path("{id}")
    public Response getSale(@PathParam("id") Long id) {
        Sale sl = em.find(Sale.class, id);
        if(sl == null) return Response.status(Response.Status.NOT_FOUND).build();
        Customer tempCust = sl.getCust();
        sl.setCust(tempCust);
        
        return Response.ok().entity(sl).build();
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
