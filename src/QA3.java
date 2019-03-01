/**
 * Author : xuan.
 * Date : 2019-02-28.
 * Description :编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 * <p>
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 */
class QA3 {
    public static void main(String[] args) {

    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) {
            return false;
        }
        int row = matrix.length;
        if (row == 0) {
            return false;
        }
        int column = matrix[0].length-1;
        if (column == 0) {
            return false;
        }
        int max = Math.max(row, column);
        //遍历行
        int columnCount = 0;
        for (int i = 0; i < row; i++) {
            if (matrix[i][columnCount] == target) {
                return true;
            }
            if (matrix[i][columnCount] < target) {
                if (matrix[i][columnCount + 1] == target) {
                    return true;
                }
                if (matrix[i][columnCount + 1] < target) {
                    columnCount++;
                }
            }
        }
        return false;
    }
}
