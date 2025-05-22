package fiap.tds.resource;

import fiap.tds.DTOS.EventDTO;
import fiap.tds.models.Event;
import fiap.tds.models.TypeEvent;
import fiap.tds.services.EventService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/ChatCCO")
public class ChatResource {
    @Inject
    EventService eventService;
    @POST
    @Transactional
    @Path("{TypeEvent}")
    public Response reportEvent(@PathParam("TypeEvent") String typeEvent){
        var tipo = TypeEvent.fromString(typeEvent);
        eventService.criarEvento(tipo);
        return Response.ok("Evento criado com Sucesso.").build();
    }
    @GET
    @Path("/Historico")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        return Response.ok(eventService.getAll()).build();
    }
}

