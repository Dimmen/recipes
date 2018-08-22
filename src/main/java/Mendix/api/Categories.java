package Mendix.api;

import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;

/** 
 * Categories for a Recipe.
 */
public class Categories {

    public Categories(){

    }

    public Categories(List<String> cat){
        this.cat = cat;
    }
    
    @NotEmpty
    private List<String> cat;

    public List<String> getCat() {
        return cat;
    }

    public void setCat(List<String> cat) {
        this.cat = cat;
    }


}