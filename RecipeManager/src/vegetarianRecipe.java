import java.util.Set;

class vegetarianRecipe extends abstractRecipe implements RecommendationInterface, SearchInterface {

    private String vegCookingSteps;

    public vegetarianRecipe(String name, int preparationTime, Set<String> ingredients, Set<String> tags, HealthyCheck healthCheck) {
        super(name, preparationTime, ingredients, tags, healthCheck, true);
    }

    void vegCookingLogic() {

    }
}
