package Mendix.db;

/**
 * HashCode Object based on name for Identifying recipe.
 */
public final class RecipeId {

    private final String recipeName;

    public RecipeId(String recipeName){
        this.recipeName = recipeName;
    }

    @Override
    public int hashCode() {
        return recipeName.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof RecipeId))
            return false;
        return ((RecipeId) obj).recipeName.equalsIgnoreCase(recipeName);
    }
}
