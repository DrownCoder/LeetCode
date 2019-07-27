/**
 * Author : xuan.
 * Date : 2019-06-24.
 * Description :283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 */
class QA24 {
    public static void main(String[] args) {
        int[] test = new int[]{
                0, 0, 1
        };
        moveZeroes2(test);
        for (int i : test) {
            System.out.println(i);
        }
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

    public static void moveZeroes3(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int i = 0;//遍历所有
        int j = 0;//j之前的都不是0
        for (; i < nums.length; i++) {
            if (nums[i] != 0) {
                //找不等于0的
                nums[j++] = nums[i];
            }
        }
        while (j < nums.length) {
            nums[j++] = 0;
        }
    }
}
