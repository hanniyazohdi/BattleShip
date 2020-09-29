
public class Board {
	private int width;
	private int height;
	private int shipNum;
	private Ship[] ships;
	private int[][] grid;
	
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

	public int[][] getGrid() {
		return grid;
	}

	
	public int getCell(int row, int column) {
		return grid[row][column];
	}
	
	
	public boolean checkDestroyedShip(int id) {
		
		for(int i = 0; i < shipNum; i++) {
			if(ships[i].getID() == id) {
				ships[i].takeHit();
				if(Ship.getRemainingCells() == 0) {
					return true;
				}
				return true;
			}
		}
		return false;
	}
	
}
