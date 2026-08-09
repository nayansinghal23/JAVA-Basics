package strategy;

import java.util.HashMap;
import java.util.Map;

public class LFUCachingStrategy<K, V> implements CachingStrategy<K, V>, Snapshotable<K, V> {
    private final Map<K, Node<K, V>> keyMap = new HashMap<>();
    private final Map<Integer, DoublyLinkedList<K, V>> freqMap = new HashMap<>();

    private final int capacity;
    private int minFreq;

    public LFUCachingStrategy(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("Capacity should be greater than 0.");
        this.capacity = capacity;
    }

    @Override
    public V get(K key) {
        if (!keyMap.containsKey(key)) return null;

        Node<K, V> node = keyMap.get(key);
        update(node);
        return node.value;
    }

    @Override
    public void put(K key, V value) {
        if (capacity == 0) return;

        if (keyMap.containsKey(key)) {
            Node<K, V> node = keyMap.get(key);
            node.value = value;
            update(node);
            return;
        }

        if (keyMap.size() == capacity) {
            DoublyLinkedList<K, V> list = freqMap.get(minFreq);
            Node<K, V> removed = list.removeLast();
            keyMap.remove(removed.key);
        }

        Node<K, V> node = new Node<>(key, value);
        keyMap.put(key, node);
        minFreq = 1;
        freqMap.putIfAbsent(1, new DoublyLinkedList<>());
        freqMap.get(1).addFirst(node);
    }

    private void update(Node<K, V> node) {
        int freq = node.freq;
        DoublyLinkedList<K, V> list = freqMap.get(freq);

        list.remove(node);

        if (freq == minFreq && list.size() == 0) {
            minFreq++;
        }

        node.freq++;
        freqMap.putIfAbsent(node.freq, new DoublyLinkedList<>());
        freqMap.get(node.freq).addFirst(node);
    }

    @Override
    public Map<K, V> snapshot() {
        return Node.toValueMap(keyMap);
    }
}
