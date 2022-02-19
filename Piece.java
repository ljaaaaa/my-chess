import java.util.ArrayList;
import java.awt.Point;
import javax.swing.ImageIcon;

//Piece Class
public class Piece extends Tile{
	enum Direction {UP, DOWN}
	Direction dir;

	//Constructor
	public Piece(int posX, int posY, Grid grid){
		super(posX, posY, grid);
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
