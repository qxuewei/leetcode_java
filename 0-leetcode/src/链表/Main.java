package 链表;

public class Main {
	private static ListNode creatListNode(int count) 
	{
		ListNode node = new ListNode(0);
		ListNode head = node;
		for (int i = 1; i < count; i++) {
			ListNode node2 = new ListNode(i);
			node.next = node2;
			node = node2;
		}
		node.next = null;
		return head;
	}

	private static void logNode(ListNode head)
	{
		System.out.print("[");
		while (head.next != null) {
			System.out.print(head.val);
			System.out.print("_");
			System.out.print(head.next);
			head = head.next;
		}
	}
	
	static void test206() {
		ListNode node = creatListNode(5);
		logNode(node);
		_206_反转链表 test = new _206_反转链表();
		node = test.reverseList(node);
		logNode(node);
	}

	public static void main(String[] args) {
		test206();
	}

}
