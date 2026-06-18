package IntroTopics.JumpGame;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class JumpGame4 {
    public int minJumps(int[] arr) {
            if(arr.length == 1) return 0;
    
            Map<Integer, List<Integer>> map = new HashMap<>();
            boolean[] visited = new boolean[arr.length];
            for(int i = 0; i < arr.length; i++) {
                visited[i] = false;
                List<Integer> list = map.getOrDefault(arr[i], new ArrayList<>());
                list.add(i);
                map.put(arr[i], list);
            }
            Queue<Integer> q = new LinkedList<>();
            q.offer(0);
            visited[0] = true;
            int steps = 0;
            while(q.size() > 0) {
                int size = q.size();
                while(size > 0) {
                    int idx = q.poll();
    
                    if(idx == arr.length - 1) return steps;
    
                    if(idx + 1 < arr.length && !visited[idx + 1]) {
                        visited[idx + 1] = true;
                        q.offer(idx + 1);
                    }
    
                    if(idx - 1 >= 0 && !visited[idx - 1]) {
                        visited[idx - 1] = true;
                        q.offer(idx - 1);
                    }
    
                    List<Integer> list = map.getOrDefault(arr[idx], new ArrayList<>());
                    for(int i : list) {
                        if(i != idx && !visited[i]) {
                            visited[i] = true;
                            q.offer(i);
                        }
                    }
                    map.remove(arr[idx]); // This is important to avoid TLE -> [7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7]
    
                    size--;
                }
                steps++;
            }
            return steps;
    }
}
