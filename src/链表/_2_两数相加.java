package 链表;
// https://leetcode.cn/problems/add-two-numbers/description/?favorite=2cktkvj
public class _2_两数相加 {
    // [2,4,9]  [5,6,4,9]  - [7,0,4,0,1]
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode pre = new ListNode(-1);
        ListNode cur = pre;
        int carry = 0;
        int sum = 0;
        int n1 = 0;
        int n2 = 0;
        while (l1 != null || l2 != null) {
            n1 = l1 != null ? l1.val : 0;
            n2 = l2 != null ? l2.val : 0;
            sum = n1 + n2 + carry;
            cur.next = new ListNode(sum % 10);
            carry = sum / 10;
            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry != 0) {
            cur.next = new ListNode(carry % 10);
        }
        return pre.next;
    }

    public static void main(String[] args) {
        int[] array1 = {2, 4, 3};
        int[] array2 = {5, 6, 4};
        ListNode l1 = ListNode.creatListNode(array1);
        ListNode l2 = ListNode.creatListNode(array2);
        System.out.println(addTwoNumbers(l1, l2));
    }
}
