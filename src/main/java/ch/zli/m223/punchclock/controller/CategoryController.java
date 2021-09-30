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
    @Operation(summary = "List all categories", description = "A list of all categories is returned")

    public List<Category> list() {return this.categoryService.findAll();}

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Get a category with help of the ID", description = "The category which was found is returned")
    @Path("/{category}")
    public Category getCategory(@PathParam("category") Long Id) {return this.categoryService.getCategory(Id);}

    @DELETE
    @Operation(summary = "Delete a category with help of the ID", description = "Nothing is returned (void)")
    @Path("/{category}")
    public void delete(@PathParam("category") Long Id) {this.categoryService.delete(Id);}

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Update a category with help of the category parameter", description = "The updated category is returned")
    @Consumes(MediaType.APPLICATION_JSON)
    public Category updateCategory(Category category) {return this.categoryService.update(category);}

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Add a new Category", description = "The newly created category is returned. The ID might not be passed")
    public Category add(Category category) {return this.categoryService.createCategory(category);}

    @DELETE
    @Operation(summary = "Delete a Category", description = "Nothing is returned (void)")
    public void delete(Category category){this.categoryService.findAll().remove(category);}

}
