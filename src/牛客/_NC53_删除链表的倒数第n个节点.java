package 牛客;

/*
给定一个链表，删除链表的倒数第 n 个节点并返回链表的头指针
例如，
给出的链表为: 1\to 2\to 3\to 4\to 51→2→3→4→5, n= 2n=2.
删除了链表的倒数第 nn 个节点之后,链表变为1\to 2\to 3\to 51→2→3→5.

数据范围： 链表长度 0\le n \le 10000≤n≤1000，链表中任意节点的值满足 0 \le val \le 1000≤val≤100
要求：空间复杂度 O(1)O(1)，时间复杂度 O(n)O(n)
备注：
题目保证 nn 一定是有效的
示例1
输入：
{1,2},2
复制
返回值：
{2}

https://www.nowcoder.com/practice/f95dcdafbde44b22a6d741baf71653f6?tpId=117&rp=1&ru=%2Fexam%2Foj&qru=%2Fexam%2Foj&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117&difficulty=&judgeStatus=&tags=&title=&gioEnter=menu
 */

import 链表.ListNode;

public class _NC53_删除链表的倒数第n个节点 {

    /*
    找到倒数第 n 个，快指针前进n，
     */
    public ListNode deleteNode(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode temp = dummy;
        for (int i = 0; i < n; i++) {
            temp = temp.next;
        }
        ListNode deleteDummy = dummy;
        while (temp.next != null) {
            temp = temp.next;
            deleteDummy = deleteDummy.next;
        }
        deleteDummy.next = deleteDummy.next.next;
        return dummy.next;
    }

}
