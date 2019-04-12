// package battle_ship;

import java.util.Scanner;

//Sources
//https://stackoverflow.com/questions/15805578/will-two-strings-with-same-content-be-stored-in-the-same-memory-location
//https://dzone.com/articles/string-interning-what-why-and
//https://codeblab.com/wp-content/uploads/2009/09/DualPivotQuicksort.pdf
//https://en.wikipedia.org/wiki/Quicksort

public class Battleship {

	private static Scanner input = new Scanner(System.in);
	
	/**
	 * The main method is responsible for acting as the focal point of the
	 * application. This is where users choose to enter tests mode (dev mode) or
	 * game mode. If a user provides a bad input, it recursively calls itself until
	 * the user provides a correct choice.
	 *  
	 * Utilizes:
	 *  1) A switch/case statement for handling user inputs and recursively calls itself if the user provides an invalid input.
	 *  2) Game class
	 *  3) Scanner class
	 * 
	 * @param args inputs from the command line
	 */
	public static void main(String[] args) {
		int userChoice = 0;
		int[] userGuess = {0 , 0};
		int guesses = 0;	
				
		System.out.println("Would you like to run tests, or play the game?");
		System.out.println("Select from the following options:");
		System.out.println("[1] Game Mode");
		System.out.println("[2] Test Mode");
				
		try {
			userChoice = Integer.parseInt(input.nextLine());
		} catch (NumberFormatException err) {
			err.printStackTrace();
			System.out.println("Invalid entry. Please try again.");
			main(args);
		}
		

		switch (userChoice) {
		case 1:
			System.out.println("Entering game mode..");
			Game currentGame = new Game(input);
			currentGame.createBoard();
			Ship[] ships= currentGame.board.createShips();
			currentGame.board.placeShips(ships);
			currentGame.board.printMatrix();

			
			while (guesses < currentGame.board.matrix.length * currentGame.board.matrix.length && currentGame.board.totalShipsHealth > 0) {
				System.out.print("Your turn, x coordinate please: ");
				try {
					userChoice = Integer.parseInt(input.nextLine());
					
					if (userChoice < 0 || userChoice > currentGame.board.matrix.length - 1) {
						System.out.println("Please provide a number within the valid board range.");
						System.out.println("Restarting");
						main(args);
					}
					
				} catch(NumberFormatException err) {
					System.out.println("Numbers only! Restarting");
					main(args);
				}
				
				userGuess[0] = userChoice;
				System.out.print("Your turn, y coordinate please: ");
				
				try {
					userChoice = Integer.parseInt(input.nextLine());
					
					if (userChoice < 0 || userChoice > currentGame.board.matrix.length - 1 ) {
						System.out.println("Please provide a number within the valid board range.");
						System.out.println("Restarting");
						main(args);
					}
					
				} catch (NumberFormatException err) {
					main(args);
					System.out.println("Numbers only! restarting");
				}				
				
				userGuess[1] = userChoice;
				
				
				if (currentGame.board.matrix[userGuess[0]][userGuess[1]].equals("•")) {
					if (currentGame.board.matrix[userGuess[0]][userGuess[1]] != currentGame.board.INITIAL_STATE) {
						System.out.println("Direct hit!");
						currentGame.board.totalShipsHealth--;
						currentGame.board.matrix[userGuess[0]][userGuess[1]] = currentGame.board.DIRECT_HIT;
					} else {
						System.out.println("Miss!");
						currentGame.board.matrix[userGuess[0]][userGuess[1]] = currentGame.board.MISS;
					}
				}
				currentGame.board.printMatrix();
				guesses++;
			}

			if (currentGame.board.totalShipsHealth == 0) {
				System.out.println("You've sunken all ships! Congratulations!");
				System.out.println("Would you like to play again?"); 
				System.out.println("[1] Yes");
				System.out.println("[2] No");
				
				try {
					userChoice = Integer.parseInt(input.nextLine());
				} catch (NumberFormatException err) {
					main(args);
					System.out.println("Numbers only! restarting");
				}
				
				if (userChoice == 1) {
					main(args);
				} else {
					System.out.println("Goodbye!");
					input.close();
				}
			}
			
			break;
		case 2:
			System.out.println("Entering test mode..");
			Tests.init(input);
			break;
		default:
			System.out.println("You've provided an invalid choice. Please choose again");
			main(args);
		}

	}

	/**
	 * A public method so that other files/users using instances of the Battleship class have a way to
	 * create a battleship game.
	 * 
	 * @return instance of Game class
	 */
	public static Game createGame() {
		return new Game(input);
	}
}
