package 牛客;

/*
描述
将给出的链表中的节点每 k 个一组翻转，返回翻转后的链表
如果链表中的节点数不是 k 的倍数，将最后剩下的节点保持原样
你不能更改节点中的值，只能更改节点本身。

数据范围： \ 0 \le n \le 2000 0≤n≤2000 ， 1 \le k \le 20001≤k≤2000 ，链表中每个元素都满足 0 \le val \le 10000≤val≤1000
要求空间复杂度 O(1)O(1)，时间复杂度 O(n)O(n)
例如：
给定的链表是 1\to2\to3\to4\to51→2→3→4→5
对于 k = 2k=2 , 你应该返回 2\to 1\to 4\to 3\to 52→1→4→3→5
对于 k = 3k=3 , 你应该返回 3\to2 \to1 \to 4\to 53→2→1→4→5

示例1
输入：
{1,2,3,4,5},2
复制
返回值：
{2,1,4,3,5}
复制
示例2
输入：
{},1
复制
返回值：
{}
https://www.nowcoder.com/practice/b49c3dc907814e9bbfa8437c251b028e?tpId=117&tags=&title=&difficulty=&judgeStatus=&rp=1&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117&gioEnter=menu
 */

import 链表.ListNode;

public class _NC50_链表中的节点每k个一组翻转 {
    /**
     *
     * @param head ListNode类  1-2-3-4  2   2-1-4-3
     * @param k int整型
     * @return ListNode类
     */
    public ListNode reverseKGroup (ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = dummy;
        while (end.next != null) {
            // 先确定区间 pre - end
            for (int i = 0; i < k; i++) {
                if (end == null) {
                    break;
                }
                end = end.next;
            }
            if (end == null) {
                break;
            }
            // 交换
            ListNode start = pre.next;
            ListNode next = end.next;
            // 断开链表
            end.next = null;
            // 翻转子串
            ListNode sub = reverse(start);
            pre.next = sub;
            start.next = next;
            pre = start;
            end = start;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newhead = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = newhead;
            newhead = cur;
            cur = next;
        }
        return newhead;
    }
}
