package 链表;

public class ListNode {
	public int val;
	public ListNode next;
	public ListNode(int x)
	{
		val = x;
	}

	public static ListNode creatListNode(int[] nums) {
		ListNode node = new ListNode(-1);
		ListNode head = node;
		for (int num : nums) {
			ListNode subNode = new ListNode(num);
			node.next = subNode;
			node = node.next;
		}
		return head.next;
	}
	// 7777
	public static void logNode(ListNode head) {
		System.out.print("[");
		if (head == null) {
			System.out.println("]");
			return;
		}
		while (head.next != null) {
			System.out.print(head.val);
			System.out.print("_");
//			if (head.next.next != null) {

//			}
			head = head.next;
		}
		System.out.println("]");
	}
}
