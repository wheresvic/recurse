
import java.util.*;

public class GenerateParentheses {

	public boolean isValid(String partial) {

		int len = partial.length();

		if (len <= 1) {
			return false;
		}

		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < len; ++i) {

			if (partial.charAt(i) == '(') {
				stack.push('(');
			} else if (partial.charAt(i) == ')') {
				if (stack.isEmpty()) {
					return false;
				} else {
					stack.pop();
				}
			}
		}

		if (!stack.isEmpty())
			return false;

		return true;
	}

	// TODO: there is a better way to choose how to add strings rather than brute force validation
	public void helper(int n, List<String> solutions, String partial) {

		if (n == 0) {

			// System.out.println(partial);

			if (isValid(partial)) {
				solutions.add(partial);
			}

		} else {

			helper(n-1, solutions, partial + "(");
			helper(n-1, solutions, partial + ")");

		}

	}

	public List<String> generateParenthesis(int n) {

		List<String> solutions = new ArrayList<String>();

		helper(n * 2, solutions, "");

		return solutions;
    }

	public static void main(String args[]) {

		GenerateParentheses instance = new GenerateParentheses();

		List<String> solutions = instance.generateParenthesis(7);

		System.out.println(solutions.size());

		for (String sol : solutions) {
			System.out.println(sol);
		}

	}


}