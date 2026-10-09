class Solution {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public boolean exist(char[][] board, String word) {

        int m = board.length;
        int n = board[0].length;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if (backtrack(board, word, i, j, 0))
                    return true;
            }
        }
        
        return false;

    }

    private boolean backtrack(char[][] board, String word, int x, int y, int indexInWord) {
        if (indexInWord == word.length())
            return true;
        
        if (x<0 || x>=board.length || y<0 || y>=board[0].length || word.charAt(indexInWord) != board[x][y]) {
            return false;
        }

         // mark the current as dirty
        board[x][y] = '*';
        for(int dir[] : dirs) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            
            if (backtrack(board, word, newX, newY, indexInWord+1)) {
                return true;
            }
        }

         // unmark the current cell with the original value.
        board[x][y] = word.charAt(indexInWord);
        return false;
    }
}
