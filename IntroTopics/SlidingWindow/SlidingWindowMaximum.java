public class SlidingWindowMaximum {
    // https://leetcode.com/problems/sliding-window-maximum/description/

    public int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length - k + 1;
        int[] ans = new int[length];
        Deque<Integer> q = new ArrayDeque<>(); // stores indices
        for(int i = 0; i < nums.length; i++) {
            int windowStart = i - k + 1;
            if(q.peekFirst() != null && q.peekFirst() < windowStart) q.pollFirst(); // maintaining the window of k
            while(q.peekLast() != null && nums[q.peekLast()] <= nums[i]) q.pollLast(); // maintaining a decreasingly monotonic dequeue
            q.offerLast(i);
            if(windowStart >= 0) ans[windowStart] = nums[q.peekFirst()];
        }
        return ans;
    }
}
