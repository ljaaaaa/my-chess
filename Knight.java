import javax.swing.ImageIcon;
import java.util.ArrayList;

//Bishop Class
public class Knight extends Piece{
	//Constructor
	public Knight(int posX, int posY, Grid grid, char color){
		super(posX, posY, grid, color);
		
		normalIcon = new ImageIcon("images/" + color + "_knight.png");
                selectedIcon = new ImageIcon("images/" + color + "_knight_selected.png");
		setSelected(false);
	}

	@Override
        public ArrayList<Tile> possibleMoves(){
		ArrayList<Tile> possibles = new ArrayList<>(); 

		//Top
		if (posY - 2 >= 0){
			if (posX - 1 >= 0){
				possibles.add(grid.grid[posX-1][posY-2]);	
			} if (posX + 1 < 8){
				possibles.add(grid.grid[posX+1][posY-2]);
			}
		}

		//Bottom
                if (posY + 2 < 8){
                        if (posX - 1 >= 0){
                                possibles.add(grid.grid[posX-1][posY+2]);
                        } if (posX + 1 < 8){
                                possibles.add(grid.grid[posX+1][posY+2]);
                        }
                }

		//Left
                if (posX - 2 >= 0){
                        if (posY - 1 >= 0){
                                possibles.add(grid.grid[posX-2][posY-1]);
                        } if (posY + 1 < 8){
                                possibles.add(grid.grid[posX-2][posY+1]);
                        }
                }

		//Right
                if (posX + 2 >= 0){
                        if (posY - 1 >= 0){
                                possibles.add(grid.grid[posX+2][posY-1]);
                        } if (posY + 1 < 8){
                                possibles.add(grid.grid[posX+2][posY+1]);
                        }
                }

		return possibles;
        }
}
