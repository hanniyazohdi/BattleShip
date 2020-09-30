
public class Board {
	private int width;
	private int height;
	private int shipNum;
	private Ship[] ships;
	private int[][] grid;
	
	/*
	 * Board constructor that fills the grid with -1
	 * and creates an array of Ship objects 
	 * 
	 * @param int width, int height
	 */
	public Board(int width, int height) {
		this.width = width;
		this.height = height;
		this.shipNum = 0;
		this.ships = new Ship[10];
		this.grid = new int[width][height];
		
		for (int i = 0; i < width; i++) { 
			
			for (int j = 0; j < height; j++) { 
				grid[i][j] = -1; 
			} 
			
		}
	}
	
	/*
	 * method that returns a string of the grid
	 */
	public String printAll() {
		String s = "";
		
		for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
            	
                grid[row][col] = row * col;
                s += grid[row][col] + "\n";
                
            }
        }
		
		return s;
	}

	/*
	 * boolean method that adds a ship to the grid, as long as it fits appropriately
	 * increments the shipNum by one and adds the ship to the Ship array
	 * @param Ship s, int sx, sy
	 */
	public boolean addShip(Ship s, int sx, int sy){

        if(shipNum == 10 || sx >= width || sy >= height) {
        	return false;
        	
        }else if(sx + s.getLength() - 2 > width || sy + s.getWidth() - 2 > height) {
        	return false;
        	
        }else if(grid[sx][sy] != -1) {
        	return false;
        	
        }

        grid[sx][sy] = s.getID();
        ships[shipNum] = s;
        shipNum++;
        
        return true;
	}

	/*
	 * Getter for the grid matrix
	 * @return int grid
	 */
	public int[][] getGrid() {
		return grid;
	}

	/*
	 * Getter that returns a cell from the grid
	 * @param int row, int column
	 * @return grid[row][column]
	 */
	public int getCell(int row, int column) {
		return grid[row][column];
	}
	
	/*
	 * method returns a boolean to see if a ship was destroyed, or if the user hit the water
	 * @return int remainingCells
	 */
	public boolean checkDestroyedShip(int id) {
		
		for(int i = 0; i < shipNum; i++) {
			if(ships[i].getID() == id) {
				ships[i].takeHit();
				if(ships[i].getRemainingCells() == 0) {
					return true;
				}
				return true;
			}
		}
		return false;
	}
	
}
