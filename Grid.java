//Grid Class
public class Grid {
	Tile[][] grid;

	//Constructor
	public Grid(){
		grid = new Tile[8][8];
		setBaseGrid();
		//initPawns();
		//initBishops();
		initRooks();
		//initKnights();
	}

	//Set basic grid to non-null tiles
	private void setBaseGrid(){
		for (int x = 0; x < grid.length; x++){
			for (int y = 0; y < grid[0].length; y++){
				grid[x][y] = new Tile(x, y);
			}
		}
	}

	//Initialize pawns onto grid
	private void initPawns(){        
		for (int x = 0; x < grid.length; x++){
	//		grid[x][1] = new Pawn(x, 1, this, 'w');
		}

		for (int x = 0; x < grid.length; x++){
        //                grid[x][6] = new Pawn(x, 6, this, 'b');
                }
	}

	//Initialize bishops onto grid
        private void initBishops(){
        //        grid[1][0] = new Bishop(1, 0, this, 'w');
	//	grid[6][0] = new Bishop(6, 0, this, 'w');
	//	grid[1][7] = new Bishop(1, 7, this, 'b');
	//	grid[6][7] = new Bishop(6, 7, this, 'b');	
	}

	//Initialize rooks onto grid
        private void initRooks(){
                grid[0][0] = new Rook(0, 0, 'w');
        //        grid[7][0] = new Rook(7, 0, this, 'w');
        //        grid[0][7] = new Rook(0, 7, this, 'b');
        //        grid[7][7] = new Rook(7, 7, this, 'b');
        }

	private void initKnights(){
	//	grid[2][0] = new Knight(2, 0, this, 'w');
        //        grid[5][0] = new Knight(5, 0, this, 'w');
        //        grid[2][7] = new Knight(2, 7, this, 'b');
        //        grid[5][7] = new Knight(5, 7, this, 'b');
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
