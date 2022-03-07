import javax.swing.ImageIcon;
import java.util.ArrayList;

//Bishop Class
public class Knight extends Piece{
	//Constructor
	public Knight(int x, int y, char color){
		super(x, y, color);
		
		normalIcon = new ImageIcon("images/" + color + "_knight.png");
                selectedIcon = new ImageIcon("images/" + color + "_knight_selected.png");
		setSelected(false);
	}

	@Override
        public ArrayList<Tile> possibleMoves(Grid grid){
                ArrayList<Tile> possibles = new ArrayList<>();

                int[][] moves = new int[][] { {-2, -1}, {-1, -2}, {1, -2}, {2, -1}, 
						{2, 1}, {1, 2}, {-1, 2}, {-2, 1} };

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
