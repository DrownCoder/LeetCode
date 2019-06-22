/**
 * Author : xuan.
 * Date : 2019-06-21.
 * Description :114. 二叉树展开为链表
 */
class QA23 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        //把左边拉直
        flatten(root.left);
        //把右边拉直
        flatten(root.right);
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = null;
        while (root.right != null) {
            root = root.right;
        }
        root.right = temp;
    }
}
