package BuilderDesignPattern.MealBuilder.BetterCode;

public class KidsMeal extends Meal {
    public KidsMeal() {
        MealBuilder mealBuilder = new MealBuilder();
        mealBuilder.addMenuItem(MenuItem.MINI_BURGER);
        mealBuilder.addMenuItem(MenuItem.JUICE);
        mealBuilder.addMenuItem(MenuItem.ICE_CREAM);
        super(mealBuilder);
    }

    @Override
    public void displayMeal() {
        System.out.println("Meal Type : Kids Meal");
        super.displayMeal();
    }
}
