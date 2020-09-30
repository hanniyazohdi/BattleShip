public class Ship {
	private int ID;
	private int width;
	private int length;
	private static int remainingCells;
	
	/*
	 * Ship constructor for the battleship
	 * @param int ID, int width, int length
	 */
	public Ship(int ID, int width, int length) {
		this.ID = ID;
		this.width = width;
		this.length = length;
		remainingCells = width * length;
	}

	/*
	 * Getter for ID
	 * @return int ID
	 */
	public int getID() {
		return ID;
	}
	
	/*
	 * Getter for width
	 * @return int width
	 */
	public int getWidth() {
		return width;
	}

	/*
	 * Getter for length
	 * @return int length
	 */
	public int getLength() {
		return length;
	}

	/*
	 * static method for returning the remainingCells
	 * @return int remainingCells
	 */
	public int getRemainingCells() {
		return remainingCells;
	}

	/*
	 * method after ship is hit, decrements remainingCells by 1
	 */
	public void takeHit() {
		// decreases the remainingCells to indicate a hit on the ship.
		remainingCells -= 1;
	}

}
