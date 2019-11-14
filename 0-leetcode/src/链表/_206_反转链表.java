package 链表;

public class _206_反转链表 {
	
	public ListNode reverseList(ListNode head)
	{
		 if (head == null || head.next == null) return head;
		 ListNode newHeaderListNode = reverseList(head.next);
		 head.next.next = head;
		 head.next = null;
		 return newHeaderListNode;
    }
	
	 public ListNode reverseList2(ListNode head) 
	{
		if (head == null || head.next == null) return head;
		ListNode newHeaderListNode = null;
		while (head != null) {
			ListNode tempListNode = head.next;
			head.next = newHeaderListNode;
			newHeaderListNode = head;
			head = tempListNode;
		}
		return newHeaderListNode;
	}
	
}
