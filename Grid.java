//Grid Class
public class Grid {
	public final int TILE_SIZE;
	public Tile[][] grid;
	public Set setW;
	public Set setB;
	public Tile selectedTile;
	private Main main;

	//Constructor
	public Grid(Main main){
		grid = new Tile[8][8];
		setW = new Set('w');
		setB = new Set('b');
		setW.setOtherSet(setB);
		setB.setOtherSet(setW);
		this.TILE_SIZE = main.TILE_SIZE;
		this.main = main;

		setBaseGrid();
		initPieces();

		//Add pieces to grid
		for (int x = 0; x < setW.pieces.size(); x++){
			grid[setW.pieces.get(x).x][setW.pieces.get(x).y] = setW.pieces.get(x);
			grid[setB.pieces.get(x).x][setB.pieces.get(x).y] = setB.pieces.get(x);
		}
	}	

	//Return a copy of this grid
	public Grid getDummyGrid(){
		Grid copy = new Grid(main);
		copy.grid = new Tile[8][8]; 
		copy.setW = new Set('w');
		copy.setB = new Set('b');
		
		copy.setW.setOtherSet(copy.setB);
		copy.setB.setOtherSet(copy.setW);
		
		copy.setBaseGrid();

		//Copy whites
		for (int x = 0; x < this.setW.pieces.size(); x++){
			Piece equivalentW = this.setW.pieces.get(x);
			copy.setW.pieces.add(new Piece(equivalentW.x, equivalentW.y, 'w', equivalentW.type, TILE_SIZE, copy, main.history));	
			copy.grid[copy.setW.pieces.get(x).x][copy.setW.pieces.get(x).y] = copy.setW.pieces.get(x);
                       
			if (equivalentW.type == 'k'){
				copy.setW.king = copy.setW.pieces.get(x);
			}
		}

		//Copy blacks
		for (int x = 0; x < this.setB.pieces.size(); x++){
                        Piece equivalentB = this.setB.pieces.get(x);
                        copy.setB.pieces.add(new Piece(equivalentB.x, equivalentB.y, 'b', equivalentB.type, TILE_SIZE, copy, main.history));
                        copy.grid[copy.setB.pieces.get(x).x][copy.setB.pieces.get(x).y] = copy.setB.pieces.get(x);

                        if (equivalentB.type == 'k'){
                                copy.setB.king = copy.setB.pieces.get(x);
                        }
		}

		return copy;
	}

	//Set basic grid to non-null tiles
	private void setBaseGrid(){
		for (int x = 0; x < grid.length; x++){
			for (int y = 0; y < grid[0].length; y++){
				grid[x][y] = new Tile(x, y, TILE_SIZE);
			}
		}
	}

	private void initPieces(){
		//Pawns
		for (int x = 0; x < grid.length; x++){
                        setW.pieces.add(new Piece(x, 1, 'w', 'p', TILE_SIZE, this, main.history));
                	setB.pieces.add(new Piece(x, 6, 'b', 'p', TILE_SIZE, this, main.history));
		}

		//Bishops
		setW.pieces.add(new Piece(2, 0, 'w', 'b', TILE_SIZE, this, main.history));
                setW.pieces.add(new Piece(5, 0, 'w', 'b', TILE_SIZE, this, main.history));
                setB.pieces.add(new Piece(2, 7, 'b', 'b', TILE_SIZE, this, main.history));
                setB.pieces.add(new Piece(5, 7, 'b', 'b', TILE_SIZE, this, main.history));

		//Knights
		setW.pieces.add(new Piece(1, 0, 'w', 'n', TILE_SIZE, this, main.history));
                setW.pieces.add(new Piece(6, 0, 'w', 'n', TILE_SIZE, this, main.history));
                setB.pieces.add(new Piece(1, 7, 'b', 'n', TILE_SIZE, this, main.history));
                setB.pieces.add(new Piece(6, 7, 'b', 'n', TILE_SIZE, this, main.history));
	
		//Rooks
		setW.pieces.add(new Piece(0, 0, 'w', 'r', TILE_SIZE, this, main.history));
                setW.pieces.add(new Piece(7, 0, 'w', 'r', TILE_SIZE, this, main.history));
                setB.pieces.add(new Piece(0, 7, 'b', 'r', TILE_SIZE, this, main.history));
                setB.pieces.add(new Piece(7, 7, 'b', 'r', TILE_SIZE, this, main.history));
	
		//Queens
		setW.pieces.add(new Piece(4, 0, 'w', 'q', TILE_SIZE, this, main.history));
                setB.pieces.add(new Piece(4, 7, 'b', 'q', TILE_SIZE, this, main.history));
                
		setW.king = new Piece(3, 0, 'w', 'k', TILE_SIZE, this, main.history);
		setW.pieces.add(setW.king);

		setB.king = new Piece(3, 7, 'b', 'k', TILE_SIZE, this, main.history);
                setB.pieces.add(setB.king);
	}
}