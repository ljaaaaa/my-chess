import java.util.ArrayList;

//Piece Class
public class Piece extends Tile{
	public final char color;

	//Constructor
	public Piece(int x, int y, char color){
		super(x, y);
		this.color = color;
	}

	//Returns all possible move coordinates
	public ArrayList<Tile> possibleMoves(Grid grid){
		return new ArrayList<Tile>();
	}

	//Move tile to new location
	public void move(Grid grid, int newX, int newY){
		grid.grid[newX][newY] = this;
		grid.grid[this.x][this.y] = new Tile(this.x, this.y);
		this.x = newX;
		this.y = newY;
	}
}
