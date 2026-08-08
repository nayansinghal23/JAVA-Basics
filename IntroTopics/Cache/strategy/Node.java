package strategy;

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
}
