
public class Ship {
	private int ID;
	private int width;
	private int length;
	private static int remainingCells;
	
	public Ship(int ID, int width, int length) {
		this.ID = ID;
		this.width = width;
		this.length = length;
		remainingCells = width * length;
	}

	public int getID() {
		return ID;
	}
	
	public int getWidth() {
		return width;
	}

	public int getLength() {
		return length;
	}

	public static int getRemainingCells() {
		return remainingCells;
	}

	public void takeHit() {
		// decreases the remainingCells to indicate a hit on the ship.
		remainingCells -= 1;
	}

}
