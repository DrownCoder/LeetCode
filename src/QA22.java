import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Author : xuan.
 * Date : 2019-06-12.
 * Description :在每个树行中找最大值
 */
class QA22 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            TreeNode top = nodes.peek();
            int size = nodes.size();
            int max = top.val;
            while (size-- > 0) {
                TreeNode node = nodes.removeFirst();
                max = Math.max(max, node.val);
                if (node.left != null) {
                    nodes.add(node.left);
                }
                if (node.right != null) {
                    nodes.add(node.right);
                }
            }
            result.add(max);

        }
        return result;
    }

    /**
     * 层序遍历
     */
    public List<Integer> largestValues2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        //每一层的节点
        Deque<TreeNode> level = new LinkedList<>();
        level.push(root);
        while (!level.isEmpty()) {
            TreeNode top = level.peek();
            int size = level.size();
            int max = top.val;
            while (size-- > 0) {
                //遍历这一层
                TreeNode node = level.removeFirst();
                //找这一层最大的
                max = Math.max(max, node.val);
                //把下一层的节点放入
                if (node.left != null) {
                    level.push(node.left);
                }
                if (node.right != null) {
                    level.push(node.right);
                }
            }
            result.add(max);
        }
        return result;
    }
}
