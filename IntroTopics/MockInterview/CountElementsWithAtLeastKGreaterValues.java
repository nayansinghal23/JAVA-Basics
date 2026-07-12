public class CountElementsWithAtLeastKGreaterValues {
    // https://leetcode.com/problems/count-elements-with-at-least-k-greater-values/description/

    private int nextGreaterElement(int[] nums, int target, int start) {
        int end = nums.length - 1, ans = -1;
        while(end >= start) {
            int mid = (start + end) / 2;
            if(nums[mid] > target) {
                ans = mid;
                end = mid - 1;
            }
            else start = mid + 1;
        }
        return ans;
    }

    public int countElements(int[] nums, int k) {
        if(k == 0) return nums.length;
        Arrays.sort(nums);
        int ans = 0;
        for(int i = nums.length - 2; i >= 0; i--) {
            int index = nextGreaterElement(nums, nums[i], i + 1);
            if(index != -1 && nums.length - index >= k) ans++;
        }
        return ans;
    }    
}
