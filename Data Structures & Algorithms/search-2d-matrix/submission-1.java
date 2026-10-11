class Solution {
    // minimization
    // answer in high
    // low = lowest invalid value = -1, high = highest valid value = mn
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        if (m == 0 || n == 0) {
            return false;
        }

        int low = -1;
        int high = m*n;

        while (low + 1 < high) {
            int mid = low + (high - low)/2;
            int num = matrix[mid/n][mid%n];

            if (num == target)
                return true;
            else if (num > target) {
                high = mid;
            } else {
                low = mid;
            }
        }

        return false;
    }
}
