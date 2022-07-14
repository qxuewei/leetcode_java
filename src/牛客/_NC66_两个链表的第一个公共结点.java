package 牛客;

/*
https://www.nowcoder.com/practice/6ab1d9a29e88450685099d45c9e31e46?tpId=117&tqId=37761&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117&difficulty=undefined&judgeStatus=undefined&tags=&title=
 */

import 链表.ListNode;

import java.util.HashSet;

public class _NC66_两个链表的第一个公共结点 {
    public ListNode commonNode(ListNode pHead1, ListNode pHead2) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode p1 = pHead1;
        while (p1 != null) {
            set.add(p1);
            p1 = p1.next;
        }
        ListNode p2 = pHead2;
        while (p2 != null) {
            if (set.contains(p2)) {
                break;
            }
            p2 = p2.next;
        }
        return p2;
    }

    public ListNode commonNode2(ListNode pHead1, ListNode pHead2) {
        ListNode l1 = pHead1;
        ListNode l2 = pHead2;
        while (l1 != l2) {
            l1 = l1 == null ? pHead2 : l1.next;
            l2 = l2 == null ? pHead1 : l2.next;
        }
        return l1;
    }
}
