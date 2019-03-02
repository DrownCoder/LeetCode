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

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null) {
            throw new IllegalStateException();
        }
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            list.add(nums1[i]);
        }
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            if (index == n) {
                return;
            }
            if (list.get(i) >= nums2[index]) {
                list.add(i, nums2[index++]);
                i--;
            }
        }
        while (index < n) {
            list.add(nums2[index++]);
        }
        for (int i = 0; i < list.size(); i++) {
            nums1[i] = list.get(i);
        }
    }
}
