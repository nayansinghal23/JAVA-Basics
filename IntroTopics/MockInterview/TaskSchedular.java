public class TaskSchedular {
    // https://leetcode.com/problems/task-scheduler/description/

    // Explaination : https://leetcode.com/problems/task-scheduler/solutions/104500/java-on-time-o1-space-1-pass-no-sorting-jw4qz

    public int leastInterval(char[] tasks, int n) {
        int[] counter = new int[26];
        int max = 0;
        int maxCount = 0;
        for(char task : tasks) {
            counter[task - 'A']++;
            if(max == counter[task - 'A']) {
                maxCount++;
            }
            else if(max < counter[task - 'A']) {
                max = counter[task - 'A'];
                maxCount = 1;
            }
        }
        
        int partCount = max - 1; // The number of gaps between the most frequent tasks. If A appears 3 times, there are 2 gaps.
        int partLength = n - (maxCount - 1); // The size of each gap. If multiple tasks share the maximum frequency (e.g., both A and B appear 3 times), they sit right next to each other (A B ... A B ... A B), which reduces the actual empty space left in each gap.
        int emptySlots = partCount * partLength;
        int availableTasks = tasks.length - max * maxCount;
        int idles = Math.max(0, emptySlots - availableTasks);
        
        return tasks.length + idles;
    }
}
