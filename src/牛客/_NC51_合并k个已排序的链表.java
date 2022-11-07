package 牛客;

import 链表.ListNode;

import java.util.ArrayList;

// https://www.nowcoder.com/practice/65cfde9e5b9b4cf2b6bafa5f3ef33fa6?tpId=117&tqId=37747&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117&difficulty=undefined&judgeStatus=undefined&tags=&title=
public class _NC51_合并k个已排序的链表 {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        return divideList(lists, 0, lists.size() - 1);
    }

    private ListNode divideList(ArrayList<ListNode> lists, int left, int right) {
        if (left > right) {
            return null;
        } else if (left == right) {
            return lists.get(left);
        }
        int mid = (left + right) / 2;
        return mergeTwo(divideList(lists, left, mid), divideList(lists,mid + 1, right));
    }

    private ListNode mergeTwo(ListNode listNode1, ListNode listNode2) {
        if (listNode1 == null) {
            return listNode2;
        }
        if (listNode2 == null) {
            return listNode1;
        }
        ListNode head = new ListNode(-1);
        ListNode curHead = head;
        while (listNode1 != null && listNode2 != null) {
            if (listNode1.val < listNode2.val) {
                curHead.next = listNode1;
                listNode1 = listNode1.next;
            } else {
                curHead.next = listNode2;
                listNode2 = listNode2.next;
            }
            curHead = curHead.next;
        }
        if (listNode1 != null) {
            curHead.next = listNode1;
        } else if (listNode2 != null) {
            curHead.next = listNode2;
        }
        return head.next;
    }
}
