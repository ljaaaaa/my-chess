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
		int oldX = this.x;
		int oldY = this.y;

		move(newX, newY);
		Set mySet = color == 'w' ? grid.setW : grid.setB;

		//King can be eaten with this move
		if (mySet.king.canBeEaten()){
			return true;	
		}

		return false;
	}
}
