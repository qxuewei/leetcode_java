package 链表;

/*
删除链表中等于给定值 val 的所有节点。

示例:
```
输入: 1->2->6->3->4->5->6, val = 6
输出: 1->2->3->4->5
```
 */

public class _203_移除链表元素 {
	public ListNode removeElements(ListNode head, int val) 
	{
		if (head == null) {
			return head;
		}
		ListNode newHeadListNode = new ListNode(-1);
		newHeadListNode.next = head;
		ListNode tempListNode = head;
		while (tempListNode != null) {
			
			tempListNode = tempListNode.next;
		}
		return newHeadListNode.next;
	}

	public ListNode removeElements2(ListNode head, int val)
	{
		if (head == null) {
			return head;
		}
		head.next = removeElements2(head.next, val);
		if (head.val == val) {
			return head.next;
		} else {
			return head;
		}
	}
}
