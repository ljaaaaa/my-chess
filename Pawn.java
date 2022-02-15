import javax.swing.ImageIcon;
import java.util.ArrayList;
import java.awt.Point;

//Pawn Class
public class Pawn extends Piece{
	boolean isSelected;

	//Constructor
	public Pawn(int posX, int posY){
		super(posX, posY);
		setIcon("images/pawn.png");
		isSelected = false;
	}

	@Override
        public ArrayList<Point> possibleMoves(){
		return new ArrayList<Point>();
        }
}
