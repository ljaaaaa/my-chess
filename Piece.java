import java.util.ArrayList;
import java.awt.Point;
import javax.swing.ImageIcon;

//Piece Class
public class Piece extends Tile{
	//Constructor
	public Piece(Grid grid){
		super(grid);
	}

	//Returns all possible move coordinates
	public ArrayList<Point> possibleMoves(){
		return new ArrayList<Point>();
	}
}
