/**
 * Author : xuan.
 * Date : 2019-04-10.
 * Description :最大连续子数组的和
 * 输入一个整型数组，整型数组里有正数也有负数。数组中一个或连续多个正数组成一个子数组。要求所有子数组的和的最大值。（时间复杂度为O(n)）
 * 解法：显然，一个数值加上一个负值，所得到的结果自然小于其本身。
 */
class QA11 {
    public static void main(String[] args) {
        int[] arr = {1, -2, 3, 10, -4, 7, 2, -5};
        System.out.println(maxSonSum(arr));
    }


    public static int maxSonSum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int curMax = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (curMax <= 0) {
                curMax = arr[i];
            }else{
                curMax += arr[i];
            }
            if (curMax > max) {
                max = curMax;
            }
        }
        return max;
    }
}
