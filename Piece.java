import java.util.ArrayList;

//Piece Class
public class Piece extends Tile{
	public final char color;
	protected Grid grid;

	//Constructor
	public Piece(int x, int y, char color, Grid grid){
		super(x, y);
		this.grid = grid;
		this.color = color;
	}

	//Returns all possible move coordinates
	public ArrayList<Tile> possibleMoves(){
		return new ArrayList<Tile>();
	}

	//Move tile to new location
	public void move(int newX, int newY){
		grid.grid[newX][newY] = this;
		grid.grid[this.x][this.y] = new Tile(this.x, this.y);
		this.x = newX;
		this.y = newY;
	}

	public boolean moveWillPutKingInTrouble(int newX, int newY){
		Grid dummy = grid.getCopy();

		((Piece)dummy.grid[this.x][this.y]).move(newX, newY);
		King dummyKing = null;

		//Find king from dummy set
		for (int x = 0; x < dummy.grid.length; x++){
			for (int y = 0; y < dummy.grid[x].length; y++){
				if (dummy.grid[x][y] instanceof King && ((Piece)dummy.grid[x][y]).color == this.color){
					dummyKing = (King)dummy.grid[x][y];
					break;
				}
			}
		}

		//King can be eaten with this move
		if (dummyKing.canBeEaten()){
			return true;
		}
		return false;
	}
}
