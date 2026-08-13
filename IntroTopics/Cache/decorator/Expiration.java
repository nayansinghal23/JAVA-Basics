package decorator;

public interface Expiration<K, V> {
    void expire(K key);
}
