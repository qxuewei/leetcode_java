package 链表;

// https://leetcode.cn/problems/reverse-linked-list/?favorite=2cktkvj
public class _206_反转链表 {
	public ListNode reverseList20221123_2(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode res = null;
		ListNode next = null;
		while (head != null) {
			next = head.next;
			head.next = res;
			res = head;
			head = next;
		}
		return res;
	}

	public ListNode reverseList20221123(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode res = reverseList20221123(head.next);
		head.next.next = head;
		head.next = null;
		return res;
	}

	/**
	 *
	 * 反转一个单链表。
	 * 示例:
	 * ```
	 * 输入: 1->2->3->4->5->NULL
	 * 输出: 5->4->3->2->1->NULL
	 * ```
	 * 进阶:
	 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
	 *
	 */

	public ListNode ReverseList7(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode newHead = null;
		while (head != null) {
			ListNode next = head.next;
			head.next = newHead;
			newHead = head;
			head = next;
		}
		return newHead;
	}

	// 递归
	public ListNode ReverseList6(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode newHead = ReverseList5(head.next);
		head.next.next = head;
		head.next = null;
		return newHead;
	}

	// 迭代
	public ListNode ReverseList5(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode newHead = null;
		ListNode copyHead = head;
		while (copyHead != null) {
			ListNode nextHead = copyHead.next;
			copyHead.next = newHead;
			newHead = copyHead;
			copyHead = nextHead;
		}
		return newHead;
	}

	// 递归
	public ListNode reverseList3(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode newH = reverseList3(head.next);
		head.next.next = head;
		head.next = null;
		return newH;
	}


	// 迭代
	public ListNode reverseList4(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode newH = null;
		while (head != null) {
			ListNode next = head.next;
			head.next = newH;
			newH = head;
			head = next;
		}
		return newH;
	}





	public ListNode reverseList(ListNode head)
	{
		if (head == null || head.next == null) return head;
		ListNode newHead = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return newHead;
	}
	
	public ListNode reverseList2(ListNode head)
	{
		if (head == null || head.next == null) return head;
		ListNode newHeadNode = null;
		while (head != null) {
			ListNode tempListNode = head.next;
			head.next = newHeadNode;
			newHeadNode = head;
			head = tempListNode;
		}
		return newHeadNode;
	}


}
