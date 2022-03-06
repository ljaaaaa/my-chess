import java.util.ArrayList;

//Piece Class
public class Piece extends Tile{
	public enum Direction {
		UP, 
		DOWN 
	}

	public Direction dir;
	public final char color;

	//Constructor
	public Piece(int posX, int posY, char color){
		super(posX, posY);
		this.color = color;
		dir = color == 'w' ? Direction.DOWN : Direction.UP;

		setSelected(false);
	}

	//Returns all possible move coordinates
	public ArrayList<Tile> possibleMoves(Grid grid){
		return new ArrayList<Tile>();
	}

	//Move tile to new location
	public void move(Grid grid, int newX, int newY){
		grid.grid[posX][posY] = new Tile(posX, posY);
		grid.grid[newX][newY] = this;
		this.posX = newX;
		this.posY = newY;
	}
}
