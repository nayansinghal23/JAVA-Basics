class Cell {
    int height;
    int i;
    int j;

    public Cell(int height, int i, int j) {
        this.height = height;
        this.i = i;
        this.j = j;
    }
}

class Solution {

    // We start from the boundary because water can only leak through the boundary.
    // A min-heap always gives the current lowest boundary, which determines
    // the maximum water level for its neighbouring cells.
    public int trapRainWater(int[][] heightMap) {

        int m = heightMap.length;
        int n = heightMap[0].length;

        if (m <= 2 || n <= 2)
            return 0;

        boolean[][] visited = new boolean[m][n];

        PriorityQueue<Cell> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.height, b.height)
        );

        // Left & Right boundary
        for (int i = 0; i < m; i++) {
            pq.offer(new Cell(heightMap[i][0], i, 0));
            pq.offer(new Cell(heightMap[i][n - 1], i, n - 1));

            visited[i][0] = true;
            visited[i][n - 1] = true;
        }

        // Top & Bottom boundary
        // (Avoid corners because they are already inserted)
        for (int j = 1; j < n - 1; j++) {
            pq.offer(new Cell(heightMap[0][j], 0, j));
            pq.offer(new Cell(heightMap[m - 1][j], m - 1, j));

            visited[0][j] = true;
            visited[m - 1][j] = true;
        }

        int[][] dir = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        int ans = 0;

        while (!pq.isEmpty()) {

            Cell cell = pq.poll();

            for (int[] d : dir) {

                int ni = cell.i + d[0];
                int nj = cell.j + d[1];

                if (ni < 0 || ni >= m || nj < 0 || nj >= n)
                    continue;

                if (visited[ni][nj])
                    continue;

                visited[ni][nj] = true;

                // Water trapped at this neighbour
                ans += Math.max(0, cell.height - heightMap[ni][nj]);

                // Push neighbour with its effective boundary height
                pq.offer(new Cell(
                    Math.max(cell.height, heightMap[ni][nj]),
                    ni,
                    nj
                ));
            }
        }

        return ans;
    }
}