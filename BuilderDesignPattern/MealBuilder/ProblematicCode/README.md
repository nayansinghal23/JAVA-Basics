### Problems with this code ->

1. Main is constructing every meal manually. This defeats the purpose of `createVegMeal()`

```java
    List<MenuItem> vegMeal = new ArrayList<>();
    vegMeal.add(...);
    vegMeal.add(...);
    vegMeal.add(...);
```

1. Massive code duplication in `calculateTotal()` - violeting DRY
2. `MealImpl` is not open for extension, image `FamilyMeal` comes into pitcure tomorrow, we have to modify `MealImpl` class.
3. `VegMeal`, `KidsMeal` & `PremiumMeal` directly depend on `MenuItemRegistry` instead of abstraction.

