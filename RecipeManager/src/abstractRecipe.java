import java.util.Set;

public class abstractRecipe implements RecommendationInterface, SearchInterface{
    private final String name;
    private final int preparationTime;
    private final Set<String> ingredients;
    private final Set<String> tags;
    private final HealthyCheck healthChecker;
    private final boolean isVegetarian;

    public String getName() {
        return name;
    }

    public int getPreparationTime() {
        return preparationTime;
    }

    public Set<String> getIngredients() {
        return ingredients;
    }

    public Set<String> getTags() {
        return tags;
    }

    public HealthyCheck getHealthChecker() {
        return healthChecker;
    }

    public boolean isVegetarian() {
        return isVegetarian;
    }

    @Override
    public Double similarityScore(Set<String> availableIngredients) {
        double matchingIngredients = 0;
        int ingredientLength = this.getIngredients().size();

        for (String available : availableIngredients) {
            for (String ingredients : this.getIngredients()) {
                if (ingredients.contains(available)) {
                    matchingIngredients++;
                }
            }
        }
        return (matchingIngredients / ingredientLength) * 100;
    }

    @Override
    public boolean Search(Set<String> searchTags) {
        for  (String tag : searchTags) {
            if (this.getTags().contains(tag)) {
                return true;
            }
        }
        return false;
    }

    public abstractRecipe(String name, int preparationTime, Set<String> ingredients, Set<String> tags, HealthyCheck healthChecker, boolean isVegetarian) {
        this.name = name;
        this.preparationTime = preparationTime;
        this.ingredients = ingredients;
        this.tags = tags;
        this.healthChecker = healthChecker;
        this.isVegetarian = isVegetarian;
    }


}


