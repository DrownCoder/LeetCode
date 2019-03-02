/**
 * Author : xuan.
 * Date : 2019-02-28.
 * Description :编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 * <p>
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 *
 */
class QA3 {
    public static void main(String[] args) {

    }

    /**
     * 从右上角或者左下角开始遍历
     * 可以一次判断一行
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int column = matrix[0].length;
        int startC = column - 1;
        int startL = 0;
        if (matrix[startL][startC] == target) {
            return true;
        }
        while (startL < matrix.length && startC >= 0) {
            if (matrix[startL][startC] == target) {
                return true;
            }
            if (matrix[startL][startC] > target) {
                startC--;
            }else {
                startL++;
            }
        }
        return false;
    }
}
