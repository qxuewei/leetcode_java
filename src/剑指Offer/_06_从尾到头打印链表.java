package 剑指Offer;

import 链表.ListNode;

import java.util.Stack;

public class _06_从尾到头打印链表 {
    /**
     * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：head = [1,3,2]
     * 输出：[2,3,1]
     *  
     *
     * 限制：
     *
     * 0 <= 链表长度 <= 10000
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack();
        ListNode tmp = head;
        while (tmp != null) {
            stack.push(tmp.val);
            tmp = tmp.next;
        }

        int size = stack.size();
        int [] array = new int[size];
        int idx = 0;
        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            array[idx++] = pop;
        }
        return array;
    }

}
