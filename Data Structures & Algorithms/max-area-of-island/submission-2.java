class Solution {
    int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        int maxArea = 0;
        // int area = 0;
        for(int i=0; i<m ; i++) {
            for(int j=0; j<n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    int area = dfs(grid, visited, i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, boolean[][] visited, int i, int j) {

        int m = grid.length;
        int n = grid[0].length;

        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || grid[i][j] != 1)
            return 0;

        visited[i][j] = true;

        // Count current land cell
        int area = 1;

        // Count connected land cells
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];

            area += dfs(grid, visited, x, y);
        }

        return area;
    }
}
