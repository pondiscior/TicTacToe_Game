package com.collabera.tictactoe;

public class Tictactoe {
	private String[][] board;
	private static final int ROWS = 3;
	private static final int COLS = 3;
	private String regex = "\\s{3}";

	public Tictactoe() {
		board = new String[ROWS][COLS];
	}

	public void initializeBoard() {
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				board[i][j] = "   ";
			}
		}
	}
	
	public boolean checkSpace(int a,int b) {
		return board[a][b].equals("   ");
	}

	public void setPlay(int i, int j, String player) {
		if (this.board[i][j].matches(regex))
			board[i][j] = " " + player + " ";

	}

	public boolean isGameOver() {

		for (int i = 0; i < ROWS; i++) {
			if (!board[i][0].matches(regex) && board[i][0].equals(board[i][1]) && board[i][1].equals(board[i][2])) {
				return true;
			}

			for (int j = 0; j < COLS; j++) {
				if (!board[0][j].matches(regex) && board[0][j].equals(board[1][j]) && board[1][j].equals(board[2][j]))
					return true;
			}
		}
		if (!board[0][0].matches(regex) && board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]))
			return true;
		if (!board[0][2].matches(regex) && board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0]))
			return true;
		return false;
	}

	public String printBoard() {
		String strBoard = "";
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				if (j != COLS - 1)
					strBoard += board[i][j] + "|";
				else
					strBoard += board[i][j];
			}
			if (i != COLS - 1)
				strBoard += "\n---+---+---\n";

		}
		return strBoard;
	}

}
