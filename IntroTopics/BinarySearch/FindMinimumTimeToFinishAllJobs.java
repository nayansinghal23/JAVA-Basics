public class FindMinimumTimeToFinishAllJobs {
    // https://leetcode.com/problems/find-minimum-time-to-finish-all-jobs/description/

    // Key idea : Binary search + DFS (Backtracking)

    private boolean isValid(int[] jobs, int target, int[] workers, int i) {
        if(i < 0) return true;

        for(int worker = 0; worker < workers.length; worker++) {
            if(workers[worker] + jobs[i] > target) continue;

            workers[worker] += jobs[i];
            boolean flag = isValid(jobs, target, workers, i - 1);
            workers[worker] -= jobs[i];

            if(flag) return true;
        }
        return false;
    }

    public int minimumTimeRequired(int[] jobs, int k) {
        Arrays.sort(jobs);
        int start = 0, end = 0;
        int ans = end;
        for(int i = 0; i < jobs.length; i++) end += jobs[i];
        while(start <= end) {
            int mid = (start + end) / 2;
            int[] workers = new int[k];
            for(int i = 0; i < k; i++) workers[i] = 0;
            if(isValid(jobs, mid, workers, jobs.length - 1)) {
                ans = mid;
                end = mid - 1;
            }
            else start = mid + 1;
        }
        return ans;
    }
}
