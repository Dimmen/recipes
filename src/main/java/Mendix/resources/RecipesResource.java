package Mendix.resources;

import Mendix.api.*;
import Mendix.db.RecipeDB;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/recipes")
public class RecipesResource {

	RecipeDB recipeDB = new RecipeDB(); 

	
    @GET
    @Path("/search")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public List<Recipe> getRecipesSearch(@QueryParam("search") String search) throws WebApplicationException {
    	List<Recipe> recipes = recipeDB.getRecipesSearch(search);
    	if (recipes == null) {
    		throw new WebApplicationException(Response.Status.NO_CONTENT);
    	} else {
    		return recipes;
    	}
    }
	
    
    @POST
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    @Consumes(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public Response addRecipes(@Valid @NotNull Recipe recipe) throws WebApplicationException {
    	recipeDB.addRecipe(recipe);
    	return Response.status(201).build(); 
	}
        
    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public List<Recipe> getRecipes() throws WebApplicationException {
    	List<Recipe> recipes = recipeDB.getAllRecipe();
    	if (recipes == null) {
    		throw new WebApplicationException(Response.Status.NO_CONTENT);
    	} else {
    	return recipes;
    	}
	}
    
    @GET
    @Path("/category")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public List<String> getCategories() throws WebApplicationException {
    	List<String> recipes = recipeDB.getCategories();
    	if (recipes == null) {
    		throw new WebApplicationException(Response.Status.NO_CONTENT);
    	}
    	return recipes;
	}
    
    @GET
    @Path("/filter")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public List<Recipe> getRecipesFilter(@QueryParam("filter") String filter) throws WebApplicationException {
		List<Recipe> recipes = recipeDB.getRecipesFilter(filter);
    	if (recipes == null) {
    		throw new WebApplicationException(Response.Status.NO_CONTENT);
    	} else {
    		return recipes;
    	}
     }
    
    
    /*
     * Hier head.getTitle() versturen =string
     */
    @GET
    @Path("/id")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public List<Recipe> getRecipesById(@QueryParam("id") String id) throws WebApplicationException {
    	//For the details page of Mendix modeler.  
    	List<Recipe> RecipeList = recipeDB.getRecipesById(id);
    	if (RecipeList == null) {
    		throw new WebApplicationException(Response.Status.NO_CONTENT);
    	} else {
    	return RecipeList;
    	}
	}
}