package must;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author : xuan.
 * Date : 2019-03-09.
 * Description :二叉树相关
 */
class QATree3 {

    /**
     * 获取二叉树的最大宽度
     */
    public static int getMaxWidth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int maxWidth = 1;
        queue.offer(node);
        int len;
        while (true) {
            len = queue.size();
            if (len == 0) {
                break;
            }
            while (len > 0) {
                TreeNode cur = queue.poll();
                len--;
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            maxWidth = Math.max(maxWidth, queue.size());
        }
        return maxWidth;
    }


    /**
     * 动态创建二叉查找树
     *
     * @param TreeNode 根节点
     * @param value    节点的值
     */
    public static void createTree(TreeNode TreeNode, int value) {


        //如果树根为空(第一次访问)，将第一个值作为根节点
        if (TreeNode.root == null) {
            TreeNode treeNode = new TreeNode(value);
            TreeNode.setRoot(treeNode);

        } else {

            //当前树根
            TreeNode tempRoot = TreeNode.root;

            while (tempRoot != null) {
                //当前值大于根值，往右边走
                if (value > tempRoot.getValue()) {

                    //右边没有树根，那就直接插入
                    if (tempRoot.right == null) {
                        tempRoot.right = new TreeNode(value);
                        return;
                    } else {
                        //如果右边有树根，到右边的树根去
                        tempRoot = tempRoot.right;
                    }
                } else {
                    //左没有树根，那就直接插入
                    if (tempRoot.left == null) {
                        tempRoot.left = new TreeNode(value);

                        return;
                    } else {
                        //如果左有树根，到左边的树根去
                        tempRoot = tempRoot.left;
                    }
                }
            }
        }
    }


    public static int getHeight(TreeNode treeNode) {

        if (treeNode == null) {
            return 0;
        } else {

            //左边的子树深度
            int left = getHeight(treeNode.left);

            //右边的子树深度
            int right = getHeight(treeNode.right);


            int max = left;

            if (right > max) {
                max = right;
            }
            return max + 1;
        }
    }

    /**
     * 找出树的最大值
     *
     * @param rootTreeNode
     */
    public static int getMax(TreeNode rootTreeNode) {

        if (rootTreeNode == null) {
            return -1;
        } else {
            //找出左边的最大值
            int left = getMax(rootTreeNode.left);

            //找出右边的最大值
            int right = getMax(rootTreeNode.right);

            //与当前根节点比较
            int currentRootValue = rootTreeNode.getValue();

            //假设左边的最大
            int max = left;


            if (right > max) {
                max = right;
            }
            if (currentRootValue > max) {
                max = currentRootValue;
            }

            return max;


        }
    }


    public static class TreeNode {
        public TreeNode left;
        public TreeNode right;
        public TreeNode root;
        public String value;

        public TreeNode(int value) {
            this.value = String.valueOf(value);
        }

        public int getValue() {
            return Integer.valueOf(value);
        }

        public void setRoot(TreeNode root) {
            this.root = root;
        }
    }
}
