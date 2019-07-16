/**
 * Author : xuan.
 * Date : 2019-04-17.
 * 160. 相交链表
 * Description :编写一个程序，找到两个单链表相交的起始节点。
 */
class QA15 {
    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pa = headA, pb = headB;
        while (pa != pb) {
            pa = pa == null ? headB : pa.next;
            pb = pb == null ? headA : pb.next;
        }
        return pa;
    }

    public ListNode get2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode goA = headA;
        ListNode goB = headB;
        while (goA != goB) {
            goA = goA == null ? headA : goA.next;
            goB = goB == null ? headB : goB.next;
        }
        return goA;
    }


    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }
}
