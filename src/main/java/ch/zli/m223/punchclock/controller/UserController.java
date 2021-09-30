package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.User;
import ch.zli.m223.punchclock.service.UserService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.util.List;

@Path("/users")
@Tag(name = "Users", description = "Handling of users")
public class UserController {

    @Inject
    UserService userService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "List all Users", description = "A list of all users is returned")
    public List<User> list() {
        return this.userService.findAll();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Get a User with help of the ID", description = "The user which was found is returned")
    @Path("/{user}")
    public User getUser(@PathParam("user") Long Id) {return this.userService.getUser(Id);}

    @DELETE
    @Operation(summary = "Delete a User with help of the ID", description = "Nothing is returned (void)")
    @Path("/{user}")
    public void delete(@PathParam("user") Long Id) {this.userService.delete(Id);}

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Update a User with help of the user parameter", description = "The updated user is returned")
    @Consumes(MediaType.APPLICATION_JSON)
    public User updateUser(User user) {
        return this.userService.update(user);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Add a new User", description = "The newly created user is returned. The ID may not be passed")
    public User add(User user) {
        return this.userService.createUser(user);
    }

    @DELETE
    @Operation(summary = "Delete a User with help of the user parameter", description = "Nothing is returned (void)")
    public void delete(User user) {this.userService.findAll().remove(user);}

}
