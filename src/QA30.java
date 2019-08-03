/**
 * Author : xuan.
 * Date : 2019-07-05.
 * Description :19. 删除链表的倒数第N个节点
 */
class QA30 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode fast = head;
            while (n > 0 && fast != null) {
                fast = fast.next;
                n--;
            }
            if (fast == null) {
                return head.next;
            }
            ListNode slow = head;
            while (fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }
            slow.next = slow.next.next;
            return head;
        }

        /**
         * 快慢指针
         * 1-2-3-4-5
         * 倒数第二个
         * fast先走n步
         * fast->2
         * slow->1
         * slow和fast同时走，走到末尾
         * fast->5
         * slow->3
         */
        public ListNode removeNthFromEnd2(ListNode head, int n) {
            ListNode fast = head;
            while (fast != null && n > 0) {
                fast = fast.next;
                n--;
            }
            if (fast == null) {
                return head;
            }
            ListNode slow = head;
            while (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
            slow.next = slow.next.next;
            return head;
        }
    }
}
