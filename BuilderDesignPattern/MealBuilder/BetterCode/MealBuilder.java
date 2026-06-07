package BuilderDesignPattern.MealBuilder.BetterCode;

import java.util.ArrayList;
import java.util.List;

public class MealBuilder {
    private List<MenuItem> menuItems;
    private int totalPrice;
    private final MenuItemRegistry menuItemRegistry;

    public MealBuilder() {
        this.menuItems = new ArrayList<>();
        this.totalPrice = 0;
        this.menuItemRegistry = new MenuItemRegistry();
    }

    public MealBuilder addMenuItem(MenuItem menuItem) {
        this.menuItems.add(menuItem);
        this.totalPrice += menuItemRegistry.getPrice(menuItem);
        return this;
    }

    public int getTotalPrice() {
        return this.totalPrice;
    }

    public List<MenuItem> getMenuItems() {
        return this.menuItems;
    }

    public MenuItemRegistry getMenuItemRegistry() {
        return this.menuItemRegistry;
    }

    public Meal build() {
        return new Meal(this);
    }
}
