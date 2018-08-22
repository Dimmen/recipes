package Mendix.db;


import Mendix.api.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class RecipeDB  {

    private final Map<RecipeId , Recipe> recipesMemDB = new ConcurrentHashMap<>();
    private final List<String> categoriesList = new ArrayList<>();
   
    /*
     * 
     * Get all recipes without any parameters (e.g. like category)
     */
    public List<Recipe> getAllRecipe() throws WebApplicationException {
        List<Recipe> recipeList = new ArrayList<>(recipesMemDB.values());
        if (recipeList == null || recipeList.isEmpty())
        	throw new WebApplicationException(Response.Status.NO_CONTENT);
        return recipeList;
    }
    
    /*
     * 
     * Get all category without any doubles
     */
    public List<String> getCategories() throws WebApplicationException {
    	if (categoriesList.isEmpty()) {
    		throw new WebApplicationException(Response.Status.NO_CONTENT);
    	}
    	//Remove double values
    	Set<String> hs = new HashSet<>();
    	hs.addAll(categoriesList);
    	categoriesList.clear();
    	categoriesList.addAll(hs);
        return categoriesList;
    }
    
    /*
     * For post request..
     * 
     * (non-Javadoc)
     * @see Mendix.db.Repo#addRecipe(Mendix.api.Recipe)
     */
    public void addRecipe(Recipe recipe) throws WebApplicationException {  
        if (isRecipeAlreadyExists(recipe))
        	throw new WebApplicationException(Response.Status.CONFLICT);
        recipesMemDB.put(recipe.generateRecipeId(),recipe);
        categoriesList.addAll(recipe.getHead().getCategories().getCat());
    }

    public List<Recipe> getRecipesFilter(String filterName) throws WebApplicationException {  
    	if (!ifFilterExists(filterName)){
    		Map<RecipeId, Recipe> recipeListTemp = new HashMap<RecipeId, Recipe>();
    		for (Entry<RecipeId, Recipe> entry : recipesMemDB.entrySet()) {
    			for (int i=0; i<entry.getValue().getHead().getCategories().getCat().size(); i++) {
    				if (entry.getValue().getHead().getCategories().getCat().get(i).equals(filterName)) {
    					recipeListTemp.put(entry.getKey(), entry.getValue());
    					break;
    				}
    			}
    		}
    		List<Recipe> recipeList = new ArrayList<>(recipeListTemp.values());
    		return recipeList;
    	} else {
    		throw new WebApplicationException(Response.Status.CONFLICT);	
    	}
    }
    
    
    /*
     * We get string Title from frontend
     */   
    public List<Recipe> getRecipesById(String id) throws WebApplicationException {  
    	RecipeId keyId = new RecipeId(id);
		Map<RecipeId, Recipe> recipeListTemp = new HashMap<RecipeId, Recipe>();
		for (Entry<RecipeId, Recipe> entry : recipesMemDB.entrySet()) {
    	        if (entry.getKey().hashCode() == keyId.hashCode()) {
    	        	recipeListTemp.put(entry.getKey(), entry.getValue());
    	        }
    	    }
		List<Recipe> recipeList = new ArrayList<>(recipeListTemp.values());
		return recipeList;
    }
    
    public List<Recipe> getRecipesSearch(String search) throws WebApplicationException {  
		Map<RecipeId, Recipe> recipeListTemp = new HashMap<RecipeId, Recipe>();
		for (Entry<RecipeId, Recipe> entry : recipesMemDB.entrySet()) {
			for (int i=0; i<entry.getValue().getHead().getCategories().getCat().size(); i++) {
				if (entry.getValue().getHead().getCategories().getCat().get(i).contains(search)) {
					recipeListTemp.put(entry.getKey(), entry.getValue());
				}
			}
			if (entry.getValue().getHead().getTitle().contains(search)) {
				recipeListTemp.put(entry.getKey(), entry.getValue());
			}
		}
		List<Recipe> recipeList = new ArrayList<>(recipeListTemp.values());
		return recipeList;
    }

    
    /*
     * 
     * Check if double using hashcode on title(in head)
     * 
     */
    private boolean isRecipeAlreadyExists(Recipe recipe){
        Recipe existingRecipe = recipesMemDB.get(recipe.generateRecipeId());
        if (existingRecipe != null)
            return true;
        return false;
    }
    
    /*
     * 
     * Check if filter excist (in memory)
     * 
     */
    private boolean ifFilterExists(String filter){
    	boolean isExist = false;
    	for(int i=0;i<categoriesList.size();i++){
    	    if(categoriesList.get(i).trim().toLowerCase().equals(filter)){
    	        isExist=true;
    	        break;
    	    }
    	}
    	return isExist;
    }
    
}
