package Mendix.api;

import java.util.List;

public class CategoriesWrap {

    private int results;
    private List<String> categories;

    public int getResults() {
        return results;
    }

    public void setResults(int results) {
        this.results = results;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }
}
