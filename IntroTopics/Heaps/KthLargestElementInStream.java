public class KthLargestElementInStream {
    // https://leetcode.com/problems/kth-largest-element-in-a-stream/
    private PriorityQueue<Integer> pq;
    private int k;

    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<Integer>();
        this.k = k;
        for(int i = 0; i < nums.length; i++) {
            if(pq.size() < k) pq.offer(nums[i]);
            else {
                if(pq.peek() < nums[i]) {
                    pq.poll();
                    pq.offer(nums[i]);
                }
            }
        }
    }
    
    public int add(int val) {
        if(pq.size() < k) pq.offer(val);
        else {
            if(pq.peek() < val) {
                pq.poll();
                pq.offer(val);
            }
        }
        return pq.peek();
    }
}
