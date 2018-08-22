package Mendix.api;

import Mendix.db.RecipeId;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;


public class Recipe {
	
    @NotNull
    @Valid
    private Head head;
    
    @NotNull
    private Ingredients ingredients;
    
    @NotNull
    private Directions directions;

    public Recipe(){

    }

    public Recipe(Head head , Ingredients ingredients , Directions directions){
        this.head = head;
        this.ingredients = ingredients;
        this.directions = directions;
    }
    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public Ingredients getIngredients() {
        return ingredients;
    }

    public void setIngredients(Ingredients ingredients) {
        this.ingredients = ingredients;
    }

    public Directions getDirections() {
        return directions;
    }

    public void setDirections(Directions directions) {
        this.directions = directions;
    }
    
    public RecipeId generateRecipeId(){
        return new RecipeId(head.getTitle());
    }

}