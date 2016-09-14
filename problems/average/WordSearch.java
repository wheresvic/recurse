
import java.util.*;

public class WordSearch {

	private class Point {
		public final int i;
		public final int j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}

		public boolean equals(Object o) {

			if (this == o) return true;

			// instanceof takes care of null check
			if (! (o instanceof Point)) return false;

			Point p = (Point) o;

			if (p.i == this.i && p.j == this.j)
				return true;

			return false;
		}

		public String toString() {
			return i + "," + j;
		}

		public int hashCode() {
			return this.toString().hashCode();
		}
	}

	public boolean helper(char[][] board, String word, int position, int i, int j, Set<Point> history) {

		if (position == word.length()) {
			return true;
		}


		List<Point> points = new ArrayList<Point>();

		if (i - 1 >= 0) {
			points.add(new Point(i-1, j));
		}

		if (i + 1 < board.length) {
			points.add(new Point(i+1, j));
		}

		if (j - 1 >= 0) {
			points.add(new Point(i, j-1));
		}

		if (j + 1 < board[i].length) {
			points.add(new Point(i, j+1));
		}


		for (Point p : points) {

			if (!history.contains(p)) {

				if (board[p.i][p.j] == word.charAt(position)) {
					history.add(p);

					if (helper(board, word, position+1, p.i, p.j, history))
						return true;

					history.remove(p);
				}
			}
		}


		return false;
	}

	public boolean exist(char[][] board, String word) {

		int position = 0;
		Set<Point> history = new HashSet<Point>();

		for (int i = 0; i < board.length; ++i) {

			for (int j = 0; j < board[i].length; ++j) {

				if (board[i][j] == word.charAt(position)) {

					history.clear();
					history.add(new Point(i, j));

					if (helper(board, word, position+1, i, j, history)) {

						for (Point p : history) {
							System.out.print(p + " ");
						}

						return true;
					}
				}
			}
		}

		return false;
    }

    public void print(char[][] board) {

    	for (int i = 0; i < board.length; ++i) {
    		for (int j = 0; j < board[i].length; ++j) {
    			System.out.print(board[i][j]);
    		}
    		System.out.println("");
    	}

    }

	public static void main(String args[]) {

		char[][] board = { {'A', 'B', 'C', 'E'},
							{'S', 'F', 'C', 'S'},
							{'A', 'D', 'E', 'E'}
							};

		WordSearch instance = new WordSearch();

		instance.print(board);

		System.out.println("");
		System.out.println("ABCCED = " + instance.exist(board, "ABCCED"));
		System.out.println("SEE = " + instance.exist(board, "SEE"));
		System.out.println("ABCB = " + instance.exist(board, "ABCB"));
	}

}