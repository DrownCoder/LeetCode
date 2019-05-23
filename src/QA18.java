import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Author : xuan.
 * Date : 2019-05-23.
 * Description :the description of this file
 */
class QA18 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> outPut = new LinkedList<>();
        ArrayList<Integer> nums_list = new ArrayList<>();
        for (int num : nums) {
            nums_list.add(num);
        }
        int n = nums.length;
        backTrack(n, nums_list, outPut, 0);
        return outPut;
    }

    private void backTrack(int n,
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
}
