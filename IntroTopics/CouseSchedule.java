package IntroTopics;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class CouseSchedule {
    public void main() {
        Scanner sc = new Scanner(System.in); 
        System.out.println("Enter total number of courses : ");
        int numCourses = sc.nextInt();

        System.out.println("Enter total number of prerequisites : ");
        int n = sc.nextInt();
        
        int[][] prerequisites = new int[n][2];
        for(int i = 0; i < n; i++) {
            System.out.println("Enter prerequisites : " + i + 1);
            prerequisites[i][0] = sc.nextInt();
            prerequisites[i][1] = sc.nextInt();
        }
        System.out.println("Can user finish all courses : " + this.canFinish(numCourses, prerequisites));
        System.out.println("Order of courses : " + this.findOrder(numCourses, prerequisites));
        sc.close();
    }

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

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Creating adjacency list
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < prerequisites.length; i++) {
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];

            List<Integer> list = map.get(b);
            if(list == null) list = new ArrayList<>();

            list.add(a);
            map.put(b, list);
        }
        // Creating visited array
        boolean[] visited = new boolean[numCourses];
        boolean[] dfsVisited = new boolean[numCourses];
        for(int i = 0; i < numCourses; i++) visited[i] = dfsVisited[i] = false;
        // If there is a cycle return false else true
        boolean isCycle = false;
        for(int i = 0; i < numCourses; i++) {
            if(!visited[i]) isCycle = this.detectCycle(map, visited, dfsVisited, i);
            if(isCycle) return false;
        }
        return true;
    }

    private boolean detectCycle(Map<Integer, List<Integer>> map, boolean[] visited, boolean[] dfsVisited, int node) {
        visited[node] = dfsVisited[node] = true;
        List<Integer> neighbors = map.get(node);
        if(neighbors == null) neighbors = new ArrayList<>();

        for(int neighbor : neighbors) {
            if(!visited[neighbor]) {
                if(this.detectCycle(map, visited, dfsVisited, neighbor)) return true;
            }
            else if(dfsVisited[neighbor]) return true;
        }
        dfsVisited[node] = false;
        return false;
    }
}
