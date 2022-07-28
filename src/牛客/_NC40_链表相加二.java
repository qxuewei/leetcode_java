package 牛客;
//https://www.nowcoder.com/practice/c56f6c70fb3f4849bc56e33ff2a50b6b?tpId=117&rp=1&ru=%2Fexam%2Foj&qru=%2Fexam%2Foj&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117&difficulty=&judgeStatus=&tags=&title=&gioEnter=menu

import 链表.ListNode;

import java.util.Stack;

public class _NC40_链表相加二 {
    public ListNode addInList(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        }
        ListNode h1 = head1;
        ListNode h2 = head2;
        Stack s1 = new Stack<>();
        while (h1 != null) {
            s1.add(h1.val);
            h1 = h1.next;
        }
        Stack<Integer> s2 = new Stack<Integer>();
        while (h2 != null) {
            s2.add(h2.val);
            h2 = h2.next;
        }
        int flag = 0;
        ListNode dummy = new ListNode(-1);
        while (!s1.isEmpty() || !s2.isEmpty() || flag > 0) {
            int cur = flag;
            if (!s1.isEmpty()) {
                Integer n1 = (Integer) s1.pop();
                cur += n1;
            }
            if (!s2.isEmpty()) {
                Integer n2 = (Integer) s2.pop();
                cur += n2;
            }
            ListNode node = new ListNode(cur % 10);
            flag = cur / 10;
            node.next = dummy.next;
            dummy.next = node;
        }
        return dummy.next;
    }
}
