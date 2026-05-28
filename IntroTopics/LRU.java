package IntroTopics;

import java.util.HashMap;
import java.util.Map;

public class LRU {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        cache.put(2, 6);
        System.out.println(cache.get(1)); // -1

        cache.put(1, 5);
        cache.put(1, 2);

        System.out.println(cache.get(1)); // 2
        System.out.println(cache.get(2)); // 6
    }
}

class LRUCache {
    private final int capacity;
    private final DLLNode head;
    private final DLLNode tail;
    private final Map<Integer, DLLNode> map;
    private int count;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new DLLNode(-1, -1);
        this.tail = new DLLNode(-1, -1);

        // Connect dummy nodes
        head.setNext(tail);
        tail.setPrev(head);

        this.count = 0;
    }

    public int get(int key) {
        DLLNode node = map.get(key);

        if(node == null) return -1;
        moveToFront(node);
        return node.getValue();
    }

    public void put(int key, int value) {

        // CASE 1: Key already exists
        DLLNode existingNode = map.get(key);

        if(existingNode != null) {
            existingNode.setValue(value);
            moveToFront(existingNode);
            return;
        }

        // CASE 2: Cache full -> remove LRU
        if(count == capacity) {
            DLLNode lru = tail.getPrev();
            removeNode(lru);
            map.remove(lru.getKey());
            count--;
        }

        // Insert new node
        DLLNode newNode = new DLLNode(key, value);
        insertAfterHead(newNode);
        map.put(key, newNode);
        count++;
    }

    private void moveToFront(DLLNode node) {
        removeNode(node);
        insertAfterHead(node);
    }

    private void removeNode(DLLNode node) {
        DLLNode prev = node.getPrev();
        DLLNode next = node.getNext();

        prev.setNext(next);
        next.setPrev(prev);
    }

    private void insertAfterHead(DLLNode node) {
        DLLNode headNext = head.getNext();

        head.setNext(node);
        node.setPrev(head);

        node.setNext(headNext);
        headNext.setPrev(node);
    }
}

class DLLNode {
    private int key;
    private int value;
    private DLLNode prev;
    private DLLNode next;

    public DLLNode(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }

    public DLLNode getPrev() {
        return prev;
    }

    public DLLNode getNext() {
        return next;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setPrev(DLLNode prev) {
        this.prev = prev;
    }

    public void setNext(DLLNode next) {
        this.next = next;
    }
}