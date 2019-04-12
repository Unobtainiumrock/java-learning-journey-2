//package battle_ship;

import java.util.Scanner;

/**
 * This class contains application flow and logic for running tests. It presents a menu of choices and runs the respective tests
 * for a given piece of our Battleship application.
 * 
 * Things to test:
 * [1] Game <- responsible for the game state, board, and ships
 * [2] Matrix <- responsible for 
 * [3] Ship
 * 
 */
public class Tests {
	public static void init(Scanner input) {
		int userChoice;
		
		System.out.println("Which class would you like to test?");
		System.out.println("[1] Game");
		System.out.println("[2] Matrix");
		System.out.println("[3] Ship");
		
		userChoice = Integer.parseInt(input.nextLine());
		
		
		switch(userChoice) {
			case 1:
				// Test the game
				break;
			case 2: 
				// Test the matrix
				matrixTests();
				break;
			case 3: 
				// Test the ship
				shipTests();
				break;
			default:
				System.out.println("You've provided an invalid choice. Please choose again");
				init(input);
		}
	}

	
	private static void gameTests() {
		System.out.println("Should keep track of how many guesses remain");

	}
	
	private static void matrixTests() {
		Matrix test;
		System.out.println("Should create an n * n matrix when given a number");
		for (int i = 3; i <= 26; i++) {
			test = new Matrix(i);
			System.out.println("Size: " + i);
			test.printMatrix();
			System.out.println("====================================================");
			
			for (int j = 0; j < test.matrix.length; j++) {
				if (test.matrix.length != i) {
					System.out.println("Expected a column size of " + i + " , but received: " + test.matrix.length);
					break;
				}
				
				if (test.matrix[j].length != i) {
					System.out.println("Expected a row size of " + i + ", but received: " + test.matrix.length);
					break;
				}
			}	
		}
		
		System.out.println("Should default to a size of 4 * 4 for any value less than 4 provided.");
		for (int i = 2; i > -1; i--) {	
			test = new Matrix(i);
			System.out.println("Attempting to create a matrix of " + i + " * " + i);
			test.printMatrix();
		}
		
		
		System.out.println("");
		System.out.println("All tiles should discern between the memory address that INITIAL_STATE resides at for Matrix vs INITIAL_STATE on Ship instances");
		System.out.println("");
		test = new Matrix(4);
		Ship testShip = new Ship(3);
		Ship testShipTwo = new Ship(3);
		
		// Intentionally using == as opposed to .equals() 
		for (String[] i : test.matrix) {
			for (String j : i) {
				System.out.print("Comparing tile to Matrix initial state: ");
				System.out.println(j == test.INITIAL_STATE);
				System.out.println("");
				System.out.print("Comparing tile to Ship intitial state: ");
				System.out.println(j == testShip.INITITIAL_STATE);
				System.out.println("");
			}
		}
		
		System.out.println("Tiles should properly reassign their pointers from Matrix's INITIAL_STATE to Ship instances'own INITIAL_STATE");
//		System.out.println("Matrix Character address:" + test.INITIAL_STATE.hashCode());
//		System.out.println("Matrix address: " + test.matrix[0][0].hashCode());
		System.out.println("");
		System.out.println("Placing a ship segment at [0][0]");
		test.matrix[0][0] = testShip.INITITIAL_STATE;
		System.out.println("Placing a ship segment at [0][1]");
		test.matrix[0][1] = testShip.INITITIAL_STATE;
		System.out.println("Placing a ship segment at [0][2]");
		test.matrix[0][2] = testShip.INITITIAL_STATE;
		System.out.println("Placing a ship segment at [0][3]");
		test.matrix[0][3] = testShip.INITITIAL_STATE;
		System.out.println("");
		
		for (int i = 0; i < test.matrix.length; i++) {
			for (int j = 0; j < test.matrix[i].length; j++) {
				if (test.matrix[i][j] != test.INITIAL_STATE) {
					test.matrix[i][j] = "X";
					System.out.println("A ship exists on the matrix @ [" + i + "][" + j +"]");
//					System.out.println("Matrix address: " + test.matrix[i][j].hashCode());
//					System.out.println("Ship address: " + test.INITIAL_STATE.hashCode());
//					System.out.println("Ship one Character address: " + testShip.INITITIAL_STATE.hashCode());
//					System.out.println("Ship two Character address: " + testShipTwo.INITITIAL_STATE.hashCode());
//					System.out.println("Ship one address: " + testShip.hashCode());
//					System.out.println("Ship two address: " + testShipTwo.hashCode());
					
					test.printMatrix();
				}
			}
		}
	}

	private static void shipTests() {
		Ship test;
		System.out.println("It should have a health equal to its given size");
		
		for (int i = 0; i <= 26; i++) {
			test = new Ship(i);
			System.out.print("Ship size: " + i);
			System.out.println(" Ship health: " + test.health);
			
			if (i != test.health) {
				System.out.println("Expected a health of " + i + " , but instead it was: " + test.health);
				break;
			}
		}
		System.out.println("");
		
		System.out.println("When a ship is hit, their health should decrement");
		test = new Ship(3);
		System.out.println("Ship health: " + test.health);
		System.out.println("Attacking ship!");
		test.decrementHealth();
		System.out.println("Ship health: " + test.health);
		System.out.println("");
		
		System.out.println("When a ship has 0 health, it emits its death");
		System.out.println("Attacking ship!");
		test.decrementHealth();
		System.out.println("Attacking ship!");
		test.decrementHealth();
		System.out.println("");
			
	}
	
}
