package 剑指Offer;

import 链表.ListNode;

/**
 * @author 邱学伟
 * @version V1.0
 * @Package 剑指Offer
 * @date 2020/11/13 下午3:12
 */
public class _24_反转链表 {
    /**
     * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
     *
     *  
     *
     * 示例:
     *
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     *  
     *
     * 限制：
     *
     * 0 <= 节点个数 <= 5000
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

//    public ListNode reverseList(ListNode head) {
//        if (head == null || head.next == null) return head;
//        ListNode newHeader = reverseList(head.next);
//        head.next.next = head;
//        head.next = null;
//        return newHeader;
//    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHeader = null;
        ListNode node = head;
        while (node != null) {
            ListNode temp = node.next;
            node.next = newHeader;
            newHeader = node;
            node = temp;
        }
        return newHeader;
    }
}
