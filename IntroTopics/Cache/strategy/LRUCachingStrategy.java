package strategy;

import java.util.HashMap;
import java.util.Map;

import repository.Repository;

public class LRUCachingStrategy<K, V> implements CachingStrategy<K, V> {
    private final int capacity;
    private final Map<K, Node<K, V>> map = new HashMap<>();
    private final DoublyLinkedList<K, V> list = new DoublyLinkedList<>();

    private final Repository<K, V> repository;

    public LRUCachingStrategy(int capacity, Repository<K, V> repository) {
        if (capacity <= 0) throw new IllegalArgumentException("Capacity should be greater than 0.");

        this.repository = repository;
        this.capacity = capacity;

        loadFromRepository();
    }

    private void loadFromRepository() {
        int loaded = 0;
        for (Map.Entry<K, V> entry : repository.loadAll().entrySet()) {
            if (loaded == capacity) break;

            Node<K, V> node = new Node<>(entry.getKey(), entry.getValue());
            map.put(entry.getKey(), node);
            list.addFirst(node);
            loaded++;
        }
    }

    private void persist() {
        Map<K, V> snapshot = new HashMap<>();
        for (Map.Entry<K, Node<K, V>> entry : map.entrySet()) {
            snapshot.put(entry.getKey(), entry.getValue().value);
        }
        repository.saveAll(snapshot);
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
            persist();
            return;
        }

        if (map.size() == capacity) {
            Node<K, V> evicted = list.removeLast();
            map.remove(evicted.key);
        }

        Node<K, V> newNode = new Node<>(key, value);
        map.put(key, newNode);
        list.addFirst(newNode);
        persist();
    }
}
