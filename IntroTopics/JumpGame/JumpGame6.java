package IntroTopics.JumpGame;

import java.util.PriorityQueue;

public class JumpGame6 {
    // Approach 1: Recursion + Memoization
    /*
    private int maxScore(int[] nums, int[] dp, int k, int i) {
        if(i == nums.length - 1) return nums[i];
        if(dp[i] != -1) return dp[i];

        int score = Integer.MIN_VALUE;
        for(int idx = i + 1; idx <= Math.min(nums.length - 1, i + k); idx++) score = Math.max(score, maxScore(nums, dp, k, idx));
        return dp[i] = score + nums[i];
    }
    public int maxResult(int[] nums, int k) {
        int[] dp = new int[nums.length];
        for(int i = 0; i < nums.length; i++) dp[i] = -1;
        dp[nums.length - 1] = nums[nums.length - 1];
        return maxScore(nums, dp, k, 0);
    }
    */

    // Approach 2: Tabulation
    /*
    public int maxResult(int[] nums, int k) {
        if(nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        for(int i = 0; i < nums.length; i++) dp[i] = Integer.MIN_VALUE;
        dp[nums.length - 1] = nums[nums.length - 1];
        for(int i = nums.length - 2; i >= 0; i--) {
            int score = Integer.MIN_VALUE;
            for(int idx = i + 1; idx <= Math.min(nums.length - 1, i + k); idx++) score = Math.max(score, dp[idx]);
            dp[i] = score + nums[i];
        }
        return dp[0];
    }
    */

    // Approach 3: Priority Queue
    public int maxResult(int[] nums, int k) {
        int n = nums.length;

        int[] dp = new int[n];
        dp[n - 1] = nums[n - 1];

        // Max heap based on dp value
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> dp[b] - dp[a]
        );

        pq.offer(n - 1);

        for (int i = n - 2; i >= 0; i--) {

            // Remove unreachable indices
            while (pq.peek() > i + k) {
                pq.poll();
            }

            dp[i] = nums[i] + dp[pq.peek()];

            pq.offer(i);
        }

        return dp[0];
    }
}
