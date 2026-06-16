package IntroTopics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrefixSum {}

// https://leetcode.com/problems/range-sum-query-immutable/
class NumArray {
    private int[] prefixSum;

    public NumArray(int[] nums) {
        this.prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for(int i = 1; i < nums.length; i++) prefixSum[i] = nums[i] + prefixSum[i - 1];
    }
    
    public int sumRange(int left, int right) {
        if(this.prefixSum.length == 0) return 0;
        else if(left == 0) return this.prefixSum[right];
        return this.prefixSum[right] - this.prefixSum[left - 1];
    }
}

// https://leetcode.com/problems/range-sum-query-2d-immutable/
class NumMatrix {
    private int[][] prefixSum;

    public NumMatrix(int[][] matrix) {
        if(matrix.length == 0) return;

        int rows = matrix.length, cols = matrix[0].length; 
        this.prefixSum = new int[rows][cols];
        this.prefixSum[0][0] = matrix[0][0];
        // Prefix sum for first row
        for(int i = 1; i < cols; i++) this.prefixSum[0][i] = this.prefixSum[0][i - 1] + matrix[0][i];
        // Prefix sum for first col
        for(int i = 1; i < rows; i++) this.prefixSum[i][0] = this.prefixSum[i - 1][0] + matrix[i][0];
        // Prefix sum for remaining cells
        for(int i = 1; i < rows; i++) {
            for(int j = 1; j < cols; j++) this.prefixSum[i][j] = matrix[i][j] + this.prefixSum[i - 1][j] + this.prefixSum[i][j - 1] - this.prefixSum[i - 1][j - 1];
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int total = prefixSum[row2][col2];
        int top = (row1 > 0) ? prefixSum[row1 - 1][col2] : 0;
        int left = (col1 > 0) ? prefixSum[row2][col1 - 1] : 0;
        int overlap = (row1 > 0 && col1 > 0)
                        ? prefixSum[row1 - 1][col1 - 1]
                        : 0;
    
        return total - top - left + overlap;
    }
}

// https://leetcode.com/problems/subarray-sum-equals-k/
class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0, count = 0;
        map.put(0, 1);
        for(int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            if(map.containsKey(prefixSum - k)) count += map.get(prefixSum - k);
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}

// https://www.geeksforgeeks.org/problems/count-subarrays-with-equal-number-of-1s-and-0s-1587115620/1
/**
 * Convert all 0s to -1s and find subarrays with sum 0. We convert all 0s to -1s so that we have a fixed starting point for prefix sum.
 * If we go with sum = 2 * size of subarray, then its not guaranteed that subarray will start from index 0.
 */

// https://leetcode.com/problems/sum-of-distances/
class SumOfDistances {
    public long[] distance(int[] nums) {
        long[] ans = new long[nums.length];
    
        Map<Integer, List<Long>> prefixSumMap = new HashMap<>();
        Map<Integer, Integer> freq = new HashMap<>();
    
        // Build prefix sums of occurrence indices for each value
        for (int i = 0; i < nums.length; i++) {
            List<Long> list = prefixSumMap.get(nums[i]);
    
            long last = 0;
            if (list == null) {
                list = new ArrayList<>();
            } else {
                last = list.get(list.size() - 1);
            }
    
            list.add(last + i);
            prefixSumMap.put(nums[i], list);
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }
    
        Map<Integer, Integer> count = new HashMap<>();
    
        for (int i = 0; i < nums.length; i++) {
            List<Long> prefixSum = prefixSumMap.get(nums[i]);
    
            int leftCount = count.getOrDefault(nums[i], 0);
            int rightCount = freq.get(nums[i]) - leftCount - 1;
    
            // Sum of indices on the left
            long leftSum = leftCount == 0 ? 0 : prefixSum.get(leftCount - 1);
    
            // Left contribution
            long left = (long) leftCount * i - leftSum;
    
            // Sum of indices on the right
            long totalSum = prefixSum.get(prefixSum.size() - 1);
            long rightSum = totalSum - prefixSum.get(leftCount);
    
            // Right contribution
            long right = rightSum - (long) rightCount * i;
    
            ans[i] = left + right;
    
            count.put(nums[i], leftCount + 1);
        }
    
        return ans;
    }
}