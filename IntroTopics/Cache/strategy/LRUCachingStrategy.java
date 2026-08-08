package strategy;

import java.util.HashMap;
import java.util.Map;

class LRUNode {
    public int key;
    public int value;
    public LRUNode prev;
    public LRUNode next;

    public LRUNode(int key, int value) {
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}
public class LRUCachingStrategy implements CachingStrategy {
    private int capacity;
    private LRUNode head;
    private LRUNode tail;
    private Map<Integer, LRUNode> map;

    public LRUCachingStrategy(int capacity) {
        if(capacity <= 0) throw new IllegalArgumentException("Capacity should be greater than 0.");

        this.capacity = capacity;
        head = new LRUNode(-1, -1);
        tail = new LRUNode(-1, -1);
        map = new HashMap<>();

        head.next = tail;
        tail.prev = head;
    }

    private void deleteFromDLL(LRUNode node) {
        LRUNode back = node.prev, front = node.next;
        node.prev = node.next = null;
        back.next = front;
        front.prev = back;
    }

    private void insertAfterHead(LRUNode node) {
        LRUNode front = head.next;
        node.next = front;
        node.prev = head;
        head.next = node;
        front.prev = node;
    }

    @Override
    public int get(int key) {
        LRUNode node = map.get(key);
        if(node == null) return -1;
        
        deleteFromDLL(node);
        insertAfterHead(node);
        return node.value;
    }
    
    @Override
    public void put(int key, int value) {
        LRUNode node = map.get(key);
        if(node != null) {
            node.value = value; // update the existing key's value
            deleteFromDLL(node); // delete its current position
            insertAfterHead(node); // append it in front of head
            return;
        }
        LRUNode newNode = new LRUNode(key, value);
        // Capacity is full
        if(capacity == map.size()) {
            // Evict in LRU fashion
            map.remove(tail.prev.key);
            deleteFromDLL(tail.prev);
        }
        map.put(key, newNode);
        insertAfterHead(newNode);
    }
}