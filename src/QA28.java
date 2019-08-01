/**
 * Author : xuan.
 * Date : 2019-07-02.
 * Description :
 * 重建二叉树
 * 题目：输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如：前序遍历序列｛ 1， 2，
 * 4，7，3，5，6，8｝和中序遍历序列｛4，7，2，1，5，3，8，6}，重建出下图所示的二叉树并输出它的头结点。
 */
class QA28 {
    /**
     * 二叉树节点类
     */
    public static class BinaryTreeNode {
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    /**
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二节树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     *
     * @param preorder 前序遍历
     * @param inorder  中序遍历
     * @return 树的根结点
     */
    public static BinaryTreeNode construct(int[] preorder, int[] inorder) {
        // 输入的合法性判断，两个数组都不能为空，并且都有数据，而且数据的数目相同
        if (preorder == null || inorder == null || preorder.length != inorder.length || inorder.length < 1) {
            return null;
        }
        return construct(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private static BinaryTreeNode construct(int[] preorder, int preStart, int preEnd,
                                            int[] inorder, int midStart, int midEnd) {
        //终止递归
        if (preStart > preEnd) {
            return null;
        }
        //保存根节点
        int index = preStart;
        int value = preorder[index];
        //在中序排序中找根节点位置
        index = midStart;
        while (index <= midEnd) {
            if (inorder[index] == value) {
                break;
            }
            index++;
        }
        //构建根节点
        BinaryTreeNode node = new BinaryTreeNode();
        node.value = value;
        int leftLength = index - midStart + 1;
        int leftEnd = preStart + index - midStart + 1 - 1;
        node.left = construct(preorder, preStart + 1, preStart + index - midStart,
                inorder, midStart, index - 1);
        node.right = construct(preorder, preStart + index - midStart + 1, preEnd, inorder,
                index + 1, midEnd);
        return node;
    }


    private static BinaryTreeNode construct2(int[] preorder, int preStart, int preEnd,
                                             int[] inorder, int midStart, int midEnd) {
        //终止遍历
        if (preStart > preEnd) {
            return null;
        }
        //根节点的value,在前序遍历的头结点
        int rootValue = preorder[preStart];
        int rootIndex = midStart;
        //在中序遍历中找root结点的位置
        for (; rootIndex < inorder.length; rootIndex++) {
            if (inorder[rootIndex] == rootValue) {
                break;
            }
        }
        //构建root结点
        BinaryTreeNode root = new BinaryTreeNode();
        root.value = rootValue;
        //构建左子树
        root.left = construct2(preorder, preStart + 1, preStart + (rootIndex - midStart),
                inorder, midStart, rootIndex - 1);
        //构建右子树
        root.right = construct2(preorder, preStart + (rootIndex - midStart) + 1, preEnd,
                inorder, rootIndex + 1, midEnd);
        return root;
    }
}
