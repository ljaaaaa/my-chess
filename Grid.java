//Grid Class
public class Grid {
	Tile[][] grid;
	Set setW;
	Set setB;

	//Constructor
	public Grid(){
		grid = new Tile[8][8];
		setW = new Set('w');
		setB = new Set('b');

		setBaseGrid();
		initPieces();

		//Add pieces to grid
		for (int x = 0; x < setW.pieces.length; x++){
			grid[setW.pieces[x].x][setW.pieces[x].y] = setW.pieces[x];
			grid[setB.pieces[x].x][setB.pieces[x].y] = setB.pieces[x];
		}
	}	

	//Set basic grid to non-null tiles
	private void setBaseGrid(){
		for (int x = 0; x < grid.length; x++){
			for (int y = 0; y < grid[0].length; y++){
				grid[x][y] = new Tile(x, y);
			}
		}
	}

	private void initPieces(){
		//Pawns
		for (int x = 0; x < grid.length; x++){
                        setW.pieces[x] = new Piece(x, 1, 'w', "pawn", this);
                }

                for (int x = 0; x < grid.length; x++){
                        setB.pieces[x] = new Piece(x, 6, 'b', "pawn", this);
                }

		//Bishops
		setW.pieces[8] = new Piece(1, 0, 'w', "bishop", this);
                setW.pieces[9] = new Piece(6, 0, 'w', "bishop", this);
                setB.pieces[8] = new Piece(1, 7, 'b', "bishop", this);
                setB.pieces[9] = new Piece(6, 7, 'b', "bishop", this);

		//Knights
		setW.pieces[10] = new Piece(2, 0, 'w', "knight", this);
                setW.pieces[11] = new Piece(5, 0, 'w', "knight", this);
                setB.pieces[10] = new Piece(2, 7, 'b', "knight", this);
                setB.pieces[11] = new Piece(5, 7, 'b', "knight", this);
	
		//Rooks
		setW.pieces[12] = new Piece(0, 0, 'w', "rook", this);
                setW.pieces[13] = new Piece(7, 0, 'w', "rook", this);
                setB.pieces[12] = new Piece(0, 7, 'b', "rook", this);
                setB.pieces[13] = new Piece(7, 7, 'b', "rook", this);
	
		//Queens
		setW.pieces[14] = new Piece(3, 0, 'w', "queen", this);
                setB.pieces[14] = new Piece(3, 7, 'b', "queen", this);
                
		setW.king = new Piece(4, 0, 'w', "king", this);
		setW.pieces[15] = setW.king;

		setB.king = new Piece(4, 7, 'b', "king", this);
                setB.pieces[15] = setB.king;
	}

	//Print grid for debugging
	public void printGrid(){
		for (int x = 0; x < grid.length; x++){
                        for (int y = 0; y < grid[0].length; y++){
                                System.out.print("[" + grid[y][x] + "]");
                        }
			System.out.println("");
                }
	}
}
