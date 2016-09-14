
import java.util.*;

/**
 * Note: this is incorrect
 */
public class DecodeWays {

	public int combos(char prev, char current) {

		int count = 0;

		// TODO: evaluate this check for invalidity
		if (current == '0' && prev >= '3')
			return -1;

		if (current >= '1' && current <= '9') {
			++count;
		}

		if (prev == '1' && current >= '0' && current <= '9')
			++count;

		if (prev == '2' && current >= '0' && current <= '6')
			++count;

		return count;
	}

	public int numDecodings(String s) {

		int len = s.length();

		if (len == 0) {
			return len;
		}

		if (len == 1) {
			return combos('x', s.charAt(0));
		}

		int decodings[] = new int[len];

		char prev = s.charAt(0);

		decodings[0] = combos('x', prev);

		for (int i = 1; i < len; ++i) {

			if (i == 1) {
				decodings[i] = combos(prev, s.charAt(i));
			} else {
				decodings[i] = decodings[i - 1] + combos(prev, s.charAt(i));
			}

			prev = s.charAt(i);

		}

		for (int i = 0; i < len; ++i) {
			System.out.print(decodings[i] + " ");
		}
		System.out.println("");

		return decodings[len - 1];
    }

	public static void main(String args[]) {

		String s1 = "123403";
		String s2 = "123"; // 4
		String s3 = "120"; // 3

		DecodeWays instance = new DecodeWays();

		System.out.println(s1 + " " + instance.numDecodings(s1));
		System.out.println(s2 + " " + instance.numDecodings(s2));
		System.out.println(s3 + " " + instance.numDecodings(s3));

	}

}