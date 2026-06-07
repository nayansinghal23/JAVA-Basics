package BuilderDesignPattern.MealBuilder.BetterCode;

public class Main {
    public void main() {
        PremiumMeal premiumMeal = new PremiumMeal();
        premiumMeal.displayMeal();
        System.out.println("------------------------------------");
        KidsMeal kidsMeal = new KidsMeal();
        kidsMeal.displayMeal();
        System.out.println("------------------------------------");
    }
}
