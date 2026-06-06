package BuilderDesignPattern.MealBuilder.ProblematicCode;

import java.util.List;

public class PremiumMeal implements Meal {
    private List<MenuItem> menuItems;

    @Override
    public void createMeal(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public void calculateTotal(MenuItemRegistry menuItemRegistry) {
        int total = 0;
        System.out.println("Meal Type: Premium Meal");
        System.out.println();
        System.out.println("Items : ");
        for(MenuItem menuItem : menuItems) {
            int price = menuItemRegistry.getPrice(menuItem);
            System.out.println(menuItem + " - " + price);
            total += price;
        }
        System.out.println("Total Price: " + total);
    }
}
