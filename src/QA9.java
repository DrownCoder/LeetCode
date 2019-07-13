/**
 * Author : xuan.
 * Date : 2019-03-28.
 * Description :二叉树的最大深度
 */
class QA9 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int deepLeft = maxDepth(root.left);
        int deepRight = maxDepth(root.right);
        if (deepLeft > deepRight) {
            return deepLeft + 1;
        } else {
            return deepRight + 1;
        }
    }

    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth2(root.left);
        int rightDepth = maxDepth2(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
