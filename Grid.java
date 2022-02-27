//Grid Class
public class Grid {
	Tile[][] grid;

	//Constructor
	public Grid(){
		grid = new Tile[8][8];
		setBaseGrid();
		initPawns();
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
