import java.util.HashSet;
import java.util.Set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class RecipeManager {
    private final Set<abstractRecipe> recipes;
    Search searcher;
    Recommendation recommender;

    public RecipeManager() {
        recipes = new HashSet<>();
        searcher = new Search();
        recommender = new Recommendation();
    }

    public void addRecipe(abstractRecipe recipe) {
        recipes.add(recipe);
    }

    public void removeRecipe(abstractRecipe recipe) {
        recipes.remove(recipe);
    }

    public Set<abstractRecipe> getRecipes() {
        return recipes;
    }

    public Set<abstractRecipe> searchRecipes(Set<String> tags){
        searcher.search(recipes, tags);
        return searcher.getSearchResults();
    }

    public abstractRecipe recommendRecipe(Set<String> availableIngredients){
        return recommender.getRecommendedRecipe(availableIngredients, recipes);

    }

}