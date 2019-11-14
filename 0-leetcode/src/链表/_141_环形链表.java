package 链表;

public class _141_环形链表 {
	
	public boolean hasCycle(ListNode head)
	{
		if (head == null || head.next == null) return false;
		ListNode slowListNode = head;
		ListNode fastListNode = head.next;
		while (fastListNode != null && fastListNode.next != null) {
			slowListNode = slowListNode.next;
			fastListNode = fastListNode.next.next;
			if (slowListNode == fastListNode) return true;
		}
		return false;
	}

}
