import javax.swing.ImageIcon;
import java.util.ArrayList;
import java.awt.Point;

//Pawn Class
public class Pawn extends Piece{
	//Constructor
	public Pawn(Grid grid){
		super(grid);
		normalIcon = new ImageIcon("images/pawn.png");
                selectedIcon = new ImageIcon("images/pawn_selected.png");
		setSelected(false);
	}

	@Override
        public ArrayList<Point> possibleMoves(){
		ArrayList<Point> possibles = new ArrayList<>();

		Point myCoords = myCoords();

		return new ArrayList<Point>();
        }
}
