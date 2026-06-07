package BuilderDesignPattern.MealBuilder.BetterCode;

public class PremiumMeal extends Meal {
    public PremiumMeal() {
        MealBuilder mealBuilder = new MealBuilder();
        mealBuilder.addMenuItem(MenuItem.LARGE_PIZZA);
        mealBuilder.addMenuItem(MenuItem.GARLIC_BREAD);
        mealBuilder.addMenuItem(MenuItem.COLD_DRINK);
        mealBuilder.addMenuItem(MenuItem.CHOCOLATE_LAVA_CAKE);
        super(mealBuilder);
    }

    @Override
    public void displayMeal() {
        System.out.println("Meal Type : Premium Meal");
        super.displayMeal();
    }
}