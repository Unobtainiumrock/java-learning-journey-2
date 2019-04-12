//package battle_ship;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Matrix {
	public String[][] matrix;
	public final String INITIAL_STATE = "•";
	public final String DIRECT_HIT = "X";
	public final String MISS = "O";
	private int placementCollisions = 0;
	private int[][] possibleCoordinates;
	public int totalShipsHealth = 0;
	
	public Matrix(int n) {
		this.buildMatrix(n);
		this.setPossibleCoordinates();
	}
	
	/**
	 * This is a setter method for making the matrix. All tiles initially point to this Matrix instance's INITIAL_STATE.
	 * Their pointers are eventually changed to Ship instances' INITIAL_STATE.
	 * 
	 * @param n board size.
	 */
	public void buildMatrix(int n) {
//		I had to move the logic out of constructor into this method because I was getting some mystery null pointer exceptions.
		if (n <= 3) {
			n = 4;
		}
		
		this.matrix = new String[n][n];
		for (String[] row: this.matrix) {
			Arrays.fill(row, this.INITIAL_STATE); // point all coordinates to the Character object, INITIAL_STATE.
		}
	}
	
	/**
	 * This will set a all possible coordinate pairs for a matrix. This array of coordinate pairs will be referenced
	 * every time we generate a random number (indices) from where to start assessing ship placement. Doing this allows me to take
	 * advantage of my HelperFunction.specialRandom() method which provides random numbers within a range and excludes a certain set of provided numbers.
	 * 
	 * the cache within my placeShips method will keep track of all the previously checked coordinates as its mapping out where a ship can be placed.  
	 * 
	 */
	private void setPossibleCoordinates() {
		int[][] possibleCoordinates = new int[this.matrix.length * this.matrix.length][2];
		
		int count = 0 ; // The counter increments n * n times.
		
		for (int i = 0; i < this.matrix.length; i++) {
			for (int j = 0; j < this.matrix[i].length; j++) {
				possibleCoordinates[count][0] = i; // x 
				possibleCoordinates[count][1] = j; // y
				count++;
			}
		}
		this.possibleCoordinates = possibleCoordinates;
 	}
	
	
	public Ship[] createShips() {
		int upper = this.matrix.length;
		int lower = 2;
		int numberOfShips = HelperFunctions.inclusiveRandom(upper, lower);
		Ship[] ships = new Ship[numberOfShips];
		int shipSize;
	
		for (int i = 0; i < ships.length; i++) {
//			System.out.println("Creating a ship");
			shipSize = HelperFunctions.inclusiveRandom(upper, lower);
		    ships[i] = new Ship(shipSize);		
		    this.totalShipsHealth+= ships[i].health;
		    this.placementCollisions += shipSize;
		}		
		return ships;
	}
	
	public void placeShips(Ship[] ships) {
		// We need the cache to persist for each ship iteration, hence why it exists at this level, and not inside the findPlacementPath() or randomCoordinates() methods.
		// the cache is used when generating random numbers to prevent already checked random numbers from being generated more than once.
		List<Integer> cache = new ArrayList<>(this.placementCollisions - 1); // Last element has possible collisions with all others already on board (always - 1); IN other words we won't need a cache size to accomodate the last element
		Set<int[]> alreadyTaken = new HashSet<>();
		List<int[]> placementPath;
		System.out.println("Amount of Ships: " + ships.length);
		for (Ship i : ships) {
			System.out.println("Current Ship: " + i);
			System.out.println("Curent Ship Size: " + i.health);
			placementPath = findPlacementPath(alreadyTaken, cache,i.health);
			placementPath.forEach(coordinate -> this.matrix[coordinate[0]][coordinate[1]] = i.INITITIAL_STATE);
		}
		
	}
	
	/**
	 * Branches out in all directions (U/D, L/R, LL/UR, LR/UL) checking if the sum of available tile spaces is
	 * less than or equal to the shipSize. At any point if there aren't enough spaces for a given cardinal direction,
	 * it will stop exploring that direction and check the next. If no possible paths are found for any direction, a new starting point will
	 * be picked. The cache will keep track of what tiles were already explored as starting positions to branch out from. 
	 * The placeShips method prevents a scenario where there's too many ships for any given board size by setting a range of ship sizes
	 * and amount of ships.
	 * 
	 * @param shipSize is the size of the ship we are checking possible paths against.
	 * @param startingCoordinates is the position within the matrix to fan outward from.
	 * @return boolean indicating if the spot it explored is available.
	 */
	private List<int[]> findPlacementPath(Set<int[]> alreadyTaken, List<Integer> cache, int shipSize) {
		
		int[] currentPosition = this.randomCoordinates(cache, (this.matrix.length * this.matrix.length) - 1, 0);
		System.out.println("Inside Find Placement. currentPosition: " + currentPosition[0] + " " + currentPosition[1]);
		int x1 = currentPosition[0]; // The two ordered pairs of coordinates start at the same location before spreading outwards.
		int y1 = currentPosition[1];
		int x2 = currentPosition[0];
		int y2 = currentPosition[1];
		
		int[] temp1; // These are used to hold the current positions of each ordered pair as we traverse the matrix.
		int[] temp2;
		
		List<int[]> placementPath = new ArrayList<>();
		placementPath.add(currentPosition);
		alreadyTaken.add(currentPosition);
	
		// There will always be at least one path a ship can be placed along. This is determined when I'm generating ships of various sizes for the
		// matrix.
		while (true) {
			
			// L/R. Continue to operate as long as there are next lefts or next rights.
			while (true) {
				// Left path building
				if (!(x1 < 0 || x1 >= this.matrix.length || (y1 - 1) < 0 || (y1 - 1) >= this.matrix.length)) {
					if (!alreadyTaken.contains(this.nextLeft(x1, y1))) {
						placementPath.add(this.nextLeft(x1, y1));
						alreadyTaken.add(this.nextLeft(x1, y1));
						
						if (placementPath.size() == shipSize) {
							return placementPath;
						}
							
						temp1 = this.nextLeft(x1, y1);
						
						x1 = temp1[0];
						y1 = temp1[1];
					}

				} else if (!(x2 < 0 || x2 >= this.matrix.length || (y2 + 1) < 0 || (y2 + 1) >= this.matrix.length)) {
					if(!alreadyTaken.contains(this.nextRight(x2, y2))) {
						placementPath.add(this.nextRight(x2, y2));
						alreadyTaken.add(this.nextRight(x2, y2));
						
						if (placementPath.size() == shipSize) {
							return placementPath;
						}
						
						temp2 = this.nextRight(x2, y2);
			
						x2 = temp2[0];
						y2 = temp2[1];
					}
				} else {
					break;
				}				
			}
			
			// Want to exit if I've already found a path for the current ship. Path needs to be cleared each time exploring a direction
				placementPath.clear();
			
			
			// U/D. Continue to operate as long as there are next ups or next downs.
			while (true) {
				if (!((x1 - 1) < 0 || (x1 - 1) >= this.matrix.length || y1 < 0 || y1 >= this.matrix.length)) {
					if (!alreadyTaken.contains(this.nextUp(x1, y1))) {
						placementPath.add(this.nextUp(x1, y1));
						alreadyTaken.add(this.nextUp(x1, y1));
						
						if (placementPath.size() == shipSize) {
							return placementPath;
						}
						
						temp1 = this.nextLeft(x1, y1);
					
						x1 = temp1[0];
						y1 = temp1[1];
					}
				} else if (!((x2 + 1) < 0 || (x2 + 1) >= this.matrix.length || y2 < 0 || y2 >= this.matrix.length)) {
					if (!alreadyTaken.contains(this.nextDown(x2, y2))) {
						placementPath.add(this.nextDown(x2, y2));
						alreadyTaken.add(this.nextDown(x2, y2));
						
						if (placementPath.size() == shipSize) {
							return placementPath;
						}
						
						temp2 = this.nextDown(x2, y2);
			
						x2 = temp2[0];
						y2 = temp2[1];
					}
				} else {
					break;
				}
			}
			
			// Want to exit if I've already found a path for the current ship. Path needs to be cleared each time exploring a direction
				placementPath.clear();
			
			// LL/UR placement
			while (true) {
//				System.out.println("Running!: LL/UR ");
				// Lower-left path building
				if (!((x1 + 1) < 0 || (x1 + 1) >= this.matrix.length || (y1 - 1) < 0 || (y1 - 1) >= this.matrix.length)) {
					if (!alreadyTaken.contains(this.nextLowerLeft(x1, y1))) {
						placementPath.add(this.nextLowerLeft(x1, y1));
						alreadyTaken.add(this.nextLowerLeft(x1, y1));
						
						if (placementPath.size() == shipSize) {
							return placementPath;
						}
						
						temp1 = this.nextLowerLeft(x1, y1);
			
						x1 = temp1[0];
						y1 = temp1[1];
					}

				} else if (!((x2 - 1) < 0 || (x2 - 1) >= this.matrix.length || (y2 + 1) < 0 || (y2 + 1) >= this.matrix.length)) {
					if(!alreadyTaken.contains(this.nextUpperRight(x2, y2))) {
						placementPath.add(this.nextUpperRight(x2, y2));
						alreadyTaken.add(this.nextUpperRight(x2, y2));
						
						if (placementPath.size() == shipSize) {
							return placementPath;
						}
						
						temp2 = this.nextUpperRight(x2, y2);
			
						x2 = temp2[0];
						y2 = temp2[1];
					}

				} else {
					break;
				}		
			}
			
			placementPath.clear();
			
			// LR/UL placement
			while (true) {
				if (!((x1 + 1) < 0 || (x1 + 1) >= this.matrix.length || (y1 + 1) < 0 || (y1 + 1) >= this.matrix.length)) {
					if (!alreadyTaken.contains(this.nextLowerRight(x1, y1))) {
						placementPath.add(this.nextLowerRight(x1, y1));
						
						if (placementPath.size() == shipSize) {
							return placementPath;
						}
						
						temp1 = this.nextLowerRight(x1, y1);
			
						x1 = temp1[0];
						y1 = temp1[1];
					}

				} else if (!((x2 - 1) < 0 || (x2 - 1) >= this.matrix.length || (y2 - 1) < 0 || (y2 - 1) >= this.matrix.length)) {
					if (!alreadyTaken.contains(this.nextUpperLeft(x2, y2))) {
						placementPath.add(this.nextUpperLeft(x2, y2));
						
						if (placementPath.size() == shipSize) {
							return placementPath;
						}
						
						temp2 = this.nextUpperLeft(x2, y2);
			
						x2 = temp2[0];
						y2 = temp2[1];
					}
				} else {
					break;
				}
			}
						
			// re-randomize currentPosition to branch out from.
			currentPosition = this.randomCoordinates(cache, (this.matrix.length * this.matrix.length) - 1, 0);
			x1 = currentPosition[0];
			y1 = currentPosition[1];
			x2 = currentPosition[0];
			y2 = currentPosition[1];
		}
	}
		
	/**
	 * Pseudo-randomizes the starting coordinates for placing a Ship instance. The returned pseudo-randomized starting point is used
	 * by the checkPlacement method.
	 * 
	 * @return pseudo-randomized coordinates
	 */
	private int[] randomCoordinates(List<Integer> cache, int upper, int lower) {
		int randomIndex;
		int[] coordinates = { 0, 0 };
		int x, y;
		 		
	    if (cache.isEmpty()) {
	    	randomIndex = HelperFunctions.specialRandom(upper, lower, cache);
	    	coordinates =  this.possibleCoordinates[randomIndex];
	    	cache.add(randomIndex);
	    	return coordinates;
	    } 
	    
	    
    	randomIndex = HelperFunctions.specialRandom(upper, lower, cache);
    	coordinates =  this.possibleCoordinates[randomIndex];
	    x = coordinates[0]; 
	    y = coordinates[1];
	    	    
		while (this.matrix[x][y] != this.INITIAL_STATE) {
			System.out.println("Collision found! Randomizing");
			randomIndex = HelperFunctions.specialRandom(upper, lower, cache);
			
			coordinates = this.possibleCoordinates[randomIndex];
		    x = coordinates[0];
		    y = coordinates[1];
		}
		
		return coordinates;
	}
	
	// These all need out of bounds protection.
	private int[] nextUpperRight(int x, int y) {
		int[] coordinates = new int[2];
		
		coordinates[0] = x - 1;
		coordinates[1] = y + 1;
		
		return coordinates;
	}
	
	private int[] nextLowerLeft(int x, int y) {
		int[] coordinates = new int[2];
		
		coordinates[0] = x + 1;
		coordinates[1] = y - 1;
		
		return coordinates;
	}
	
	private int[] nextLowerRight(int x, int y) {
		int[] coordinates = new int[2];
		
		coordinates[0] = x + 1;
		coordinates[1] = y + 1;
		
		return coordinates;
	}
	
	private int[] nextUpperLeft(int x, int y) {
		int[] coordinates = new int[2];
		
		coordinates[0] = x - 1;
		coordinates[1] = y - 1;
		
		return coordinates;
	}
	
	private int[] nextUp(int x, int y) {
		int[] coordinates = new int[2];

		coordinates[0] = x - 1;
		coordinates[1] = y;
		
		return coordinates;
	}
	
	private int[] nextDown(int x, int y) {
		int[] coordinates = new int[2];
			
		coordinates[0] = x + 1;
		coordinates[1] = y;
		
		return coordinates;
	}
	
	private int[] nextLeft(int x, int y) {
		int[] coordinates = new int[2];		
//		System.out.println("Moving left");
		coordinates[0] = x;
		coordinates[1] = y - 1;
		
		return coordinates;
	}

	private int[] nextRight(int x, int y) {
		int[] coordinates = new int[2];
		
		coordinates[0] = x;
		coordinates[1] = y + 1;
		
		return coordinates;
	}
	
	/**
	 * Prints the layout of the game board in a row-by-row fashion
	 * 
	 */
	public void printMatrix() {
		
		 
		System.out.println(""); // Formatting between each printing of the matrix.
		System.out.print("   "); // Shift the letter labels.
		
//		Letters for column coordinates
		for (int i = 0, j = 97; i < this.matrix.length; i++, j++) {
			System.out.print((char) j);
			if (i < this.matrix.length - 1) {
				System.out.print('|');
			}
		}
		System.out.println(""); // Formatting to put the actual matrix below the letter labels.
		
		// Matrix contents
		for (int i = 0; i < this.matrix.length; i++) {
			
			// Account for shifting single digit numbers rightward for visual formatting.
			if (i < 9) {
				System.out.print(" " + (i + 1) + "|");
			} else {
				System.out.print((i + 1) + "|");
			}
			
			// Each tile's character
			for (int j = 0; j < this.matrix[i].length; j++) {
				System.out.print(this.matrix[i][j]);
				//Edge formatting for the | characters
				if (j < this.matrix[j].length - 1) {
					System.out.print("|");
				}
			}			
			
			System.out.println(""); // Formatting between each printing of the matrix.
		}
	}
	
}
