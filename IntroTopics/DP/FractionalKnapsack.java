public class FractionalKnapsack {
    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
            int n = val.length;
            double[][] nums = new double[n][2];
            for(int i = 0; i < n; i++) {
                nums[i][0] = (double) val[i] / wt[i]; // Value per weight
                nums[i][1] = wt[i];
            }
            Arrays.sort(nums, (a, b) -> Double.compare(b[0], a[0])); // DECREASING
            double profit = 0;
            for(int i = 0; i < n && capacity > 0; i++) {
                int weight = (int) nums[i][1];
                if(capacity >= weight) {
                    profit += nums[i][0] * weight;
                    capacity -= weight;
                }
                else {
                    profit += nums[i][0] * capacity;
                    capacity = 0;
                }
            }
            return profit;
        }
}
