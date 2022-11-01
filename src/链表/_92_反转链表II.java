package 链表;
// https://leetcode.cn/problems/reverse-linked-list-ii/
public class _92_反转链表II {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        ListNode rightNode = pre;
        int length = right - left + 1;
        for (int i = 0; i < length; i++) {
            rightNode = rightNode.next;
        }

        ListNode leftNode = pre.next;
        ListNode cur = rightNode.next;

        pre.next = null;
        rightNode.next = null;

        reverce(leftNode);

        leftNode.next = cur;
        pre.next = rightNode;

        return dummy.next;
    }
    private ListNode reverce(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = null;
        ListNode tmp = null;
        while (head != null) {
            tmp = head.next;
            head.next = newHead;
            newHead = head;
            head = tmp;
        }
        return newHead;
    }
}
