package BuilderDesignPattern.MealBuilder.ProblematicCode;

import java.util.List;

public interface Meal {
    void createMeal(List<MenuItem> menuItems);
    void calculateTotal(MenuItemRegistry menuItemRegistry);
}
