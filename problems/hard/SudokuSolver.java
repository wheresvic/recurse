
import java.util.*;

public class SudokuSolver {

	// TODO: improve this to pick the most constrained spot
	public int[] getNextEmptySpot(char[][] board, int i, int j) {

		int indexes[] = new int[2];

		for (int a = 0; a < board.length; ++a) {
			for (int b = 0; b < board[a].length; ++b) {
				if (board[a][b] == '.') {
					indexes[0] = a;
					indexes[1] = b;

					return indexes;
				}
			}
		}

		return indexes;
	}

	public Set<Character> getPotentials(char[][] board, int i, int j) {

		Set<Character> avail = new HashSet<Character>();

		for (char c = '1'; c <= '9'; ++c) {
			avail.add(c);
		}

		for (int x = 0; x < board.length; ++x) {

			if (x == i)
				continue;

			avail.remove(board[x][j]);
		}

		for (int y = 0; y < board.length; ++y) {

			if (y == j)
				continue;

			avail.remove(board[i][y]);
		}

		i = i - (i%3);
		j = j - (j%3);

		for (int a = i; a < i+3; ++a) {
			for (int b = j; b < j + 3; ++b) {
				// System.out.println(a + " " + b + " " + board[a][b]);
				avail.remove(board[a][b]);
			}
		}

		return avail;
	}

	public String getAvail(Set<Character> avail) {

		String ret = "";

		for (Character c : avail) {
			ret += c + ",";
		}

		return ret;
	}

	public boolean solveSudokuHelper(char[][] board, int i, int j, int numSpaces) {

		// loop through all the possible numbers for this spot
		// if any one of them leads to a true state we return true to stop the looping

		Set<Character> avail = getPotentials(board, i, j);

		System.out.println(getAvail(avail) + " " + i + " " + j + " " + numSpaces);

		for (Character c : avail) {

			board[i][j] = c;

			// if there was only 1 space left and we filled it up
			if (numSpaces == 1) {
				return true;
			}

			// find next empty spot,
			int indexes[] = getNextEmptySpot(board, i, j);
			int a = indexes[0];
			int b = indexes[1];

			// if we could solve it then skip the rest
			if (solveSudokuHelper(board, a, b, numSpaces - 1))
				return true;

		}

		board[i][j] = '.';

		return false;
	}

	public void solveSudoku(char[][] board) {

		int numSpaces = checkBoard(board);
		int indexes[] = getNextEmptySpot(board, 0, 0);

		boolean result = solveSudokuHelper(board, indexes[0], indexes[1], numSpaces);

		System.out.println(result);

	}

	public void printBoard(char[][] board) {

		for (int i = 0; i < board.length; ++i) {

			for (int j = 0; j < board[i].length; ++j) {

				System.out.print(board[i][j] + "  ");

			}

			System.out.println("");
		}

	}

	/**
	 * Returns the number of empty spots
	 */
	public int checkBoard(char[][] board) {

		int empty = 0;

		for (int i = 0; i < board.length; ++i) {
			for (int j = 0; j < board[i].length; ++j) {
				if (board[i][j] == '.') {
					++empty;
				}
			}
		}

		return empty;
	}

	public void sampleBoard1(char[][] board) {

		board[0][0] = '5';
		board[0][1] = '3';
		board[0][4] = '7';

		board[1][0] = '6';
		board[1][3] = '1';
		board[1][4] = '9';
		board[1][5] = '5';

		board[2][1] = '9';
		board[2][2] = '8';
		board[2][7] = '6';

		board[3][0] = '8';
		board[3][4] = '6';
		board[3][8] = '3';

		board[4][0] = '4';
		board[4][3] = '8';
		board[4][5] = '3';
		board[4][8] = '1';

		board[5][0] = '7';
		board[5][4] = '2';
		board[5][8] = '6';

		board[6][1] = '6';
		board[6][6] = '2';
		board[6][7] = '8';

		board[7][3] = '4';
		board[7][4] = '1';
		board[7][5] = '9';
		board[7][8] = '5';

		board[8][4] = '8';
		board[8][7] = '7';
		board[8][8] = '9';

	}

	public static void main(String args[]) {

		char[][] board = new char[9][9];

		for (int i = 0; i < board.length; ++i) {
			for (int j = 0; j < board[i].length; ++j) {
				board[i][j] = '.';
			}
		}

		SudokuSolver instance = new SudokuSolver();

		instance.sampleBoard1(board);

		instance.printBoard(board);

		System.out.println("");

		instance.solveSudoku(board);

		System.out.println("");

		instance.printBoard(board);

	}

}