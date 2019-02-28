/**
 * Author : xuan.
 * Date : 2019-02-28.
 * Description :给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 */
class QA2 {
    public static void main(String[] args) {

    }

    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalStateException();
        }
        int result = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (result == nums[i]) {
                count++;
            }else{
                count--;
                if (count == 0) {
                    result = nums[i + 1];
                }
            }
        }
        return result;
    }
}
