public class Game {
	private Board board;
	private GameGUI gui;
	private boolean isTesting;
	@SuppressWarnings("unused")
	private int activeShipCount;
	
	public Game(boolean isTesting) {
		
		if(isTesting == false) {
			ShipRandomizer.placeShips(this);
			
		}else if(isTesting == true){
			
		}
		
		this.board = new Board(Config.BOARD_LENGTH, Config.BOARD_WIDTH);
		this.activeShipCount = 0;
		
	}
	
	public void initializeGUI() {
		
		this.gui = new GameGUI(board.getGrid(), isTesting);
		
	}
	
	public boolean addShip(Ship s, int sx, int sy){
		if(board.addShip(s, sx, sy) == true) {
			activeShipCount++;
			return true;
		}
		return false;
	}
	
	public int shootTarget(String target) {
		int i = 0;
		
		if(Config.isValidTarget(target) == false) {
			i = -1;
			
		}else if(Config.isValidTarget(target) == true) {
			
			int id = board.getCell(Config.parseCell(target)[0], Config.parseCell(target)[1]);
			if(id != -1) {
				i = 1;  // hit one ship
				
			}else if(board.ships[i].getRemainingCells() == 0) {
				i = 2; // hit whole ship
				
			}else if(sunkFleet()) {
				i = 3; // hit whole fleet
				
			}
		}
		
		return i;
	}
		

	public boolean sunkFleet() {
		for (int row = 0; row < 10; row++) {
			for (int col = 0; col < 10; col++) {
				if(board.getCell(row,col) == -1)
					return true;
			}
		}
		return false;
	}
	
}
