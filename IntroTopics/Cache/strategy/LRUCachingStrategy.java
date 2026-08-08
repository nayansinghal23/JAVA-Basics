package strategy;

import java.util.HashMap;
import java.util.Map;

public class LRUCachingStrategy implements CachingStrategy {
    private int capacity;
    private DLL head;
    private DLL tail;
    private Map<Integer, DLL> map;

    public LRUCachingStrategy(int capacity) {
        if(capacity <= 0) throw new IllegalArgumentException("Capacity should be greater than 0.");

        this.capacity = capacity;
        head = new DLL(-1, -1);
        tail = new DLL(-1, -1);
        map = new HashMap<>();

        head.next = tail;
        tail.prev = head;
    }

    private void deleteFromDLL(DLL node) {
        DLL back = node.prev, front = node.next;
        node.prev = node.next = null;
        back.next = front;
        front.prev = back;
    }

    private void insertAfterHead(DLL node) {
        DLL front = head.next;
        node.next = front;
        node.prev = head;
        head.next = node;
        front.prev = node;
    }

    @Override
    public int get(int key) {
        DLL node = map.get(key);
        if(node == null) return -1;
        
        deleteFromDLL(node);
        insertAfterHead(node);
        return node.value;
    }
    
    @Override
    public void put(int key, int value) {
        DLL node = map.get(key);
        if(node != null) {
            node.value = value; // update the existing key's value
            deleteFromDLL(node); // delete its current position
            insertAfterHead(node); // append it in front of head
            return;
        }
        DLL newNode = new DLL(key, value);
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

class DLL {
    public int key;
    public int value;
    public DLL prev;
    public DLL next;

    public DLL(int key, int value) {
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}