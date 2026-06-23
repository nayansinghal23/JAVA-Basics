package IntroTopics.Heaps;

import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {
    // This question is coded just to be familiar with the syntax of the Priority Queue and the HashMap.
    public String frequencySort(String s) {
        Map<Character, Integer> freq = new HashMap<>();

        for(char ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Character> maxHeap =
            new PriorityQueue<>((a, b) -> freq.get(b) - freq.get(a));

        for(char ch : freq.keySet()) {
            maxHeap.offer(ch);
        }

        StringBuilder sb = new StringBuilder();

        while(!maxHeap.isEmpty()) {
            char ch = maxHeap.poll();

            for(int i = 0; i < freq.get(ch); i++) {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}
