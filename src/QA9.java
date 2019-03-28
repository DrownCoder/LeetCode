/**
 * Author : xuan.
 * Date : 2019-03-28.
 * Description :the description of this file
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
}
