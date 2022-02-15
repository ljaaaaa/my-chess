public class Grid {
	Tile[][] grid;

	public Grid(){
		grid = new Tile[8][8];
		initPawns();
	}

	private void initPawns(){        
		for (int x = 0; x < grid.length; x++){
			grid[x][1] = new Pawn(x, 1);
		}
	}

}
