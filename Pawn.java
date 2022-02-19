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
		dir = Direction.DOWN;
	}

	@Override
        public ArrayList<Tile> possibleMoves(){
		ArrayList<Tile> possibles = new ArrayList<>(); 

		switch(dir){
			//Piece is going down
			case DOWN:
				//Next tile
               			if (posY+1 < 8 && !(grid.grid[posX][posY+1] instanceof Piece)){
                        		possibles.add(grid.grid[posX][posY+1]);

				//Next two tiles
                		} if (posY == 1 && !(grid.grid[posX][posY+2] instanceof Piece)){
                                	possibles.add(grid.grid[posX][posY+2]);
                        	}				
				break;

			//Piece is going up
			case UP:
				//Next tile
                                if (posY-1 >= 0 && !(grid.grid[posX][posY+1] instanceof Piece)){
                                        possibles.add(grid.grid[posX][posY+1]);

                                //Next two tiles
                                } if (posY == 7 && !(grid.grid[posX][posY+2] instanceof Piece)){
                                        possibles.add(grid.grid[posX][posY+2]);
                                }

				break;
		}
		return possibles;
        }
}
