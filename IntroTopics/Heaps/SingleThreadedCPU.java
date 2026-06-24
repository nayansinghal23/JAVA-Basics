package IntroTopics.Heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SingleThreadedCPU {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;

        // {enqueueTime, processingTime, originalIndex}
        int[][] arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            arr[i][0] = tasks[i][0];
            arr[i][1] = tasks[i][1];
            arr[i][2] = i;
        }

        // Sort by enqueue time
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        // Min heap:
        // 1. Smaller processing time first
        // 2. Smaller index if processing time is same
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a[1] != b[1]) {
                    return Integer.compare(a[1], b[1]);
                }
                return Integer.compare(a[2], b[2]);
            }
        );

        int[] ans = new int[n];
        int ansIdx = 0;
        int ptr = 0;
        long currentTime = 0;

        while (ptr < n || !pq.isEmpty()) {

            // If no task is available, jump to the next task's enqueue time
            if (pq.isEmpty()) {
                currentTime = Math.max(currentTime, arr[ptr][0]);
            }

            // Add all tasks that are available at currentTime
            while (ptr < n && arr[ptr][0] <= currentTime) {
                pq.offer(arr[ptr]);
                ptr++;
            }

            // Process the best available task
            int[] task = pq.poll();

            ans[ansIdx++] = task[2]; // original index
            currentTime += task[1];  // processing time
        }

        return ans;
    }
}
