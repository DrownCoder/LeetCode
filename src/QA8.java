
/**
 * Author : xuan.
 * Date : 2019-03-28.
 * Description :请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
 * <p>
 * 237.删除链表中的节点
 */
class QA8 {
    public static void main(String[] args) {

    }

    public void deleteNode(ListNode node) {
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
    }

    public void deleteNode2(ListNode node) {
        ListNode next = node.next;
        if (next == null) {
            return;
        }
        node.val = next.val;
        node.next = next.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
