package strategy;

public interface CachingStrategy {
    int get(int key);
    void put(int key, int value);
}
