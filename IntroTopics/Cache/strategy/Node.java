package strategy;

import java.util.HashMap;
import java.util.Map;

class Node<K, V> {
    K key;
    V value;
    int freq = 1;
    Node<K, V> prev;
    Node<K, V> next;

    Node(K key, V value) {
        this.key = key;
        this.value = value;
    }

    static <K, V> Map<K, V> toValueMap(Map<K, Node<K, V>> nodes) {
        Map<K, V> result = new HashMap<>();
        for (Map.Entry<K, Node<K, V>> entry : nodes.entrySet()) {
            result.put(entry.getKey(), entry.getValue().value);
        }
        return result;
    }
}
