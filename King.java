import javax.swing.ImageIcon;
import java.util.ArrayList;

//King Class
public class King extends Piece{
	//Constructor
	public King(int x, int y, char color){
		super(x, y, color);
		currentIcon = new ImageIcon("images/" + color + "_king.png");
	}

	@Override
        public ArrayList<Tile> possibleMoves(Grid grid){
                ArrayList<Tile> possibles = new ArrayList<>();

                int[][] moves = new int[][] { {}, {}, {}, {}, {}, {}, {}, {} };

                for (int x = 0; x < moves.length; x++){
                        int add = 1;
                        int currentX = this.x+(moves[x][0]*add);
                        int currentY = this.y+(moves[x][1]*add);

			if (currentX >= 0 && currentX < 8 && currentY >= 0 && currentY < 8
					&& ((grid.grid[currentX][currentY] instanceof Piece && ((Piece)grid.grid[currentX][currentY]).color != color) || 
						!(grid.grid[currentX][currentY] instanceof Piece))){

					possibles.add(grid.grid[currentX][currentY]);
			}
		}

                return possibles;
        }
}