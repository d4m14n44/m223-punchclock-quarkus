package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.User;
import ch.zli.m223.punchclock.service.AuthenticationService;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/auth")
public class AuthenticationController {
    // Controller = Anfragen zu REST
    // Auf eine Methode zugreifen, ohne eine Instanz zu machen
    /**
     * Controller hat keine Verbindung zur DB, das macht der Service (EntityManager nicht im Controller verwenden)
     */
    @Inject
    AuthenticationService authenticationService;

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String logIn(User user)
    {
        // TODO check if user exists, if not then throw NotAuthorizedException (JPQL)

        if (authenticationService.checkIfUserExists(user)) {
            return this.authenticationService.GenerateValidJwtToken(user.getUsername());
        } else {
            throw new NotAuthorizedException("verlore");
        }
    }

}
