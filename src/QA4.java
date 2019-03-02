import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Author : xuan.
 * Date : 2019-03-02.
 * Description :定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 */
class QA4 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add(0, "f");
        System.out.println(list);
    }

    /**
     * 从最后开始，分别去num1的有效最后和num2的有效最后比较，取大的放入
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int end = m-- + n-- - 1;
        while (m >= 0 && n >= 0) {
            nums1[end--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        }
        while (n >= 0) {
            nums1[end--] = nums2[n--];
        }
    }
}
