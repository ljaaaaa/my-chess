import javax.swing.ImageIcon;
import java.util.ArrayList;


//Pawn Class
public class Pawn extends Piece{
	public enum Direction {
                UP,
                DOWN
        }
        public Direction dir;

	//Constructor
	public Pawn(int x, int y, char color){
		super(x, y, color);
	
		dir = color == 'w' ? Direction.DOWN : Direction.UP;
		
		normalIcon = new ImageIcon("images/" + color + "_pawn.png");
                selectedIcon = new ImageIcon("images/" + color + "_pawn_selected.png");
		setSelected(false);
	}
}
