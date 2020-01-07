package 链表;

import java.util.HashSet;
import java.util.Set;

/*
给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。

为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。

说明：不允许修改给定的链表。

示例 1：
```
输入：head = [3,2,0,-4], pos = 1
输出：tail connects to node index 1
解释：链表中有一个环，其尾部连接到第二个节点。
```
![-w358](http://blog.image.jkxuewei.com/mweb/2019.12.25.15772410290765.15759389748685.jpg)

示例 2：
```
输入：head = [1,2], pos = 0
输出：tail connects to node index 0
解释：链表中有一个环，其尾部连接到第一个节点。
```
![-w200](http://blog.image.jkxuewei.com/mweb/2019.12.27.15774532597084.15774529796399.jpg)

示例 3：
```
输入：head = [1], pos = -1
输出：no cycle
解释：链表中没有环。
```
![-w112](http://blog.image.jkxuewei.com/mweb/2019.12.27.15774532597098.15774529950382.jpg)

进阶：
你是否可以不用额外空间解决此题？
 */

public class _142_环形链表2 {

	public ListNode detectCycle(ListNode head) 
	{
		HashSet<ListNode> set = new HashSet<ListNode>();
		ListNode tempListNode = head;
		while (tempListNode != null) {
			if (set.contains(tempListNode)) {
				return tempListNode;
			} else {
				set.add(tempListNode);
				tempListNode = tempListNode.next;
			}
		}
		return null;
    }
	
	public ListNode detectCycle2(ListNode head) 
	{
		ListNode slowListNode = head;
		ListNode fastListNode = head;
		boolean hasCycle = false;
		while (fastListNode != null && fastListNode.next != null) {
			slowListNode = slowListNode.next;
			fastListNode = fastListNode.next.next;
			if (slowListNode == fastListNode) {
				hasCycle = true;
				break;
			}
		}
		if (hasCycle) {
			fastListNode = head;
			while (slowListNode != fastListNode) {
				fastListNode = fastListNode.next;
				slowListNode = slowListNode.next;
			}
			return fastListNode;
		} else {
			return null;
		}
    }
	

}
