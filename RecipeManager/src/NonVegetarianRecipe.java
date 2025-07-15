import java.util.Set;

class NonVegetarianRecipe extends abstractRecipe implements RecommendationInterface, SearchInterface {
    private String vegCookingSteps;

    public NonVegetarianRecipe(String name, int preparationTime, Set<String> ingredients, Set<String> tags, HealthyCheck healthCheck) {
        super(name, preparationTime, ingredients, tags, healthCheck, false);
    }


    void nonVegCookingLogic() {

    }
}
