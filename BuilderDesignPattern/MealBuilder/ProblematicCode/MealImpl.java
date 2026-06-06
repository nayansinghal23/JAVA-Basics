package BuilderDesignPattern.MealBuilder.ProblematicCode;

import java.util.List;

public class MealImpl {
    private final MenuItemRegistry menuItemRegistry;

    public MealImpl() {
        menuItemRegistry = new MenuItemRegistry();
    }
    
    public void createVegMeal(List<MenuItem> menuItems) {
        VegMeal vegMeal = new VegMeal();
        vegMeal.createMeal(menuItems);
        vegMeal.calculateTotal(menuItemRegistry);
    }

    public void createKidsMeal(List<MenuItem> menuItems) {
        KidsMeal kidsMeal = new KidsMeal();
        kidsMeal.createMeal(menuItems);
        kidsMeal.calculateTotal(menuItemRegistry);
    }
    
    public void createPremiumMeal(List<MenuItem> menuItems) {
        PremiumMeal premiumMeal = new PremiumMeal();
        premiumMeal.createMeal(menuItems);
        premiumMeal.calculateTotal(menuItemRegistry);
    }
}
