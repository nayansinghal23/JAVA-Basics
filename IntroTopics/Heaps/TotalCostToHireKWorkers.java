public class TotalCostToHireKWorkers {
    //  https://leetcode.com/problems/total-cost-to-hire-k-workers/description/

    class Solution {
        public long totalCost(int[] costs, int k, int candidates) {
            PriorityQueue<int[]> left = new PriorityQueue<>((a, b) -> {
                if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
                return Integer.compare(a[1], b[1]);
            });
    
            PriorityQueue<int[]> right = new PriorityQueue<>((a, b) -> {
                if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
                return Integer.compare(a[1], b[1]);
            });
    
            int n = costs.length;
            long cost = 0;
    
            if (2 * candidates >= n) {
                for (int i = 0; i < n; i++) {
                    left.offer(new int[]{costs[i], i});
                }
    
                while (k-- > 0) {
                    cost += left.poll()[0];
                }
    
                return cost;
            }
    
            int start = 0, end = n - 1;
    
            while (start < candidates) {
                left.offer(new int[]{costs[start], start});
                start++;
            }
    
            while (end >= n - candidates) {
                right.offer(new int[]{costs[end], end});
                end--;
            }
    
            while (k > 0 && !left.isEmpty() && !right.isEmpty()) {
                int[] item1 = left.peek();
                int[] item2 = right.peek();
    
                int c1 = item1[0], c2 = item2[0];
                int i1 = item1[1], i2 = item2[1];
    
                if (c1 < c2 || (c1 == c2 && i1 < i2)) {
                    cost += c1;
                    left.poll();
    
                    if (start <= end) {
                        left.offer(new int[]{costs[start], start});
                        start++;
                    }
    
                } else {
                    cost += c2;
                    right.poll();
    
                    if (start <= end) {
                        right.offer(new int[]{costs[end], end});
                        end--;
                    }
                }
    
                k--;
            }
    
            while (!right.isEmpty()) {
                left.offer(right.poll());
            }
    
            while (k-- > 0 && !left.isEmpty()) {
                cost += left.poll()[0];
            }
    
            return cost;
        }
    }
}
