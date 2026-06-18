package IntroTopics.JumpGame;

public class JumpGame2 {
    // Approach 1: Recursion + Memoization
    /*
    private int minJumps(int[] nums, int idx, int[] dp) {
        if(idx >= nums.length - 1) return 0;
        if(dp[idx] != -1) return dp[idx];

        int jumps = Integer.MAX_VALUE;
        for(int i = idx + 1; i <= idx + nums[idx] && i < nums.length; i++) {
            int next = minJumps(nums, i, dp);
            if(next != Integer.MAX_VALUE) {
                jumps = Math.min(jumps, next + 1);
            }
        }
        return dp[idx] = jumps;
    }

    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        for(int i = 0; i < nums.length; i++) dp[i] = -1;
        return minJumps(nums, 0, dp);
    }
    */

    // Approach 2: Tabulation
    /*
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        dp[nums.length - 1] = 0;
        for(int i = nums.length - 2; i >= 0; i--) {
            int jumps = Integer.MAX_VALUE;
            for(int j = i + 1; j <= i + nums[i] && j < nums.length; j++) {
                int next = dp[j];
                if(next != Integer.MAX_VALUE) {
                    jumps = Math.min(jumps, next + 1);
                }
            }
            dp[i] = jumps;
        }
        return dp[0];
    }
    */

    // Approach 3: Space Optimization
    public int jump(int[] nums) {
        int n = nums.length, jumps = 0, start = 0, end = 0;
        while(end < n - 1) {
            int farthest = 0;
            for(int i = start; i <= end; i++) farthest = Math.max(farthest, i + nums[i]);
            start = end + 1;
            end = farthest;
            jumps++;
        }
        return jumps;
    }
}
