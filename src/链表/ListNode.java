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

	public static void logNode(ListNode head) {
		System.out.print("[");
		if (head == null) {
			System.out.println("]");
			return;
		}
		while (head != null) {
			System.out.print(head.val);
			head = head.next;
			if (head != null) {
				System.out.print("_");
			}
		}
		System.out.println("]");
	}
}
