import java.util.*;

public class Recommendation {

    Map<abstractRecipe, Double> similarityScores;

    public Recommendation(){
        this.similarityScores = new HashMap<>() {};
    }

    abstractRecipe getRecommendedRecipe(Set<String> availableIngredients, Set<abstractRecipe> recipes){
        for (abstractRecipe recipe : recipes){
            similarityScores.put(recipe, recipe.similarityScore(availableIngredients));
        }

        abstractRecipe bestRecipe = null;
        double bestSimilarity = Double.MIN_VALUE;
        for (abstractRecipe recipe : similarityScores.keySet()){
            if  (similarityScores.get(recipe) > bestSimilarity){
                bestRecipe = recipe;
            }

        }
        return bestRecipe;
    }
}
