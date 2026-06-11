package SingletonDesignPattern.Cache;

public class Main {
    public static void main() {
        Cache cache1 = Cache.getInstance();

        cache1.put("USER_1", "Nayan");

        Cache cache2 = Cache.getInstance();

        System.out.println(cache2.get("USER_1"));
    }
}
