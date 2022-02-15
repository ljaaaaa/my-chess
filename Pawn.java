import javax.swing.ImageIcon;
import java.util.ArrayList;
import java.awt.Point;

//Pawn Class
public class Pawn extends Piece{
	//Constructor
	public Pawn(int posX, int posY){
		super(posX, posY);
		normalIcon = new ImageIcon("images/pawn.png");
                selectedIcon = new ImageIcon("images/pawn_selected.png");
		setSelected(false);
	}

	@Override
        public ArrayList<Point> possibleMoves(){
		return new ArrayList<Point>();
        }
}
