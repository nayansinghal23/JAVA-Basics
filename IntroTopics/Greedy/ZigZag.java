public class ZigZag {
    // https://leetcode.com/problems/zigzag-conversion/description/

    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        StringBuilder ans = new StringBuilder();

        for (int row = 0; row < numRows; row++) {
            int i = row;
            boolean downDirection = row < numRows - 1;

            while (i < s.length()) {
                ans.append(s.charAt(i));

                if (row == 0 || row == numRows - 1) {
                    i += 2 * (numRows - 1);
                } else {
                    if (downDirection) {
                        i += 2 * (numRows - row - 1);
                    } else {
                        i += 2 * row;
                    }
                    downDirection = !downDirection;
                }
            }
        }

        return ans.toString();
    }

    // https://leetcode.com/problems/maximum-value-of-an-ordered-triplet-ii/description/

    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = nums[0];
        rightMax[n - 1] = nums[n - 1];
        for(int i = 1; i < n; i++) leftMax[i] = Math.max(leftMax[i - 1], nums[i]);
        for(int i = n - 2; i >= 0; i--) rightMax[i] = Math.max(rightMax[i + 1], nums[i]);
        long ans = 0;
        for(int i = 1; i < n - 1; i++) ans = Math.max(ans, (long) (leftMax[i - 1] - nums[i]) * rightMax[i + 1]);
        return ans;
    }
}
