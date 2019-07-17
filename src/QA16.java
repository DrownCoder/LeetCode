import java.util.ArrayList;
import java.util.List;

/**
 * Author : xuan.
 * Date : 2019-04-18.
 * 78
 * Description :给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 解法：回溯法
 */
class QA16 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<Integer>();
        subsets(res, list, nums, 0);
        return res;
    }

    public void subsets(List<List<Integer>> res, List<Integer> preList, int[] nums, int index) {
        List<Integer> list = new ArrayList<Integer>();
        if (index == nums.length) {
            res.add(preList);
            return;
        } else {
            subsets(res, preList, nums, index + 1);
            list.addAll(preList);
            list.add(nums[index]);
            subsets(res, list, nums, index + 1);
        }
    }


    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), nums, 0);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> ll, int[] num, int index) {
        res.add(new ArrayList<>(ll));
        for (int i = index; i < num.length; i++) {
            ll.add(num[i]);
            dfs(res, ll, num, i + 1);
            ll.remove(ll.size() - 1);
        }
    }

    public static void main(String[] args) {
        QA16 qa16 = new QA16();
        qa16.subsets2(new int[]{
                1, 2, 3, 4
        });
    }
}
