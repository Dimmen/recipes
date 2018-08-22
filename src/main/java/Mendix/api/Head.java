package Mendix.api;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.Valid;


public class Head {

    @NotEmpty
    private String title;
    
    @NotNull
    @Valid
    private Categories categories;
    
    @NotEmpty
    private String yield;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    public String getYield() {
        return yield;
    }

    public void setYield(String yield) {
        this.yield = yield;
    }


}