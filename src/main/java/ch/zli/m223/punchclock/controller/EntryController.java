package ch.zli.m223.punchclock.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.punchclock.domain.Entry;
import ch.zli.m223.punchclock.service.EntryService;
// localhost:8080/entries => Aufruf
@Path("/entries")
@Tag(name = "Entries", description = "Handling of entries")
public class EntryController {

    @Inject
    EntryService entryService;

    @GET
    // Gibt ein JSON zurück
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "List all Entries", description = "A list of all Entries is returned")
    // Holt sich alle Elemente
    public List<Entry> list() {
        return entryService.findAll();
    }

    // Holt sich 1 JSON
    // GET Request
    @GET
    // Gibt JSON Back
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Get a entry with help of the ID", description = "The entry which was found is returned")
    // Zahl, welche nach /entries in die URL mitgegeben wird
    @Path("/{id}")
    // PathParam = Mappen
    public Entry getEntry(@PathParam("id") Long id) {
        return entryService.getEntry(id);
    }

    // Element löschen
    @DELETE
    @Operation(summary = "Delete a Entry with help of the ID", description = "Nothing is returned (void)")
    @Path("/{id}")
    // void weil nichts returnt werden muss
    public void delete(@PathParam("id") Long id) {
        entryService.delete(id);
    }

    // Entry (Element) updaten
    @PUT
    // Geben ein JSON zurück => JSON wird produziert
    @Produces(MediaType.APPLICATION_JSON)
    // JSON wird benötigt
    @Operation(summary = "Update a entry with help of the entry parameter", description = "the updated entry is returned")
    @Consumes(MediaType.APPLICATION_JSON)
    public Entry updateEntry(Entry entry) {
        return entryService.update(entry);
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Add a new Entry", description = "The newly created entry is returned. The id may not be passed.")
    public Entry add(Entry entry) {
       return entryService.createEntry(entry);
    }

    @DELETE
    @Operation(summary = "Delete a entry with help of the entry parameter", description = "Nothing is returned (void)")
    public void delete(Entry entry){this.entryService.findAll().remove(entry);}


}
