/**
 * Author : xuan.
 * Date : 2019-02-26.
 * Description :给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 */
class QA1 {
    public static void main(String[] args) {
    }

    private int logSingleOne(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalStateException();
        }
        int result = 0;
        for (int i = 1; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }
}
