//Grid Class
public class Grid {
	Tile[][] grid;

	//Constructor
	public Grid(){
		grid = new Tile[8][8];
		setBaseGrid();
		initPawns();
		initBishops();
	}

	//Set basic grid to non-null tiles
	private void setBaseGrid(){
		for (int x = 0; x < grid.length; x++){
			for (int y = 0; y < grid[0].length; y++){
				grid[x][y] = new Tile(x, y, this);
			}
		}
	}

	//Initialize pawns onto grid
	private void initPawns(){        
		for (int x = 0; x < grid.length; x++){
			grid[x][1] = new Pawn(x, 1, this, 'w');
		}

		for (int x = 0; x < grid.length; x++){
                        grid[x][6] = new Pawn(x, 6, this, 'b');
                }
	}

	//Initialize bishops onto grid
        private void initBishops(){
                grid[1][0] = new Bishop(1, 0, this, 'w');
		grid[6][0] = new Bishop(6, 0, this, 'w');
		grid[1][7] = new Bishop(1, 7, this, 'b');
		grid[6][7] = new Bishop(6, 7, this, 'b');	
	}

	//Print grid, for debugging
	public void printGrid(){
		for (int x = 0; x < grid.length; x++){
                        for (int y = 0; y < grid[0].length; y++){
                                System.out.print("[" + grid[x][y] + "]");
                        }
			System.out.println("");
                }
	}
}
