package com.collabera.tictactoe;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean playing = true;
		int p1count = 0;
		int p2count = 0;
		int turncount = 0;

		do {
			Tictactoe game = new Tictactoe();
			boolean ongoing = true;
			game.initializeBoard();
			String player = "X";
			String winner = "";
			System.out.println("Type player 1 name[X]:");
			String player1 = input.nextLine();
			System.out.println("Type player 2 name[O]:");
			String player2 = input.nextLine();
			do {
				System.out.println(game.printBoard());
				if (turncount == 9) {
					System.out.println("Draw!");
					turncount = 0;
					ongoing = false;
					break;
				}
				int row;
				int col;
				do {
					row = -1;
					do {
						System.out.println("Enter coordinates for row:");
						try {
							row = Integer.parseInt(input.nextLine()) - 1;

						} catch (NumberFormatException e) {

							System.out.println("Numbers from 1-3 only");
						}
					} while (row != 0 && row != 1 && row != 2);
					col = -1;
					do {
						System.out.println("Enter coordinates for column:");
						try {
							col = Integer.parseInt(input.nextLine()) - 1;
						} catch (NumberFormatException e) {
							System.out.println("Numbers from 1-3 only");
						}
					} while (col != 0 && col != 1 && col != 2);
				} while (!game.checkSpace(row,col));
				turncount++;
				game.setPlay(row, col, player);
				if (game.isGameOver()) {
					System.out.println(game.printBoard() + "\n" + winner + " wins!");
					if (winner == player1)
						p1count++;
					else
						p2count++;
					ongoing = false;
				}
				if (player == "X") {
					player = "O";
					winner = player2;
				} else {
					player = "X";
					winner = player1;
				}

			} while (ongoing);
			System.out.println("Play again? [YES] [NO]");
			System.out.println("For win record, type [WIN]");
			do {
				String playagain = input.next();
				if (playagain.equalsIgnoreCase("yes"))
					ongoing = false;
				else if (playagain.equalsIgnoreCase("no")) {
					playing = false;
					ongoing = false;
				} else if (playagain.equalsIgnoreCase("win")) {
					System.out.println("Player 1 wins:" + p1count + "\n" + "Player 2 wins:" + p2count);
					ongoing = true;
				} else {
					ongoing = true;
					System.out.println("Please type yes or no");
				}
			} while (ongoing);

		} while (playing);
		System.out.println("Goodbye!");
		input.close();
	}

}
