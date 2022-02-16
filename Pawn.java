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

		if (!(grid.grid[myCoords.x][myCoords.y+1] instanceof Piece)){
			possibles.add(new Point(myCoords.x, myCoords.y+1));
		} 

		//Next two tiles
		if (myCoords.y == 1){
			if (!(grid.grid[myCoords.x][myCoords.y+2] instanceof Piece)){
				possibles.add(new Point(myCoords.x, myCoords.y+2));
			}
		}

		return possibles;
        }
}
