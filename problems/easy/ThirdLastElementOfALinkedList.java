
public class ThirdLastElementOfALinkedList {

	private static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
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

	public static ListNode last(ListNode head, int n) {

		ListNode current = head;
		ListNode nLast = null;

		int i = 0;


		while (current != null) {

			if (n == i) {
				nLast = head;
			}

			if (i > n) {
				nLast = nLast.next;
			}

			current = current.next;
			++i;
		}

		return nLast;
	}

	public static void main(String args[]) {

		{
			ListNode newList = add(null, 1);
			System.out.println("List " + printList(newList));

			ListNode last = last(newList, 2);

			System.out.println("Return " + (last == null ? "none" : last.val));
		}

		{
			ListNode newList = add(null, 6);
			newList = add(newList, 7);
			newList = add(newList, 0);
			newList = add(newList, 6);
			newList = add(newList, 9);
			newList = add(newList, 6);
			newList = add(newList, 6);
			newList = add(newList, 6);
			newList = add(newList, 4);
			newList = add(newList, 6);
			newList = add(newList, 6);
			System.out.println("List " + printList(newList));

			ListNode last = last(newList, 2);

			System.out.println("Return " + (last == null ? "none" : last.val));

		}

	}
}