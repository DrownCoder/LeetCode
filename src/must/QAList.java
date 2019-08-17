package must;

/**
 * Author : xuan.
 * Date : 2019-03-09.
 * Description :手写链表逆序代码
 * 判断单链表成环与否？
 * 链表翻转（即：翻转一个单项链表）
 * 合并多个单有序链表（假设都是递增的）
 */
class QAList {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (l1 != null && l2 != null) {
            if (l1.data > l2.data) {
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
            } else {
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
            }
        }
        if (l1 != null) {
            cur.next = l1;
        } else if (l2 != null) {
            cur.next = l2;
        }
        return head.next;
    }

    public ListNode mergeLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (l1 != null && l2 != null) {
            if (l1.data > l2.data) {
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
            }else{
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
            }
        }
        if (l1 != null) {
            cur.next = l1;
        }else{
            cur.next = l2;
        }
        return head.next;
    }

    /**
     * 反转链表
     * 三个指针，保存前中后三个点
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur, pre = null, next;
        cur = head;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 第二遍
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur, pre = null, next;
        cur = head;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 快慢指针，快指针和慢指针，快的每次多走一步，如果相遇则有环，没有相遇到null，则说明有结尾，说明不是环
     */
    public boolean isCircle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head.next;
        ListNode low = head;
        while (fast != null && low != null) {
            if (fast == low) {
                return true;
            }
            fast = fast.next;
            low = low.next;
            if (fast != null) {
                fast = fast.next;
            } else {
                return false;
            }
        }
        return false;
    }


    class ListNode {
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
        }
    }
}
