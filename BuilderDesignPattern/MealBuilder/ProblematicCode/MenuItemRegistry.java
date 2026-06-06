package BuilderDesignPattern.MealBuilder.ProblematicCode;

import java.util.HashMap;
import java.util.Map;

public class MenuItemRegistry {
    private final Map<MenuItem, Integer> menuItemRegistry;

    public MenuItemRegistry() {
        this.menuItemRegistry = new HashMap<>();
        this.seed();
    }

    private void seed() {
        menuItemRegistry.put(MenuItem.VEG_BURGER, 120);
        menuItemRegistry.put(MenuItem.MINI_BURGER, 80);
        menuItemRegistry.put(MenuItem.LARGE_PIZZA, 350);
        menuItemRegistry.put(MenuItem.FRIES, 60);
        menuItemRegistry.put(MenuItem.GARLIC_BREAD, 120);
        menuItemRegistry.put(MenuItem.COKE, 40);
        menuItemRegistry.put(MenuItem.COLD_DRINK, 50);
        menuItemRegistry.put(MenuItem.JUICE, 50);
        menuItemRegistry.put(MenuItem.ICE_CREAM, 70);
        menuItemRegistry.put(MenuItem.CHOCOLATE_LAVA_CAKE, 150);
    }

    public int getPrice(MenuItem menuItem) {
        return menuItemRegistry.get(menuItem);
    }
}
