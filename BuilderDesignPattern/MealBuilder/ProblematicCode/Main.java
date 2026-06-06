package BuilderDesignPattern.MealBuilder.ProblematicCode;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public void main() {
        MealImpl meal = new MealImpl();

        // Kids meal
        List<MenuItem> kidsMeal = new ArrayList<>();
        kidsMeal.add(MenuItem.MINI_BURGER);
        kidsMeal.add(MenuItem.JUICE);
        kidsMeal.add(MenuItem.ICE_CREAM);
        meal.createKidsMeal(kidsMeal);
        System.out.println("------------------------------------");
        
        // Premium meal
        List<MenuItem> premiumMeal = new ArrayList<>();
        premiumMeal.add(MenuItem.LARGE_PIZZA);
        premiumMeal.add(MenuItem.GARLIC_BREAD);
        premiumMeal.add(MenuItem.COLD_DRINK);
        premiumMeal.add(MenuItem.CHOCOLATE_LAVA_CAKE);
        meal.createPremiumMeal(premiumMeal);
        System.out.println("------------------------------------");
        
        // Veg meal
        List<MenuItem> vegMeal = new ArrayList<>();
        vegMeal.add(MenuItem.VEG_BURGER);
        vegMeal.add(MenuItem.FRIES);
        vegMeal.add(MenuItem.COKE);
        meal.createVegMeal(vegMeal);
        System.out.println("------------------------------------");
    }
}
