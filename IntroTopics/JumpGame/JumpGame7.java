package IntroTopics.JumpGame;

import java.util.LinkedList;
import java.util.Queue;

public class JumpGame7 {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        if(s.charAt(n - 1) == '1') return false;
        
        int farthestScanned = 1;
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++) visited[i] = s.charAt(i) == '1' ? true : false;
        Queue<Integer> q = new LinkedList<>();
        visited[0] = true;
        q.offer(0);
        while(q.size() > 0) {
            int size = q.size();
            while(size-- > 0) {
                int i = q.poll();
                if(i == n - 1) return true;

                int start = Math.max(i + minJump, farthestScanned), end = Math.min(i + maxJump, s.length() - 1);
                for(int idx = start; idx <= end; idx++) {
                    if(s.charAt(idx) == '0' && !visited[idx]) {
                        q.offer(idx);
                        visited[idx] = true;
                    }
                }
                farthestScanned = Math.max(farthestScanned, end + 1); // prevents an index from being checked multiple times.
            }
        }
        return false;
    }
}

/*
Without visited → MLE.
Without farthestScanned → TLE.
*/