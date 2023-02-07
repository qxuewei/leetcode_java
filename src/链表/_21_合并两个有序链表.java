package 链表;

/*
将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

示例：
```
输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
```
 */

public class _21_合并两个有序链表 {

	public ListNode mergeTwoLists20221202_1(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		} else if (l2 == null) {
			return l1;
		} else if (l1.val < l2.val) {
			l1.next = mergeTwoLists20221202_1(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoLists20221202_1(l1, l2.next);
			return l2;
		}
	}

	public ListNode mergeTwoLists20221202(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		} else if (l2 == null) {
			return l1;
		}
		ListNode dummyRes = new ListNode(-1);
		ListNode dummy = dummyRes;
		while (l1 != null || l2 != null) {
			if (l1 != null && l2 != null) {
				if (l1.val < l2.val) {
					dummy.next = new ListNode(l1.val);
					l1 = l1.next;
				} else {
					dummy.next = new ListNode(l2.val);
					l2 = l2.next;
				}
			} else if (l1 != null) {
				dummy.next = new ListNode(l1.val);
				l1 = l1.next;
			} else {
				dummy.next = new ListNode(l2.val);
				l2 = l2.next;
			}
			dummy = dummy.next;
		}
		return dummyRes.next;
	}




	/// 递归
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) 
	{
		if (l1 == null) {
			return l2;
		} else if (l2 == null) {
			return l1;
		} else if (l1.val < l2.val) {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoLists(l2.next, l1);
			return l2;
		}
    }
	
	/// 迭代
	public ListNode mergeTwoLists2(ListNode l1, ListNode l2)
	{
		ListNode head = new ListNode(-1);
		ListNode tempListNode = head;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				tempListNode.next = l1;
				l1 = l1.next;
			} else {
				tempListNode.next = l2;
				l2 = l2.next;
			}
			tempListNode = tempListNode.next;
		}
		tempListNode.next = l1 == null ? l2 : l1;
		return head.next;
	}
}
