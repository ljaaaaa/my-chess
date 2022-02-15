public class Grid {
	Piece[][] grid;

	public Grid(){
		grid = new Piece[8][8];
		initPawns();
	}

	private void initPawns(){        
		for (int x = 0; x < grid.length; x++){
			grid[x][1] = new Pawn(x, 1);
		}
	}

}
