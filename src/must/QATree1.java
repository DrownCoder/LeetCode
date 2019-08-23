package must;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author : xuan.
 * Date : 2019-03-06.
 * Description :二叉树的先序遍历，中序遍历，后续遍历，递归版本
 */
class QATree1 {
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

    /**
     * 广度遍历
     */
    public void levelSearch(TreeNode node) {
        if (node == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        TreeNode cur = null;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            System.out.println(cur.value);
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }

    public void levelSearch2(TreeNode node) {
        if (node == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            System.out.println(cur.value);
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }

    public void frontSearch2(TreeNode node) {
        if (node == null) {
            return;
        }
        //先根节点
        System.out.println(node.value);
        //在左
        frontSearch2(node.left);
        //右
        frontSearch2(node.right);
    }

    public void midSearch2(TreeNode node) {
        if (node == null) {
            return;
        }
        midSearch2(node.left);
        System.out.println(node.value);
        midSearch2(node.right);
    }

    public void backSearch2(TreeNode node) {
        if (node == null) {
            return;
        }
        backSearch2(node.left);
        backSearch2(node.right);
        System.out.println(node.value);
    }


    public static class TreeNode {
        public TreeNode left;
        public TreeNode right;
        public String value;
    }
}
