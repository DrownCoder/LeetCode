package must;

import java.util.Stack;

/**
 * Author : xuan.
 * Date : 2019-03-06.
 * Description :二叉树的先序遍历，中序遍历，后续遍历，非递归版本
 */
class QATree2 {
    public static void main(String[] args) {

    }

    /**
     * 前序遍历
     */
    public void frontSearch(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = node;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                //打印节点
                System.out.println(cur.value);
                //把当前节点入栈
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            //右边
            cur = cur.right;
        }

    }

    public void frontSearch2(TreeNode node) {
        if (node == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = node;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                System.out.println(cur.value);
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
    }

    /**
     * 中序遍历
     */
    public void midSearch(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = node;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            System.out.println(cur.value);
            cur = cur.right;
        }
    }

    public void midSearch2(TreeNode node) {
        if (node == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = node;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            System.out.println(cur.value);
            cur = cur.right;
        }
    }

    /**
     * 后序遍历
     */
    public void backSearch(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = node;
        TreeNode last = null;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            //先获取，但是不出栈
            cur = stack.peek();
            //判断右边，有没有
            if (cur.right == null || cur.right == last) {
                //没有则出战,或者右边已经打印过了
                System.out.println(cur.value);
                stack.pop();
                last = cur;
                //当前这个点，要不是就是右边没有的根节点，要不就是右边有，但是都打印完了，
                // 所以肯定是末尾节点，打印完后，就没用了，所以直接取栈内下一个就行，没必要再做一次判断
                cur = null;
            } else {
                cur = cur.right;
            }
        }
    }

    public void backSearch2(TreeNode node) {
        if (node == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = node;
        TreeNode last = null;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            if (cur.right != null && cur.right != last) {
                cur = cur.right;
            } else {
                System.out.println(cur);
                stack.pop();
                last = cur;
                cur = null;
            }
        }
    }


    public static class TreeNode {
        public TreeNode left;
        public TreeNode right;
        public String value;
    }
}
