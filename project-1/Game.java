//package battle_ship;

import java.util.Scanner;

/*
* This class will house a several things:
* 
* 1) Game state (Lose/Win)
* 2) Board (n * n Matrix)
* 3) Ships within the board (minimum 3)
* 4) Score
* 5) Previously guessed positions (wrong)
* 6) Previous direct hits (correct)
*
*/
public class Game {
	
//	The computer must create at least 3 ships. 
//	The ships cannot all be the same size.
//	The ships must be randomly placed within the array.
//	(25 points) User communication:
//	Provide information to the user about the number of hits and misses. Provide a message about whether each guess is a hit or miss.
//	If the user guesses a number outside of the acceptable range, provide an error message.
//	Your program should continue- not crash- when this happens.
//	Note: if the user enters a non-number, it's okay if your program crashes. We'll learn how to prevent this later in the semester!
//	(10 points) Ending the game:
//	If the user hits all positions on all ships, the user wins.
//	If the user gets more than the maximum number of allowed misses, the user looses.
//	After the user wins or loses, ask them if they want to play again.
	private Scanner input;
	public Matrix board;
	private int guessesRemaining;
	private int numberOfShips;
	
	public Game(Scanner input) {
		this.input = input;
	}
	
	
	/**
	 * Prompts the user to provide a board size and sets the Game class' board equal to 
	 * an instance of Matrix.
	 * 
	 */
	public void createBoard() {
		int boardSize = 4;
		
		System.out.print("What size board would you like? Pick a number 4 - 26: ");
		
		try {
			boardSize = Integer.parseInt(input.nextLine());
			
			if (boardSize > 26 || boardSize < 4) {
				System.out.println("Invalid entry. Please try again.");
				this.createBoard();
			}
			
		} catch (NumberFormatException err) {
			err.printStackTrace();
			System.out.println("Invalid entry. Please try again.");
			this.createBoard();
		}
		
		// Protects against this line happening multiple times if the call stack builds up from multiple bad user inputs.
		if (this.board == null) {
			this.board = new Matrix(boardSize);
		}
	}
}
