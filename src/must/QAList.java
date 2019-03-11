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

    /**
     * 反转链表
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
        return cur;
    }

    public ListNode reverseList2(ListNode head) {
        if(head == null||head.next==null){
            return head;
        }
        ListNode reNode=reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return reNode;
    }


    class ListNode{
        int data;
        ListNode next;

        public ListNode(int data){
            this.data = data;
        }
    }
}
