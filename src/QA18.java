import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Author : xuan.
 * Date : 2019-05-23.
 * Description :46，全排列
 * https://blog.csdn.net/qq_16403141/article/details/80548282
 */
class QA18 {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> outPut = new LinkedList<>();
        ArrayList<Integer> nums_list = new ArrayList<>();
        for (int num : nums) {
            nums_list.add(num);
        }
        int n = nums.length;
        backTrack(n, nums_list, outPut, 0);
        return outPut;
    }

    private static void backTrack(int n,
                                  ArrayList<Integer> nums,
                                  List<List<Integer>> output,
                                  int first) {
        // if all integers are used up
        if (first == n)
            output.add(new ArrayList<>(nums));
        for (int i = first; i < n; i++) {
            // place i-th integer first
            // in the current permutation
            Collections.swap(nums, first, i);
            // use next integers to complete the permutations
            backTrack(n, nums, output, first + 1);
            // backtrack
            Collections.swap(nums, first, i);
        }
    }

    public static List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> outPut = new LinkedList<>();
        ArrayList<Integer> nums_list = new ArrayList<>();
        for (int num : nums) {
            nums_list.add(num);
        }
        backTrack2(nums, nums_list, outPut, 0);
        return outPut;
    }

    private static void backTrack2(int[] nums, List<Integer> nums_list,
                                   List<List<Integer>> outPut, int index) {
        if (index >= nums.length) {
            outPut.add(new ArrayList<>(nums_list));
        }
        for (int i = index; i < nums.length; i++) {
            Collections.swap(nums_list, index, i);
            backTrack2(nums, nums_list, outPut, index + 1);
            Collections.swap(nums_list, index, i);
        }
    }

    public static void dfs2(int[] nums, List<List<Integer>> res, List<Integer> list, int index) {
        if (index >= nums.length) {
            res.add(new ArrayList<>(list));
        }
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            dfs2(nums, res, list, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] num = new int[]{
                1, 2, 3
        };
        permute2(num);
    }
}
