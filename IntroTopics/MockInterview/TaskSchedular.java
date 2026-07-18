public class TaskSchedular {
    // https://leetcode.com/problems/task-scheduler/description/

    // Explaination : https://youtu.be/rYh-Kkbzsnw?si=2RNbRKHcVNqN_ikT

    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char ch : tasks) freq[ch - 'A']++;
        int time = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(b, a)
        );
        for(int i = 0; i < 26; i++) {
            if(freq[i] > 0) pq.offer(freq[i]);
        }
        while(!pq.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            for(int i = 1; i <= n + 1; i++) {
                if(pq.isEmpty()) break;

                int frequency = pq.poll();
                frequency--;
                list.add(frequency);
            }

            for(int frequency : list) {
                if(frequency > 0) pq.offer(frequency);
            }

            time += pq.isEmpty() ? list.size() : n + 1;
        }
        return time;
    }
}