import javax.swing.ImageIcon;
import java.util.ArrayList;
import java.awt.Point;

//Pawn Class
public class Pawn extends Piece{
	ImageIcon imageIcon;

	//Constructor
	public Pawn(int posX, int posY){
		super(posX, posY);
		imageIcon = new ImageIcon("images/pawn.png");
	}

	@Override
        public ArrayList<Point> possibleMoves(){
        

	
		return new ArrayList<Point>();
        }
}
