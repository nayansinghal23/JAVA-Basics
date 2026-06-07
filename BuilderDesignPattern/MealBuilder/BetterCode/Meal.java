package BuilderDesignPattern.MealBuilder.BetterCode;

import java.util.List;

public class Meal {
    private List<MenuItem> menuItems;
    private int totalPrice;
    private final MenuItemRegistry menuItemRegistry;

    public Meal(MealBuilder mealBuilder) {
        this.menuItems = mealBuilder.getMenuItems();
        this.totalPrice = mealBuilder.getTotalPrice();
        this.menuItemRegistry = mealBuilder.getMenuItemRegistry();
    }

    public void displayMeal() {
        for(MenuItem menuItem : menuItems) {
            System.out.println(menuItem + " - " + menuItemRegistry.getPrice(menuItem));
        }
        System.out.println("Total Price : " + totalPrice);
    }
}
