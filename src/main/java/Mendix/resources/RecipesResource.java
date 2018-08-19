package Mendix.resources;

import Mendix.api.*;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.common.base.Strings;


@Path("/recipes")
public class RecipesResource {
 
    public RecipesResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public List<Recipe> getRecipes(@QueryParam("search") Optional<String> search, 
    		@QueryParam("filter") Optional<String> filter) {
    	if (search.isPresent()) {
    		return RecipeResponse.getSearch(search);
    	} else if (filter.isPresent()) {
    		//Recipeswrapper
    		return RecipeResponse.getFilter();
    	} else
    		return RecipeResponse.getAll();

    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response getRecipes(Recipe recipe) {
    	//data validatie op plek waar dit wordt verwerkt. Misschien id terug geven.
    	return RecipeResponse.postRecipe(recipe);
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public Recipe getRecipesById(int id) {
    	//For the details page of Mendix modeler.    	
    	return RecipeResponse.getById();
    }
    
    @GET
    @Path("/category")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public List<Categories> getCategories() {
    	return CategoriesResponse.getAll();
    }
    
}