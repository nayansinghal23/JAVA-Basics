package IntroTopics.JumpGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.util.TreeSet;

public class Leetcode_2617 {
    // https://leetcode.com/problems/minimum-number-of-visited-cells-in-a-grid/description/

    // Approach 1: BFS but gives TLE because it visits the same cell multiple times.
    /*
    private boolean isValidCoordinate(int i, int j, int m, int n) {
        if(i >= 0 && j >= 0 && i < m && j < n) return true;
        return false;
    }

    public int minimumVisitedCells(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) visited[i][j] = false;
        }
        Queue<List<Integer>> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(0);
        q.offer(list);
        visited[0][0] = true;
        int cells = 1;
        while(q.size() > 0) {
            int size = q.size();
            while(size-- > 0) {
                List<Integer> l = q.poll();
                int i = l.get(0), j = l.get(1);
                if(i == m - 1 && j == n - 1) return cells;

                for(int k = j + 1; k <= grid[i][j] + j; k++) {
                    if(!isValidCoordinate(i, k, m, n)) break;
                    if(visited[i][k]) continue;
                    
                    visited[i][k] = true;
                    List<Integer> rightward = new ArrayList<>();
                    rightward.add(i);
                    rightward.add(k);
                    q.offer(rightward);
                }

                for(int k = i + 1; k <= grid[i][j] + i; k++) {
                    if(!isValidCoordinate(k, j, m, n)) break;
                    if(visited[k][j]) continue;

                    visited[k][j] = true;
                    List<Integer> downward = new ArrayList<>();
                    downward.add(k);
                    downward.add(j);
                    q.offer(downward);
                }
            }
            cells++;
        }
        return -1;
    }
    */

    // Approach 2: Using TreeSet to store the cells that are available to visit.
    public int minimumVisitedCells(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        List<TreeSet<Integer>> rows = new ArrayList<>();
        List<TreeSet<Integer>> cols = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            TreeSet<Integer> set = new TreeSet<>();
            for (int j = 0; j < n; j++) {
                set.add(j);
            }
            rows.add(set);
        }

        for (int j = 0; j < n; j++) {
            TreeSet<Integer> set = new TreeSet<>();
            for (int i = 0; i < m; i++) {
                set.add(i);
            }
            cols.add(set);
        }

        Queue<List<Integer>> q = new LinkedList<>();
        List<Integer> start = new ArrayList<>();
        start.add(0);
        start.add(0);
        q.offer(start);

        rows.get(0).remove(0);
        cols.get(0).remove(0);
        int cells = 1;
        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                List<Integer> cur = q.poll();

                int i = cur.get(0);
                int j = cur.get(1);

                if (i == m - 1 && j == n - 1) {
                    return cells;
                }

                int rightLimit = Math.min(n - 1, j + grid[i][j]);

                Integer col = rows.get(i).ceiling(j + 1);

                while (col != null && col <= rightLimit) {

                    List<Integer> next = new ArrayList<>();
                    next.add(i);
                    next.add(col);

                    q.offer(next);

                    rows.get(i).remove(col);
                    cols.get(col).remove(i);

                    col = rows.get(i).ceiling(col);
                }

                int downLimit = Math.min(m - 1, i + grid[i][j]);

                Integer row = cols.get(j).ceiling(i + 1);

                while (row != null && row <= downLimit) {

                    List<Integer> next = new ArrayList<>();
                    next.add(row);
                    next.add(j);

                    q.offer(next);

                    cols.get(j).remove(row);
                    rows.get(row).remove(j);

                    row = cols.get(j).ceiling(row);
                }
            }
            cells++;
        }
        return -1;
    }
}
