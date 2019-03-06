/**
 * Author : xuan.
 * Date : 2019-03-06.
 * Description :the description of this file
 */
class QA7 {
    public static void main(String[] args) {

    }

    /**
     * 前序遍历
     */
    public void frontSearch(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.value);
        frontSearch(node.left);
        frontSearch(node.right);
    }

    /**
     * 中序遍历
     */
    public void midSearch(TreeNode node) {
        if (node == null) {
            return;
        }
        midSearch(node.left);
        System.out.println(node.value);
        midSearch(node.right);
    }

    /**
     * 后序遍历
     */
    public void backSearch(TreeNode node) {
        if (node == null) {
            return;
        }
        backSearch(node.left);
        backSearch(node.right);
        System.out.println(node.value);
    }


    public static class TreeNode {
        public TreeNode left;
        public TreeNode right;
        public String value;
    }
}
