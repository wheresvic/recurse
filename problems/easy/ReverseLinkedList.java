
public class ReverseLinkedList {

	private static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}

	private static ListNode createList(int num) {

		if (num == 0) {
			return null;
		}

		ListNode head = new ListNode(0);

		if (num > 1) {
			ListNode current = head;

			for (int i = 1; i < num; ++i) {

				ListNode n = new ListNode(i);

				current.next = n;
				current = current.next;
			}
		}

		return head;
	}

	private static String printList(ListNode node) {

		String ret = "";

		ListNode current = node;

		while (current != null) {
			ret += current.val + " ";
			current = current.next;
		}

		return ret;

	}

	public static ListNode reverseList(ListNode head) {

		ListNode prev = null;
		ListNode current = head;

		while (current != null) {

			ListNode temp = current.next;
			current.next = prev;

			prev = current;
			current = temp;
		}

		return prev;
	}

	public static ListNode add(ListNode head, int num) {

		if (head == null) {
			head = new ListNode(num);
			return head;
		}

		ListNode current = head;

		while (current.next != null) {
			current = current.next;
		}

		current.next = new ListNode(num);

		return head;
	}


	public static void main(String args[]) {

		{
			ListNode oneList = createList(1);
			System.out.println("oneList : " + printList(oneList));

			ListNode r = reverseList(oneList);
			System.out.println("oneList reversed : " + printList(r));
		}

		{
			ListNode list = createList(10);
			System.out.println(printList(list));

			ListNode r = reverseList(list);
			System.out.println(printList(r));

			r = reverseList(null);
			System.out.println("Reversing null list " + printList(r));
		}

		{
			ListNode newList = add(null, 1);
			newList = add(newList, 7);
			System.out.println(printList(newList));
		}

	}

}