/**
 * Author : xuan.
 * Date : 2019-06-25.
 * Description :236. 二叉树的最近公共祖先
 */
class QA25 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (q == root || p == root) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        } else {
            return left == null ? right : left;
        }
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == q || root == p) {
            return root;
        }
        //左边找两个的公共父节点
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        //右边找两个的公共父节点
        TreeNode right = lowestCommonAncestor2(root.right, p, q);
        if (left != null && right != null) {
            //两个都不为null,则说明左右都能找到，由唯一性，确定为root
            return root;
        }else{
            //任意一个不为null,说明在一端可以找到，那么就是那个节点
            return left != null ? left : right;
        }
    }
}
