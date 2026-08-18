public class SurroundedRegions {
    // https://leetcode.com/problems/surrounded-regions/description/
    
    private boolean isValid(int i, int j, int m, int n, boolean[][] visited, char[][] board) {
        if(i < 0 || i >= m || j < 0 || j >= n) return false;
        if(visited[i][j] || board[i][j] == 'X') return false;
        return true;
    }

    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) visited[i][j] = false;
        }
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            // traverse first row of board
            if(board[0][i] == 'O') {
                visited[0][i] = true;
                q.offer(new int[]{ 0, i });
            }
            // traverse last row of board
            if(board[m - 1][i] == 'O') {
                visited[m - 1][i] = true;
                q.offer(new int[]{ m - 1, i });
            }
        }
        for(int i = 0; i < m; i++) {
            // traverse first column of board
            if(board[i][0] == 'O') {
                visited[i][0] = true;
                q.offer(new int[]{ i, 0 });
            }
            // traverse last column of board
            if(board[i][n - 1] == 'O') {
                visited[i][n - 1] = true;
                q.offer(new int[]{ i, n - 1 });
            }
        }
        Set<String> set = new HashSet<>();
        while(!q.isEmpty()) {
            int r = q.peek()[0], c = q.peek()[1];
            q.poll();
            set.add(r + "_" + c);
            // top
            if(isValid(r - 1, c, m, n, visited, board)) {
                visited[r - 1][c] = true;
                q.offer(new int[]{ r - 1, c });
            }
            // right
            if(isValid(r, c + 1, m, n, visited, board)) {
                visited[r][c + 1] = true;
                q.offer(new int[]{ r, c + 1 });
            }
            // bottom
            if(isValid(r + 1, c, m, n, visited, board)) {
                visited[r + 1][c] = true;
                q.offer(new int[]{ r + 1, c });
            }
            // left
            if(isValid(r, c - 1, m, n, visited, board)) {
                visited[r][c - 1] = true;
                q.offer(new int[]{ r, c - 1 });
            }
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'O' && !set.contains(i + "_" + j)) board[i][j] = 'X';
            }
        }
    }
}
