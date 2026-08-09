package strategy;

import java.util.HashMap;
import java.util.Map;

public class LRUCachingStrategy<K, V> implements CachingStrategy<K, V>, Snapshotable<K, V> {
    private final int capacity;
    private final Map<K, Node<K, V>> map = new HashMap<>();
    private final DoublyLinkedList<K, V> list = new DoublyLinkedList<>();

    public LRUCachingStrategy(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("Capacity should be greater than 0.");
        this.capacity = capacity;
    }

    @Override
    public V get(K key) {
        Node<K, V> node = map.get(key);
        if (node == null) return null;

        list.remove(node);
        list.addFirst(node);
        return node.value;
    }

    @Override
    public void put(K key, V value) {
        Node<K, V> node = map.get(key);
        if (node != null) {
            node.value = value;
            list.remove(node);
            list.addFirst(node);
            return;
        }

        if (map.size() == capacity) {
            Node<K, V> evicted = list.removeLast();
            map.remove(evicted.key);
        }

        Node<K, V> newNode = new Node<>(key, value);
        map.put(key, newNode);
        list.addFirst(newNode);
    }

    @Override
    public Map<K, V> snapshot() {
        return Node.toValueMap(map);
    }
}
