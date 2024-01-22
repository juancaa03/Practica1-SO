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
import model.entities.Lloguer;
import authn.Secured;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.core.Response;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
//import java.sql.Date;
import java.util.Date;
import java.util.Base64;
import java.util.Calendar;
import model.entities.LloguerRequest;
import model.entities.RebutLloguer;
import model.entities.Usuari;
import model.entities.Videojoc;

@Stateless
@Path("rest/api/v1/lloguer")
public class LloguerFacadeREST extends AbstractFacade<Lloguer> {

    @PersistenceContext(unitName = "Homework1PU")
    private EntityManager em;

    public LloguerFacadeREST() {
        super(Lloguer.class);
    }
    
    @GET
    @Secured
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response find(@PathParam("id") Long id) {
        return Response.ok().entity(super.find(id)).build();
    }
    
    @POST
@Consumes({MediaType.APPLICATION_JSON})
//@Secured
public Response rentVideojocs(LloguerRequest lloguerRequest) {
    try {
        // Verificar la disponibilidad del videojuego y calcular el precio total
        double precioTotal = 0;

        Videojoc videojoc = em.find(Videojoc.class, lloguerRequest.getVideojoc().getId());
        if (videojoc == null || !videojoc.isDisponibilitat()) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("El videojuego no está disponible o no existe")
                    .build();
        }
        precioTotal += videojoc.getPreuLloguer();

        Usuari usuari = em.find(Usuari.class, lloguerRequest.getUsuari().getId());
        if (usuari == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("El usuario no existe")
                    .build();
        }

        // Obtener la fecha actual
        Date fechaActual = new Date();

        // Establecer la fecha de inicio como la fecha actual
        Calendar calendarInicio = Calendar.getInstance();
        calendarInicio.setTime(fechaActual);
        Date dataInici = calendarInicio.getTime();

        // Establecer la fecha de fin como la fecha actual más 5 días
        Calendar calendarFin = Calendar.getInstance();
        calendarFin.setTime(fechaActual);
        calendarFin.add(Calendar.DAY_OF_MONTH, 7);
        Date dataFi = calendarFin.getTime();

        // Crear un nuevo objeto Lloguer y persistirlo
        Lloguer lloguer = new Lloguer();
        lloguer.setVideojoc(videojoc);
        lloguer.setUsuari(usuari);
        lloguer.setDataInici(new java.sql.Date(dataInici.getTime()));
        lloguer.setDataFi(new java.sql.Date(dataFi.getTime()));
        lloguer.setPreuTotal(precioTotal);
        em.persist(lloguer);
        
        RebutLloguer rebut = new RebutLloguer(lloguer.getId(), lloguer.getDataInici(), lloguer.getDataFi(), lloguer.getPreuTotal());
        // Devolver la respuesta con el identificador del lloguer y el precio total
        return Response.status(Response.Status.CREATED)
                .entity(rebut)
                .build();
    } catch (Exception e) {
        // Manejar la excepción y devolver el código de error correspondiente
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity("Error al procesar el lloguer")
                .build();
    }
}



    /*private boolean isAvailable(Long videojocId) {
        
        return true;
    }*/
    
    @GET
    @Secured
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<Lloguer> findAll() {
        return super.findAll();
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}

