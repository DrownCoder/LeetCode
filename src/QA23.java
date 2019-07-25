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

    /**
     *     1
     *    / \
     *   2   5
     *  / \   \
     * 3   4   6
     *
     * 1
     *  \
     *   2
     *    \
     *     3
     *      \
     *       4
     *        \
     *         5
     *          \
     *           6
     */
    public void flatten2(TreeNode root) {
        //左边拉直
        flatten2(root.left);
        //右边拉直
        flatten2(root.right);
        //暂时存储右边
        TreeNode temp = root.right;
        //把拉直后的左边放到右边
        root.right = root.left;
        //左边置null
        root.left = null;
        //找到右边的末尾
        while (root.right != null) {
            root = root.right;
        }
        //追加原来的右边
        root.right = temp;
    }
}
