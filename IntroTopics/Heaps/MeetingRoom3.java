public class MeetingRoom3 {
    /**
     * availableRooms (minHeap) → smallest room index
     * occupiedRooms (minHeap) → earliest finishing room
     */
    public int mostBooked(int n, int[][] meetings) {
        int[] rooms = new int[n];

        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<int[]> occupiedRooms = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
                return Integer.compare(a[1], b[1]);
            }
        );

        PriorityQueue<Integer> availableRooms = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            availableRooms.offer(i);
        }

        for (int i = 0; i < meetings.length; i++) {

            while (!occupiedRooms.isEmpty() && occupiedRooms.peek()[0] <= meetings[i][0]) {
                availableRooms.offer(occupiedRooms.poll()[1]);
            }

            if (availableRooms.isEmpty()) {
                int[] earliest = occupiedRooms.poll();

                int start = earliest[0];
                int duration = meetings[i][1] - meetings[i][0];
                int room = earliest[1];

                occupiedRooms.offer(new int[]{start + duration, room});
                rooms[room]++;
            } else {
                int room = availableRooms.poll();
                occupiedRooms.offer(new int[]{meetings[i][1], room});
                rooms[room]++;
            }
        }

        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (rooms[i] > rooms[ans]) {
                ans = i;
            }
        }

        return ans;
    }
}
