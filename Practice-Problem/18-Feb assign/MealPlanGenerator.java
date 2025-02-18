import java.util.ArrayList;
import java.util.List;


interface MealPlan {
    String getMealType();
}


class VegetarianMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "Vegetarian Meal";
    }
}

class VeganMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "Vegan Meal";
    }
}

class KetoMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "Keto Meal";
    }
}

class HighProteinMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "High-Protein Meal";
    }
}


class Meal<T extends MealPlan> {
    private String name;
    private T mealType;

    public Meal(String name, T mealType) {
        this.name = name;
        this.mealType = mealType;
    }

    public void displayMeal() {
        System.out.println(name + " - " + mealType.getMealType());
    }
}


class MealPlanner {
    public static <T extends MealPlan> void generateMealPlan(T mealType, List<Meal<T>> meals) {
        System.out.println("\nPersonalized Meal Plan for: " + mealType.getMealType());
        for (Meal<T> meal : meals) {
            meal.displayMeal();
        }
    }
}


public class MealPlanGenerator {
    public static void main(String[] args) {
       
        VegetarianMeal vegetarian = new VegetarianMeal();
        VeganMeal vegan = new VeganMeal();
        KetoMeal keto = new KetoMeal();
        HighProteinMeal highProtein = new HighProteinMeal();

       
        List<Meal<VegetarianMeal>> vegMeals = new ArrayList<>();
        vegMeals.add(new Meal<>("Grilled Veggie Wrap", vegetarian));
        vegMeals.add(new Meal<>("Quinoa Salad", vegetarian));

        List<Meal<VeganMeal>> veganMeals = new ArrayList<>();
        veganMeals.add(new Meal<>("Tofu Stir-Fry", vegan));
        veganMeals.add(new Meal<>("Vegan Smoothie", vegan));

        List<Meal<KetoMeal>> ketoMeals = new ArrayList<>();
        ketoMeals.add(new Meal<>("Grilled Salmon", keto));
        ketoMeals.add(new Meal<>("Avocado Egg Bowl", keto));

        List<Meal<HighProteinMeal>> proteinMeals = new ArrayList<>();
        proteinMeals.add(new Meal<>("Chicken Breast with Brown Rice", highProtein));
        proteinMeals.add(new Meal<>("Protein Pancakes", highProtein));

      
        MealPlanner.generateMealPlan(vegetarian, vegMeals);
        MealPlanner.generateMealPlan(vegan, veganMeals);
        MealPlanner.generateMealPlan(keto, ketoMeals);
        MealPlanner.generateMealPlan(highProtein, proteinMeals);
    }
}
