package 链表;
// https://leetcode.cn/problems/merge-k-sorted-lists/?favorite=2cktkvj
public class _23_合并K个升序链表 {

    public ListNode mergeKLists20230112(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return merge20230112(lists, 0, lists.length - 1);
    }

    private ListNode merge20230112(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = (l + r) >> 1;
        return mergeTwoList20230112(merge20230112(lists, l, mid), merge20230112(lists, mid + 1, r));
    }

    private ListNode mergeTwoList20230112(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode dummy = new ListNode(-1);
        ListNode tmpD = dummy, tmp1 = l1, tmp2 = l2;
        while (tmp1 != null && tmp2 != null) {
            if (tmp1.val < tmp2.val) {
                tmpD.next = tmp1;
                tmp1 = tmp1.next;
            } else {
                tmpD.next = tmp2;
                tmp2 = tmp2.next;
            }
            tmpD = tmpD.next;
        }
        tmpD.next = tmp1 != null ? tmp1 : tmp2;
        return dummy.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode res = null;
        for (int i = 0; i < lists.length; i++) {
            res = mergeTwoList(res, lists[i]);
        }
        return res;
    }

    private ListNode mergeTwoList(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode dummy = new ListNode(-1);
        ListNode tmp1 = l1;
        ListNode tmp2 = l2;
        ListNode tmpDummy = dummy;
        while (tmp1 != null && tmp2 != null) {
            if (tmp1.val < tmp2.val) {
                tmpDummy.next = new ListNode(tmp1.val);
                tmp1 = tmp1.next;
            } else {
                tmpDummy.next = new ListNode(tmp2.val);
                tmp2 = tmp2.next;
            }
            tmpDummy = tmpDummy.next;
        }
        if (tmp1 != null) {
            tmpDummy.next = tmp1;
        } else if (tmp2 != null) {
            tmpDummy.next = tmp2;
        }
        return dummy.next;
    }
}
