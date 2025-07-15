import java.util.Set;

public class HealthyCheck {
    private final Set<String> goodIngredients;
    public HealthyCheck(Set<String> goodIngredients, Set<String> badIngredients) {
        this.goodIngredients = goodIngredients;
    }

    public String healthCheck(Set<String> ingredients){
        int ingredientsLength = ingredients.size();
        int goodIngredient = 0;
        int badIngredient = 0;

        for (String ingredient : ingredients) {
            if (goodIngredients.contains(ingredient)){
                goodIngredient++;
            }
            else{
                badIngredient++;
            }
        }

        if (goodIngredient == 0 || goodIngredient < badIngredient){
            return "Unhealthy";
        }
        else if ( badIngredient == 0 || goodIngredient > badIngredient){
            return "Healthy";
        }
        else{
            return "Moderately Healthy";
        }


    }
}
