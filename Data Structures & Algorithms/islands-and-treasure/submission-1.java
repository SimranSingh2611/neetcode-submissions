class Solution {
    int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<Point> q = new LinkedList<>();
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if (grid[i][j] == 0) {
                    q.add(new Point(i, j));
                }
            }
        }

        while(!q.isEmpty()) {
            int size = q.size();

            for(int i=0; i<size; i++) {
                Point p = q.poll();

                for(int[] dir : dirs) {
                    int x = p.x + dir[0];
                    int y = p.y + dir[1];

                    if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != Integer.MAX_VALUE)
                        continue;

                    grid[x][y] = grid[p.x][p.y] + 1;
                    q.add(new Point(x,y));
                }
            }
        }


    }

    class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
