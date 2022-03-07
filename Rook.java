import javax.swing.ImageIcon;
import java.util.ArrayList;

//Rook Class
public class Rook extends Piece{
	public Rook(int x, int y, char color){
		super(x, y, color);
		
		normalIcon = new ImageIcon("images/" + color + "_rook.png");
                selectedIcon = new ImageIcon("images/" + color + "_rook_selected.png");
		setSelected(false);
	}

	@Override
        public ArrayList<Tile> possibleMoves(Grid grid){
                ArrayList<Tile> possibles = new ArrayList<>();

                int[][] moves = new int[][] { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

                for (int x = 0; x < moves.length; x++){
                        int add = 1;
                        int currentX = this.x+(moves[x][0]*add);
                        int currentY = this.y+(moves[x][1]*add);

                        while (currentX >= 0 && currentX < 8 && currentY >= 0 && currentY < 8){
                                possibles.add(grid.grid[currentX][currentY]);

                                if (grid.grid[currentX][currentY] instanceof Piece){
                                        if (((Piece)grid.grid[currentX][currentY]).color == color){
                                                possibles.remove(possibles.size()-1);
                                        }
                                        break;
                                }
                                add++;
                                currentX = this.x+(moves[x][0]*add);
                                currentY = this.y+(moves[x][1]*add);
                        }
                }
                return possibles;
        }
}
