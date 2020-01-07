package caseDemo;

/**
 @Description 环形链表
 @Author yumigzhu
 @Date 2020/1/7 11:10
 */
//给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
//
//        为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
//
//        说明：不允许修改给定的链表。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/linked-list-cycle-ii
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class DetectCycle {
	public static void main(String[] args) {
		ListNode listNode1 = new ListNode(1);
		ListNode listNode2 = new ListNode(2);
		listNode1.next = listNode2;
		listNode2.next = listNode1;
		System.out.println(DetectCycle(listNode1));

	}

	public static ListNode DetectCycle(ListNode head) {
		ListNode quick = head;
		ListNode slow = head;
		if (slow == null || slow.next == null)
			return null;
		while (true) {
			if (quick != null && quick.next != null && quick.next.next != null) {
				quick = quick.next.next;
				slow = slow.next;
				if (slow == quick) {
					quick = head;
					while (quick != slow) {
						slow = slow.next;
						quick = quick.next;
					}
					return quick;
				}
			} else {
				return null;
			}

		}
	}

}

/**
 * listNode
 */
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}

	@Override
	public String toString() {
		return "val=" + val;

	}
}