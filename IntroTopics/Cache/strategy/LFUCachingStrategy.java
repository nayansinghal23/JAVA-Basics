package strategy;

import java.util.HashMap;
import java.util.Map;

public class LFUCachingStrategy implements CachingStrategy {
    Map<Integer, LFUNode> keyMap = new HashMap<>();
    Map<Integer, LFUDLL> freqMap = new HashMap<>();

    private final int capacity;
    private int minFreq;

    public LFUCachingStrategy(int capacity) {
        if(capacity <= 0) throw new IllegalArgumentException("Capacity should be greater than 0.");

        this.capacity = capacity;
    }

    @Override
    public int get(int key) {
        if(!keyMap.containsKey(key)) return -1;
        
        LFUNode node = keyMap.get(key);
        update(node);
        return node.value;
    }
    
    @Override
    public void put(int key, int value) {
        if(capacity == 0) return;

        if(keyMap.containsKey(key)) {
            LFUNode node = keyMap.get(key);
            node.value = value;
            update(node);
            return;
        }

        if(keyMap.size() == capacity) {
            LFUDLL list = freqMap.get(minFreq);
            LFUNode removed = list.removeLast();
            keyMap.remove(removed.key);
        }

        LFUNode node = new LFUNode(key,value);
        keyMap.put(key,node);
        minFreq = 1;
        freqMap.putIfAbsent(1, new LFUDLL());
        freqMap.get(1).add(node);
    }

    private void update(LFUNode node) {
        int freq = node.freq;
        LFUDLL list = freqMap.get(freq);

        list.remove(node);

        if(freq == minFreq && list.size == 0) {
            minFreq++;
        }

        node.freq++;
        freqMap.putIfAbsent(node.freq, new LFUDLL());
        freqMap.get(node.freq).add(node);
    }
}

class LFUNode {
    int key, value, freq;
    LFUNode prev, next;

    LFUNode(int k, int v) {
        key = k;
        value = v;
        freq = 1;
    }
}

class LFUDLL {
    LFUNode head = new LFUNode(0,0);
    LFUNode tail = new LFUNode(0,0);
    int size = 0;

    LFUDLL() {
        head.next = tail;
        tail.prev = head;
    }

    void add(LFUNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        size++;
    }

    void remove(LFUNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    LFUNode removeLast() {
        if(size > 0) {
            LFUNode node = tail.prev;
            remove(node);
            return node;
        }
        return null;
    }
}