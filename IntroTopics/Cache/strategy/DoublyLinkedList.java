package strategy;

class DoublyLinkedList<K, V> {
    private final Node<K, V> head = new Node<>(null, null);
    private final Node<K, V> tail = new Node<>(null, null);
    private int size;

    DoublyLinkedList() {
        head.next = tail;
        tail.prev = head;
    }

    void addFirst(Node<K, V> node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        size++;
    }

    void remove(Node<K, V> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
        size--;
    }

    Node<K, V> removeLast() {
        if (size == 0) return null;
        Node<K, V> node = tail.prev;
        remove(node);
        return node;
    }

    int size() {
        return size;
    }
}
