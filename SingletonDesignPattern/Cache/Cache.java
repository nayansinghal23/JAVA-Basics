package SingletonDesignPattern.Cache;

import java.util.HashMap;
import java.util.Map;

public class Cache {
    private static Cache cache;
    private final Map<String, String> map;

    private Cache() {
        map = new HashMap<>();
        System.out.println("Cache constructor initilized");
    }

    public static Cache getInstance() {
        if(cache == null) cache = new Cache();
        return cache;
    }

    public void put(String key, String value) {
        map.put(key, value);
    }

    public String get(String key) {
        return map.getOrDefault(key, null);
    }
}
