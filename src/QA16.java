import java.util.ArrayList;
import java.util.List;

/**
 * Author : xuan.
 * Date : 2019-04-18.
 * Description :给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 解法：回溯法
 */
class QA16 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<Integer>();
        subsets(res,list,nums,0);
        return res;
    }
    public void subsets(List<List<Integer>> res,List<Integer> preList,int[] nums,int index) {
        List<Integer> list = new ArrayList<Integer>();
        if(index == nums.length){
            res.add(preList);
            return;
        }else{
            subsets(res,preList,nums,index+1);
            list.addAll(preList);
            list.add(nums[index]);
            subsets(res,list,nums,index+1);
        }
    }
}
