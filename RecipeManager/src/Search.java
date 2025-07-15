import java.util.HashSet;
import java.util.Set;

public class Search {
    private final Set<abstractRecipe> searchResults;

    public Search() {
        this.searchResults = new HashSet<>();
    }

    void search(Set<abstractRecipe>recipes, Set<String> tags){
        for (abstractRecipe recipe:recipes){
            if (recipe.Search(tags)){
                searchResults.add(recipe);
            }
        }
    }

    public Set<abstractRecipe> getSearchResults() {
        return searchResults;
    }
}
