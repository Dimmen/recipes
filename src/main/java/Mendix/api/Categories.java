package Mendix.api;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.List;

/** Represent Categories for a Recipe.
 */
public class Categories {

    /**
     * Default contructor for Serialization
     */
    public Categories(){

    }

    /**
     * Constructor to specify categories
     */
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