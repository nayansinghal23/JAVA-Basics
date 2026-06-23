package IntroTopics.DP;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

// https://leetcode.com/problems/maximum-profit-in-job-scheduling/
public class MaxProfitInJobScheduling {
    private Integer[] dp;

    private int nextJobIndex(List<List<Integer>> jobs, int i) {
        int targetEndTime = jobs.get(i).get(1);

        int left = i + 1;
        int right = jobs.size() - 1;
        int ans = jobs.size();

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (jobs.get(mid).get(0) >= targetEndTime) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    private int maxProfit(List<List<Integer>> jobs, int i) {
        if (i >= jobs.size()) {
            return 0;
        }

        if (dp[i] != null) {
            return dp[i];
        }

        int next = nextJobIndex(jobs, i);

        int take = jobs.get(i).get(2) + maxProfit(jobs, next);
        int skip = maxProfit(jobs, i + 1);

        return dp[i] = Math.max(take, skip);
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;

        List<List<Integer>> jobs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            jobs.add(Arrays.asList(
                startTime[i],
                endTime[i],
                profit[i]
            ));
        }

        jobs.sort((a, b) -> Integer.compare(a.get(0), b.get(0)));

        dp = new Integer[n];

        return maxProfit(jobs, 0);
    }
}
