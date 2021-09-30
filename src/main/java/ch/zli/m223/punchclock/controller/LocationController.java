package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.Entry;
import ch.zli.m223.punchclock.domain.Location;
import ch.zli.m223.punchclock.service.LocationService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.util.List;

/**
 * Klasse dient dazu, dass man eine Location nicht über ein SQL Skript adden muss
 * dazu, dass es nicht immer die gleichen Locations sind
 */
@Path("/loca")
@Tag(name = "Locations", description = "Handling of locations")
public class LocationController {
    @Inject
    LocationService locationService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "List all locations", description = "A list of all locations is returned")
    public List<Location> list() {
        return this.locationService.findAll();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Get a location with help of the ID", description = "The location which was found is returned")
    @Path("/{location")
    public Location getLocation(@PathParam("location") Long Id) { return this.locationService.getLocation(Id);}

    @DELETE
    @Operation(summary = "Delete a location with help of the ID", description = "Nothing is returned (void)")
    @PathParam("/{location}")
    public void delete(@PathParam("location") Long Id) {this.locationService.delete(Id);}

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Update a location with help of the location parameter", description = "The updated location is returned")
    @Consumes(MediaType.APPLICATION_JSON)
    public Location updateLocation(Location location) {
        return this.locationService.update(location);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Add a new Location", description = "The newly created location is returned. The Id may not be passed")
    public Location add(Location location) {return this.locationService.createLocation(location);}

    @DELETE
    @Operation(summary = "Delete a location with help of the location parameter", description = "Nothing is returned (void)")
    public void delete(Location location) {this.locationService.findAll().remove(location);}


}
