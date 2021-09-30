package ch.zli.m223.punchclock.controller;
// Gleiche Methoden einfach mit anderen Daten implementieren

import ch.zli.m223.punchclock.domain.Category;
import ch.zli.m223.punchclock.service.CategoryService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.util.List;

@Path("/categories")
@Tag(name = "Categories", description = "Handling of categories")
public class CategoryController {

    @Inject
    CategoryService categoryService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "List all categories", description = "")

    public List<Category> list() {return this.categoryService.findAll();}

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{category}")
    public Category getCategory(@PathParam("category") Long Id) {return this.categoryService.getCategory(Id);}

    @DELETE
    @Path("/{category}")
    public void delete(@PathParam("category") Long Id) {this.categoryService.delete(Id);}

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Category updateCategory(Category category) {return this.categoryService.update(category);}

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Add a new Category", description = "The newly created category is returned. The ID might not be passed")
    public Category add(Category category) {return this.categoryService.createCategory(category);}

    @DELETE
    public void delete(Category category){this.categoryService.findAll().remove(category);}

}
