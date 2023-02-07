package 链表;

import java.util.HashSet;
import java.util.Set;

/*
 给定一个链表，判断链表中是否有环。

为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。

示例 1：
```
输入：head = [3,2,0,-4], pos = 1
输出：true
解释：链表中有一个环，其尾部连接到第二个节点。
```
![-w358](http://blog.image.jkxuewei.com/mweb/2019.12.25.15772410290765.15759389748685.jpg)

示例 2：
```
输入：head = [1,2], pos = 0
输出：true
解释：链表中有一个环，其尾部连接到第一个节点。
```
![-w200](http://blog.image.jkxuewei.com/mweb/2019.12.27.15774532597084.15774529796399.jpg)

示例 3：
```
输入：head = [1], pos = -1
输出：false
解释：链表中没有环。
```
![-w112](http://blog.image.jkxuewei.com/mweb/2019.12.27.15774532597098.15774529950382.jpg)

进阶：
你能用 O(1)（即，常量）内存解决此问题吗？
 */

public class _141_环形链表 {

	public boolean hasCycle20221228(ListNode head) {
		if (head == null || head.next == null) {
			return false;
		}
		ListNode slow = head;
		ListNode fast = head.next;
		while (fast != null && fast.next != null) {
			if (slow == fast) {
				return true;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		return false;
	}
	
//	public boolean hasCycle(ListNode head)
//	{
//		if (head == null || head.next == null) return false;
//		ListNode slowListNode = head;
//		ListNode fastListNode = head.next;
//		while (fastListNode != null && fastListNode.next != null) {
//			slowListNode = slowListNode.next;
//			fastListNode = fastListNode.next.next;
//			if (slowListNode == fastListNode) return true;
//		}
//		return false;
//	}
//	
//	public boolean hasCycle2(ListNode head) {
//		if (head == null || head.next == null) return false;
//		Set<ListNode> set = new HashSet<ListNode>();
//		while (head != null) {
//			if (set.contains(head)) {
//				return true;
//			} else {
//				set.add(head);
//			}
//			head = head.next;
//		}
//		return false;
//	}

	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null)
			return false;
		ListNode s = head;
		ListNode f = head.next;
		while (f != null && f.next != null) {
			if (s == f)
				return true;
			s = s.next;
			f = f.next.next;
		}
		return false;
	}

	public boolean hasCycle2(ListNode head) 
	{
		if (head == null || head.next == null) 
			return false;
		Set<ListNode> set = new HashSet<ListNode>();
		while (head != null) {
			if (set.contains(head)) {
				return true;
			} else {
				set.add(head);
			}
			head = head.next;
		}
		return false;
	}

	public boolean hasCycle3(ListNode head) {
		if (head == null || head.next == null) {
			return false;
		}
		ListNode fast = head.next;
		ListNode slow = head;
		while (fast != null && fast.next != null) {
			if (fast == slow) {
				return true;
			}
			fast = fast.next.next;
			slow = slow.next;
		}
		return false;
	}
}
