class Solution {
    int[][] dirs = {{0,1}, {1,0}, {-1,0}, {0,-1}};
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        Queue<Point> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        int freshCount = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if (grid[i][j] == 2)
                    q.add(new Point(i, j));
                if (grid[i][j] == 1)
                    freshCount++;
            }
        }

        int minsElapsed = 0;
        while(!q.isEmpty() && freshCount > 0) {
            int size = q.size();
            minsElapsed++;
            for(int i=0; i<size; i++) {
                Point p = q.poll();
                
                for(int[] dir : dirs) {
                    int x = p.x + dir[0];
                    int y = p.y + dir[1];

                    if (x<0 || x>=m || y<0 || y>=n || visited[x][y] || grid[x][y] != 1)
                        continue;
                    
                    visited[x][y] = true;
                    q.add(new Point(x,y));
                    freshCount--;
                }
            }
        }


        return freshCount == 0 ? minsElapsed : -1;
        
    }

    class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
