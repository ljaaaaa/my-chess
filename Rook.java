import javax.swing.ImageIcon;
import java.util.ArrayList;

//Rook Class
public class Rook extends Piece{
	//Constructor
	public Rook(int posX, int posY, Grid grid, char color){
		super(posX, posY, grid, color);
		
		normalIcon = new ImageIcon("images/" + color + "_rook.png");
                selectedIcon = new ImageIcon("images/" + color + "_rook_selected.png");
		setSelected(false);
	}

	@Override
        public ArrayList<Tile> possibleMoves(){
		ArrayList<Tile> possibles = new ArrayList<>(); 

		return possibles;
        }
}
