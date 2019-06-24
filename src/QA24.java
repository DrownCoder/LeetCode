/**
 * Author : xuan.
 * Date : 2019-06-24.
 * Description :283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 */
class QA24 {
    public static void main(String[] args) {
        int[] test = new int[]{
                1, 0
        };
        moveZeroes(test);
    }

    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 1) {
            return;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] == 0) {
                if (index < i) {
                    index = i;
                }
                while (nums[index] == 0) {
                    index++;
                    if (index >= nums.length) {
                        for (; i < nums.length; i++) {
                            nums[i] = 0;
                        }
                        return;
                    }
                }

                nums[i] = nums[index];
                nums[index] = 0;
            }
        }
    }

    public static void moveZeroes2(int[] nums) {
        if (nums == null || nums.length == 1) {
            return;
        }
        int i = 0, j = 0;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        while (j < nums.length) {
            nums[j++] = 0;
        }
    }
}
