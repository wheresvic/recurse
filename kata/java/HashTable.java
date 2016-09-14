import java.util.*;

/**
 * Simple Hashtable implementation
 *
 * Read: http://en.wikipedia.org/wiki/Hash_table
 * Cuckoo hashing and 2-function hashing are very interesting :)
 *
 * Points to consider
 * - If all keys are known ahead of time, a perfect hash function can be used to create a perfect hash table that has no collisions :)
 * - what is the ideal initial size of the index? (all possible key values, i.e. sparse array or a subset)
 * - would you grow and shrink to maintain performance?
 * - what makes a good hash function?
 *
 */
public class HashTable {

	private static interface Hashable {
		public int hashCode();
	}

	private static class Entry<K extends Hashable, V> {

		private K key;
		private V value;

		public Entry(K key, V value) {

			if (key == null || value == null) {
				throw new RuntimeException("wtf");
			}

			this.key = key;
			this.value = value;
		}

		public K getKey() {
			return key;
		}

		public V getValue() {
			return value;
		}

		public void setValue(V value) {
			this.value = value;
		}

	}

	private static class HTable<K extends Hashable, V> {

		// lock to 100 for basic implementation
		private List<List<Entry<K, V>>> index = new ArrayList<List<Entry<K, V>>>(100);

		public HTable() {

			for (int i = 0; i < 100; ++i) {
				List<Entry<K, V>> list = new ArrayList<Entry<K, V>>();
				index.add(list);
			}

		}

		public V get(K key) {

			List<Entry<K, V>> list = index.get(key.hashCode());

			for (Entry<K, V> entry : list) {
				if (entry.getKey().equals(key)) {
					return entry.getValue();
				}
			}

			return null;
		}

		public void put(K key, V value) {

			int code = key.hashCode();

			List<Entry<K, V>> list = index.get(key.hashCode());

			boolean added = false;

			for (Entry<K, V> entry : list) {
				if (entry.getKey().equals(key)) {
					entry.setValue(value);
					added = true;
					break;
				}
			}

			if (!added) {
				Entry<K, V> entry = new Entry<K, V>(key, value);
				list.add(entry);
			}

			System.out.println(code + " " + list.size());

			return;
		}
	}

	private static class HashableString implements Hashable {

		private String s;

		public HashableString(String s) {

			if (s == null || s.isEmpty())
				throw new RuntimeException("null string :(");

			this.s = s;
		}

		public int hashCode() {
			// worst hash function award goes to
			return s.length() % 100;
		}

		public boolean equals(Object obj) {

			if (obj == null) {
				return false;
			}

			if (!(obj instanceof HashableString)) {
				return false;
			}

			HashableString t = (HashableString) obj;

			return s.equals(t.s);
		}
	}

	public static void main(String args[]) {

		HashableString l2a = new HashableString("ab");
		HashableString l2b = new HashableString("cd");

		HTable<HashableString, String> table = new HTable<HashableString, String>();

		table.put(l2a, "l2a");
		table.put(l2b, "l2b");

		System.out.println(table.get(l2a) + " " + table.get(l2b));

		table.put(l2b, "snoop");

		System.out.println(table.get(l2a) + " " + table.get(l2b));


	}

}

