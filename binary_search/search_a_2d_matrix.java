class Solution {

    private int searchRows(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (matrix[mid][0] <= target &&
                target <= matrix[mid][matrix[mid].length - 1]) {
                return mid;
            } else if (matrix[mid][0] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return -1;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = searchRows(matrix, target);
        if (row == -1) {
            return false;
        }

        int left = 0;
        int right = matrix[row].length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return false;
    }
}

