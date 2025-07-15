import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Initialize RecipeManager
        RecipeManager manager = new RecipeManager();

        // HealthyCheck config
        Set<String> healthyIngredients = new HashSet<>(Arrays.asList("Broccoli", "Carrot", "Garlic", "Chicken", "Spinach"));
        Set<String> badIngredients = new HashSet<>(Arrays.asList("Cream", "Soy Sauce", "Pasta", "Cheese"));

        HealthyCheck healthyCheck = new HealthyCheck(healthyIngredients, badIngredients);

        // Create recipes
        abstractRecipe vegStirFry = new vegetarianRecipe(
                "Vegetable Stir Fry",
                20,
                new HashSet<>(Arrays.asList("Broccoli", "Carrot", "Soy Sauce", "Garlic")),
                new HashSet<>(Arrays.asList("gluten-free", "low-calorie")),
                healthyCheck
        );

        abstractRecipe chickenAlfredo = new NonVegetarianRecipe(
                "Chicken Alfredo",
                40,
                new HashSet<>(Arrays.asList("Chicken", "Cream", "Pasta", "Garlic")),
                new HashSet<>(Arrays.asList("high-protein")),
                healthyCheck
        );

        // Edge: Recipe with no tags
        abstractRecipe plainRice = new vegetarianRecipe(
                "Plain Rice",
                15,
                new HashSet<>(Arrays.asList("Rice", "Salt")),
                new HashSet<>(),
                healthyCheck
        );

        // Edge: Recipe with overlapping name
        abstractRecipe vegStirFry2 = new vegetarianRecipe(
                "Vegetable Stir Fry 2",
                25,
                new HashSet<>(Arrays.asList("Broccoli", "Spinach", "Garlic")),
                new HashSet<>(Arrays.asList("high-fiber")),
                healthyCheck
        );

        // Edge: Recipe with empty ingredient list
        abstractRecipe mysteryDish = new NonVegetarianRecipe(
                "Mystery Dish",
                10,
                new HashSet<>(),
                new HashSet<>(Arrays.asList("experimental")),
                healthyCheck
        );

        // Add all recipes
        manager.addRecipe(vegStirFry);
        manager.addRecipe(chickenAlfredo);
        manager.addRecipe(plainRice);
        manager.addRecipe(vegStirFry2);
        manager.addRecipe(mysteryDish);

        // Print all recipes
        System.out.println("=== All Recipes ===");
        for (abstractRecipe recipe : manager.getRecipes()) {
            String type = recipe.isVegetarian() ? "Vegetarian" : "Non-Vegetarian";
            String healthiness = recipe.getHealthChecker().healthCheck(recipe.getIngredients());
            System.out.println(
                    "Recipe: " + recipe.getName() +
                            " | Type: " + type +
                            " | Prep Time: " + recipe.getPreparationTime() + " mins" +
                            " | Ingredients: " + recipe.getIngredients() +
                            " | Tags: " + recipe.getTags() +
                            " | Healthiness: " + healthiness
            );
        }
        System.out.println();

        // === Intensive Recommendations ===

        // Recommend based on common ingredients
        Set<String> commonIngredients = new HashSet<>(Arrays.asList("Chicken", "Pasta", "Garlic", "Broccoli"));
        printRecommendation(manager, commonIngredients, "Common ingredients");

        // Recommend with non-matching ingredients
        Set<String> unknownIngredients = new HashSet<>(Arrays.asList("Dragon Fruit", "Quinoa"));
        printRecommendation(manager, unknownIngredients, "Unknown ingredients");

        // Recommend with partial ingredients
        Set<String> partialIngredients = new HashSet<>(Arrays.asList("Spinach", "Garlic"));
        printRecommendation(manager, partialIngredients, "Partial ingredients");

        // Recommend when available ingredients is empty
        Set<String> emptyIngredients = new HashSet<>();
        printRecommendation(manager, emptyIngredients, "Empty available ingredients");

        // === Intensive Search ===

        // Search by existing tag
        Set<String> glutenFreeTag = new HashSet<>(Collections.singletonList("gluten-free"));
        printSearchResults(manager, glutenFreeTag, "gluten-free");

        // Search by non-existing tag
        Set<String> nonexistentTag = new HashSet<>(Collections.singletonList("super-healthy"));
        printSearchResults(manager, nonexistentTag, "super-healthy");

        // Search by tag used in edge recipe
        Set<String> experimentalTag = new HashSet<>(Collections.singletonList("experimental"));
        printSearchResults(manager, experimentalTag, "experimental");

        // Search with empty tag set
        Set<String> emptyTags = new HashSet<>();
        printSearchResults(manager, emptyTags, "empty tag set");

        // === Remove all recipes and test recommend/search on empty list ===
        manager.getRecipes().clear();

        System.out.println("\n=== After clearing all recipes ===");
        printRecommendation(manager, commonIngredients, "Common ingredients");
        printSearchResults(manager, glutenFreeTag, "gluten-free");
    }

    private static void printRecommendation(RecipeManager manager, Set<String> availableIngredients, String testCase) {
        abstractRecipe recommended = manager.recommendRecipe(availableIngredients);
        System.out.println("--- Recommendation Test: " + testCase + " ---");
        if (recommended != null) {
            System.out.println("Recommended: " + recommended.getName());
        } else {
            System.out.println("No recommendation found.");
        }
        System.out.println();
    }

    private static void printSearchResults(RecipeManager manager, Set<String> tags, String testCase) {
        Set<abstractRecipe> results = manager.searchRecipes(tags);
        System.out.println("--- Search Test: " + testCase + " ---");
        if (!results.isEmpty()) {
            for (abstractRecipe recipe : results) {
                System.out.println("- " + recipe.getName());
            }
        } else {
            System.out.println("No recipes found for tags: " + tags);
        }
        System.out.println();
    }
}
