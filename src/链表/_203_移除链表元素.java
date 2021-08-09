package 链表;

/**
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * 示例 2：
 *
 * 输入：head = [], val = 1
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 *  
 *
 * 提示：
 *
 * 列表中的节点数目在范围 [0, 104] 内
 * 1 <= Node.val <= 50
 * 0 <= val <= 50
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-linked-list-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class _203_移除链表元素 {

	public static void main(String[] args) {
		int[] nums = {1,2,6,3,4,5,6};
		int[] nums1 = {7,7,7,7};
		ListNode node = ListNode.creatListNode(nums1);
		ListNode.logNode(node);
		int val = 7;
		ListNode res = removeElements1(node, val);
		ListNode.logNode(res);
	}

	public static ListNode removeElements1(ListNode head, int val) {
		if (head == null) {
			return null;
		}
		ListNode newNode = new ListNode(-1);
		newNode.next = head;
		ListNode temp = newNode;
		while (temp.next != null) {
			if (temp.next.val == val) {
				temp.next = temp.next.next;
			} else {
				temp = temp.next;
			}
		}
		return newNode.next;
	}


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
