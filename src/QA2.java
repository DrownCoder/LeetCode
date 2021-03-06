/**
 * Author : xuan.
 * Date : 2019-02-28.
 * Description :给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 */
class QA2 {
    public static void main(String[] args) {

    }

    /**
     * 不同的话一个换一个，相同的话保留，剩下的就是那个
     */
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalStateException();
        }
        int result = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (result == nums[i]) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    result = nums[i + 1];
                }
            }
        }
        return result;
    }

    /**
     * 找众数 169
     */
    public int findNum(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalStateException();
        }
        int result = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != result) {
                count--;
                if (count == 0) {
                    result = nums[i + 1];
                }
            } else {
                count++;
            }
        }
        return result;
    }

    public int findNum2(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalStateException();
        }
        int result = nums[0];
        int count = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != result) {
                count--;
                if (count == 0) {
                    if (i == nums.length - 1) {
                        throw new IllegalStateException();
                    }
                    result = nums[i + 1];
                }
            }else{
                count++;
            }
        }
        return result;
    }
}
