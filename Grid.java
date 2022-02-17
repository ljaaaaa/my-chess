public class Grid {
	Tile[][] grid;

	public Grid(){
		grid = new Tile[8][8];
		setBaseGrid();
		initPawns();
	}

	private void setBaseGrid(){
		for (int x = 0; x < grid.length; x++){
			for (int y = 0; y < grid[0].length; y++){
				grid[x][y] = new Tile(x, y, this);
			}
		}
	}

	private void initPawns(){        
		for (int x = 0; x < grid.length; x++){
			grid[x][1] = new Pawn(x, 1, this);
		}
	}

}
