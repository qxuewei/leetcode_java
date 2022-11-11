package 牛客;

import 链表.ListNode;

// https://www.nowcoder.com/practice/f23604257af94d939848729b1a5cda08?tpId=117&tqId=37817&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117&difficulty=undefined&judgeStatus=undefined&tags=&title=
public class _NC70_单链表的排序 {
    // [1,3,2,4,5]
    public ListNode sortInList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 分成两段排序， 排序后合并在一起
        ListNode left = head;
        ListNode mid = head.next;
        ListNode right = head.next.next;
        while (right != null && right.next != null) {
            left = left.next;
            mid = mid.next;
            right = right.next.next;
        }
        left.next = null;
        return merge(sortInList(head), sortInList(mid));
    }

    // 合并两个有序链表
    private ListNode merge(ListNode left, ListNode right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        ListNode dummy = new ListNode(-1);
        ListNode tmpDummy = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                tmpDummy.next = left;
                left = left.next;
            } else {
                tmpDummy.next = right;
                right = right.next;
            }
            tmpDummy = tmpDummy.next;
        }
        if (left != null) {
            tmpDummy.next = left;
        } else if (right != null) {
            tmpDummy.next = right;
        }
        return dummy.next;
    }
}
