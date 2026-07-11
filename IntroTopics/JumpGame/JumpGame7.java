package IntroTopics.JumpGame;

import java.util.LinkedList;
import java.util.Queue;

public class JumpGame7 {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        // If the last character is '1', it's impossible to land on it.
        if (s.charAt(n - 1) == '1') return false;
        
        // Tracks the first index that has NOT been scanned yet
        int farthestScanned = 1;
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        
        while (!q.isEmpty()) {
            int i = q.poll();
            
            // If we reached the end, we are done!
            if (i == n - 1) return true;
            
            // Start scanning from either (i + minJump) OR where we last left off
            int start = Math.max(i + minJump, farthestScanned);
            int end = Math.min(i + maxJump, n - 1);
            
            for (int idx = start; idx <= end; idx++) {
                if (s.charAt(idx) == '0') {
                    q.offer(idx);
                }
            }
            
            // Crucial: Update farthestScanned so the next elements in the queue 
            // completely skip this window, preventing duplicate checks.
            farthestScanned = Math.max(farthestScanned, end + 1);
        }
        
        return false;
    }
}
