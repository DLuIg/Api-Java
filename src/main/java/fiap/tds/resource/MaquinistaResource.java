package fiap.tds.resource;

import fiap.tds.DTOS.LoginDTO;
import fiap.tds.services.MaquinistaService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/maquinista")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class MaquinistaResource {
    @Inject
    MaquinistaService maquinistaService;
    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(LoginDTO dto) {
        boolean autenticado = maquinistaService.autenticar(dto.getEmail(), dto.getSenha());
        if (autenticado) {
            return Response.ok("Login bem-sucedido").build();
        }
        else {
            return Response.status(Response.Status.UNAUTHORIZED).entity("Login ou Senha incorreta").build();
        }
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        return Response.ok(maquinistaService.getAll()).build();
    }
}