import java.util.ArrayList;
import java.awt.Point;
import javax.swing.ImageIcon;

//Piece Class
public class Piece extends Tile{
	public enum Direction {UP, DOWN}
	public Direction dir;
	public final String color;

	//Constructor
	public Piece(int posX, int posY, Grid grid, String color){
		super(posX, posY, grid);
		this.color = color;
	}

	//Returns all possible move coordinates
	public ArrayList<Tile> possibleMoves(){
		return new ArrayList<Tile>();
	}

	public void move(int newX, int newY){
		grid.grid[posX][posY] = new Tile(posX, posY, grid);
		grid.grid[newX][newY] = this;
		this.posX = newX;
		this.posY = newY;
	}
}
