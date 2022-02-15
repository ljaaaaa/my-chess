import java.util.ArrayList;
import java.awt.Point;
import javax.swing.ImageIcon;

//Piece Class
public class Piece extends Tile{
	//Constructor
	public Piece(int posX, int posY){
		super(posX, posY);
	}

	//Returns all possible move coordinates
	public ArrayList<Point> possibleMoves(){
		return new ArrayList<Point>();
	}
}
