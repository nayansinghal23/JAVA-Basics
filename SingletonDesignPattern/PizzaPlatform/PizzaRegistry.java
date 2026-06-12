package SingletonDesignPattern.PizzaPlatform;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PizzaRegistry {
    private final Map<PizzaType, Integer> map;
    private final List<PizzaType> list;
    private static PizzaRegistry instance;

    private PizzaRegistry() {
        System.out.println("Pizza registry initalized");
        map = new HashMap<>();
        list = new ArrayList<>();
        seed();
    }

    public static PizzaRegistry getInstance() {
        if(instance == null) instance = new PizzaRegistry();
        return instance;
    }

    private void seed() {
        list.add(PizzaType.VEG);
        list.add(PizzaType.FARMHOUSE);
        list.add(PizzaType.CHEESE_BURST);
    }

    public void setPizzaTypeCount(PizzaType type) {
        map.put(type, getPizzaTypeCount(type) + 1);
    }

    public int getPizzaTypeCount(PizzaType type) {
        return map.getOrDefault(type, 0);
    }

    public List<PizzaType> getList() {
        return list;
    }
}
