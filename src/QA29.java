/**
 * Author : xuan.
 * Date : 2019-07-03.
 * Description :153. 寻找旋转排序数组中的最小值
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 请找出其中最小的元素。
 * <p>
 * 你可以假设数组中不存在重复元素。
 */
class QA29 {
    public static void main(String[] args) {
        int[] num = new int[]{
                5, 1, 2, 3, 4
        };
        System.out.println(findMin(num));
    }

    public static int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.min(nums[0], nums[1]);
        }
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        if (nums[right] > nums[left]) {
            //说明没有发生旋转
            return nums[left];
        }
        while (left < right) {
            mid = (left + right) / 2;
            if (nums[left] < nums[mid] && nums[mid] < nums[right]) {
                break;
            }
            if (nums[right] < nums[mid]) {
                //说明中间点被旋转了
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
