package 剑指Offer;

import 链表.ListNode;

import java.util.ArrayList;

/**
 * @author 邱学伟
 * @version V1.0
 * @Package 剑指Offer
 * @date 2020/11/20 下午5:59
 */
public class _25_合并两个排序的链表 {
    /**
     * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
     *
     * 示例1：
     *
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     * 限制：
     *
     * 0 <= 链表长度 <= 1000
     *
     *
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ArrayList<Integer> list = new ArrayList<>();
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                list.add(l1.val);
                l1 = l1.next;
            } else {
                list.add(l2.val);
                l2 = l2.next;
            }
        }
        while (l1 != null) {
            list.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            list.add(l2.val);
            l2 = l2.next;
        }
        ListNode head = new ListNode(-1);
        ListNode h = head;
        for (Integer integer : list) {
            head.next = new ListNode(integer);
            head = head.next;
        }
        return h.next;
    }
}
