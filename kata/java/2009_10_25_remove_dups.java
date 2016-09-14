import java.io.*;
import java.util.*;

class remove_dups {

	public static void main(String args[]) {

		System.out.println ("Removing duplicates from " + args[0]);

		HashMap h = new HashMap();

		for (int i=0; i<args[0].length(); i++) {
			char c = args[0].charAt(i);
			if (!h.containsKey(c)) {
				h.put(c, i);
				System.out.println(c);
			} 
		}	

		/*
		Iterator iterator = h.keySet().iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		*/

	}

}
