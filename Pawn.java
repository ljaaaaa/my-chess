import javax.swing.ImageIcon;
import java.util.ArrayList;
import java.awt.Point;

//Pawn Class
public class Pawn extends Piece{
	//Constructor
	public Pawn(int posX, int posY, Grid grid){
		super(posX, posY, grid);
		normalIcon = new ImageIcon("images/pawn.png");
                selectedIcon = new ImageIcon("images/pawn_selected.png");
		setSelected(false);
	}

	@Override
        public ArrayList<Tile> possibleMoves(){
		ArrayList<Tile> possibles = new ArrayList<>();

		//Next tile
		if (!(grid.grid[posX][posY+1] instanceof Piece)){
			possibles.add(grid.grid[posX][posY+1]);
		} 

		//Next two tiles
		if (posY == 1){
			//If next tile is not taken by a piece
			if (!(grid.grid[posX][posY+2] instanceof Piece)){
				possibles.add(grid.grid[posX][posY+2]);
			}
		}

		return possibles;
        }
}
