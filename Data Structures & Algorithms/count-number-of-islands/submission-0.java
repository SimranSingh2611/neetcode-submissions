class Solution {
    int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        int islands = 0;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if (grid[i][j] == '1'  && !visited[i][j]) {
                    islands++;
                    dfs(grid, visited, i, j, islands);
                }
                
            }
        }

        return islands;
    }

    private void dfs(char[][] grid, boolean[][] visited, int x, int y, int islands) {
        int m = grid.length;
        int n = grid[0].length;

        if (x<0 || x>=m || y<0 || y>=n || visited[x][y] || grid[x][y] != '1')
            return;
            
        visited[x][y] = true;

        for(int[] dir : dirs) {
            int newX = x + dir[0];
            int newY = y + dir[1];

            dfs(grid, visited, newX, newY, islands);
        }

    }
}
