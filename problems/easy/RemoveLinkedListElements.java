
public class RemoveLinkedListElements {

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


	public static ListNode removeElements(ListNode head, int val) {

		if (head == null) {
			return null;
		}

		while (head != null && head.val == val) {
			head = head.next;
		}

		if (head == null) {
			return null;
		}

        ListNode current = head.next;
        ListNode prev = head;

        while (current != null) {

        	if (current.val == val) {
        		prev.next = current.next;
        	} else {
        		prev = current;
        	}

        	current = current.next;

        }

        return head;
    }


	public static void main(String args[]) {

		{
			ListNode newList = add(null, 1);
			System.out.println(printList(newList));
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
			System.out.println(printList(newList));

			newList = removeElements(newList, 6);
			System.out.println(printList(newList));

		}

	}

}