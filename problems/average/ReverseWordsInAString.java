
import java.util.*;

public class ReverseWordsInAString {

	public String reverseWords(String s) {

		int len = s.length();
		int count = 0;

		if (len == 0) {
			return "";
		}

		Stack<Character> stack = new Stack<Character>();

        StringBuilder sb = new StringBuilder(len);

        for (int i = len - 1; i >= 0; --i) {

        	char c = s.charAt(i);

        	if (c == ' ') {

        		if (!stack.isEmpty()) {

        			while (!stack.isEmpty()) {
	        			sb.append(stack.pop());
	        			++count;
	        		}

	        		sb.append(c);
	        		++count;
        		}

        	} else {
        		stack.push(c);
        	}
        }

        while (!stack.isEmpty()) {
			sb.append(stack.pop());
			++count;
		}

		if (count > 0 && sb.charAt(count - 1) == ' ') {
			sb.deleteCharAt(count - 1);
		}

		return sb.toString();
    }

	public static void main(String args[]) {

		ReverseWordsInAString instance = new ReverseWordsInAString();

		String s1 = "the sky is blue";
		String s2 = " the sky is   blue ";

		System.out.println(s1 + ".");
		System.out.println(instance.reverseWords(s1) + ".");
		System.out.println(s2 + ".");
		System.out.println(instance.reverseWords(s2) + ".");
		System.out.println("1 " + ".");
		System.out.println(instance.reverseWords("1 ") + ".");
		System.out.println(" 1" + ".");
		System.out.println(instance.reverseWords(" 1") + ".");
		System.out.println(" " + ".");
		System.out.println(instance.reverseWords(" ") + ".");
		System.out.println("     19 " + ".");
		System.out.println(instance.reverseWords("     19 ") + ".");
	}
}