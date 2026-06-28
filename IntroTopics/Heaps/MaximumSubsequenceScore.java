public class MaximumSubsequenceScore {
    // https://leetcode.com/problems/maximum-subsequence-score/description/

    /**
     * Bigger the multiplier, higher the score. Hence, we will sort nums2 in descending order along with nums1[] to maintain the order.
     */

    public long maxScore(int[] nums1, int[] nums2, int k) {
        int[][] arr = new int[nums1.length][2];
        for(int i = 0; i < nums1.length; i++) {
            arr[i][0] = nums1[i];
            arr[i][1] = nums2[i];
        }
        Arrays.sort(arr, (a, b) -> Integer.compare(b[1], a[1])); // DECREASING ORDER to track the biggest multiplier
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // Min heap to track the smallest nums1 value
        long sum = 0, ans = 0;
        int mini = Integer.MAX_VALUE;
        for(int i = 0; i < k; i++) {
            pq.offer(arr[i][0]);
            sum += arr[i][0];
            mini = Math.min(mini, arr[i][1]);
        }
        ans = Math.max(ans, (long) sum * mini);
        for(int i = k; i < arr.length; i++) {
            mini = Math.min(mini, arr[i][1]);
            sum += arr[i][0] - pq.poll();
            pq.offer(arr[i][0]);
            ans = Math.max(ans, (long) sum * mini);
        }
        return ans;
    }
}
