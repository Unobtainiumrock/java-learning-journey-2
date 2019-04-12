//package battle_ship;

public class Ship {
	public int health;
	public String INITITIAL_STATE = new String("•"); // Separate state from the one on matrix. Bypassing interning behavior.
	
	/**
	 * @param n is the ship size. Health is initially equivalent to size.
	 */
	public Ship(int n) {
		this.health = n;
	}
	
	public boolean decrementHealth() {
		this.health--;
		
		if (this.health == 0) {
			return emitDeath();
		}
		return false;
	}
	
	public boolean emitDeath() {
		System.out.println("You've suken me!!");
		return this.health == 0;
	}
}
