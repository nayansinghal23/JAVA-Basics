public class CourseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < prerequisites.length; i++) {
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];

            List<Integer> list = map.get(b);
            if(list == null) list = new ArrayList<>();
            list.add(a);
            map.put(b, list);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] dfsVisited = new boolean[numCourses];
        for(int i = 0; i < numCourses; i++) visited[i] = dfsVisited[i] = false;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < numCourses; i++) {
            if(!visited[i]) {
                if(this.topologicalSort(map, visited, dfsVisited, stack, i)) return new int[0]; // Cycle detected
            }
        }
        int[] result = new int[numCourses];
        for(int i = 0; i < numCourses; i++) result[i] = stack.pop();
        return result;
    }

    private boolean topologicalSort(Map<Integer, List<Integer>> map, boolean[] visited, boolean[] dfsVisited, Stack<Integer> stack, int node) {
        visited[node] = dfsVisited[node] = true;
        List<Integer> neighbors = map.get(node);
        if(neighbors == null) neighbors = new ArrayList<>();
        for(int neighbor : neighbors) {
            if(!visited[neighbor]) {
                if(this.topologicalSort(map, visited, dfsVisited, stack, neighbor)) return true; // Cycle detected
            }
            else if(dfsVisited[neighbor]) return true;
        }
        dfsVisited[node] = false;
        stack.push(node);
        return false;
    }
}

public class CourseSchedule3 {
    // Explaination :- https://leetcode.com/problems/course-schedule-iii/solutions/8400093/greedy-max-heap-sort-by-deadline-drop-th-6s00/
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> Integer.compare(a[1], b[1]));
        int time = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(b, a)
        );
        for(int i = 0; i < courses.length; i++) {
            int duration = courses[i][0];
            int lastDay = courses[i][1];
            time += duration;
            pq.offer(duration);
            if(!pq.isEmpty() && time > lastDay) {
                time -= pq.peek();
                pq.poll();
            }
        }
        return pq.size();
    }
}

class CourseScheduleIV {
    private boolean DFS(Map<Integer, List<Integer>> map, boolean[] visited, int a, int b, Boolean[][] memo) {
        if(a == b) return memo[a][b] = true;
        if(memo[a][b] != null) return memo[a][b];

        visited[a] = true;
        List<Integer> neighbors = map.getOrDefault(a, new ArrayList<>());
        for(int neighbor : neighbors) {
            if(!visited[neighbor]) {
                boolean flag = DFS(map, visited, neighbor, b, memo);
                if(flag) return memo[a][b] = true;
            }
        }
        visited[a] = false;
        return memo[a][b] = false;
    }

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < prerequisites.length; i++) {
            int a = prerequisites[i][0], b = prerequisites[i][1];
            List<Integer> list = map.getOrDefault(a, new ArrayList<>());
            list.add(b);
            map.put(a, list);
        }
        List<Boolean> ans = new ArrayList<>();
        boolean visited[] = new boolean[numCourses];
        Boolean[][] memo = new Boolean[numCourses][numCourses];
        for(int i = 0; i < queries.length; i++) {
            for(int j = 0; j < numCourses; j++) visited[j] = false;
            int a = queries[i][0], b = queries[i][1];
            ans.add(DFS(map, visited, a, b, memo));
        }
        return ans;
    }
}

class ParallelCourses { // https://www.lintcode.com/problem/3673
    public int minimumSemesters(int n, int[][] relations) { // Khan's Algorithm - calculates indegree
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) graph.put(i, new ArrayList<>());
        int[] indegree = new int[n + 1]; // indegree[i] = number of prerequisites of course i
        for (int[] relation : relations) {
            int prev = relation[0];
            int next = relation[1];
            graph.get(prev).add(next);
            indegree[next]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }
        int semesters = 0;
        int completedCourses = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int course = queue.poll();
                completedCourses++;
                // Remove this course as a prerequisite
                for (int nextCourse : graph.get(course)) {
                    indegree[nextCourse]--;
                    // If all prerequisites are completed,
                    // this course can be taken next semester.
                    if (indegree[nextCourse] == 0) {
                        queue.offer(nextCourse);
                    }
                }
            }
            semesters++;
        }
        // If not all courses were completed,
        // a cycle exists.
        return completedCourses == n ? semesters : -1;
    }
}

class ParallelCoursesIII { // https://leetcode.com/problems/parallel-courses-iii/description/
    // We can't implement batch based processing because a particular course needs to wait for its direct prereqs to complete, not for unrelated courses.
    public int minimumTime(int n, int[][] relations, int[] time) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        int[] indegree = new int[n + 1];

        for (int[] r : relations) {
            int prev = r[0], next = r[1];
            graph.get(prev).add(next);
            indegree[next]++;
        }

        int[] completion = new int[n + 1];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
                completion[i] = time[i - 1]; // no prereqs, starts at 0
            }
        }

        int ans = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            ans = Math.max(ans, completion[node]);
            for (int next : graph.get(node)) {
                // next's completion depends on the max over ALL its direct prereqs
                completion[next] = Math.max(completion[next], completion[node] + time[next - 1]);
                if (--indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }
        return ans;
    }
}