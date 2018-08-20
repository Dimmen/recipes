package Mendix.api;

import java.util.List;

public class RecipesWrap {

    private int results;
    private long total;
    List<Recipe> recipes;

    public int getResults() {
        return results;
    }

    public void setResults(int results) {
        this.results = results;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }
}




