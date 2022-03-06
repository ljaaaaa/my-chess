import javax.swing.ImageIcon;
import java.util.ArrayList;

//Bishop Class
public class Bishop extends Piece{
	//Constructor
	public Bishop(int posX, int posY, char color){
		super(posX, posY, color);
		
		normalIcon = new ImageIcon("images/" + color + "_bishop.png");
                selectedIcon = new ImageIcon("images/" + color + "_bishop_selected.png");
		setSelected(false);
	}

	@Override
        public ArrayList<Tile> possibleMoves(Grid grid){
		ArrayList<Tile> possibles = new ArrayList<>(); 
		int add = 1;

		//Diagonal left up, right up, left down, right down
		int[][] moves = new int[][] { {-1, -1}, {1, -1}, {-1, 1}, {1, 1} };

		for (int x = 0; x < moves.length; x++){

		}

		//Diagonal up left
		while (posY-add >= 0 && posX-add >= 0){	
			possibles.add(grid.grid[posX-add][posY-add]);

			//Has hit a piece, stop
			if (grid.grid[posX-add][posY-add] instanceof Piece){
				//If piece is of own color, don't eat
				if (((Piece)grid.grid[posX-add][posY-add]).color == color){
					possibles.remove(possibles.size()-1);
				}
				break;
			}
			add++;
		}
		add = 1;

		//Diagonal up right
		while (posY-add >= 0 && posX+add < 8){
                        possibles.add(grid.grid[posX+add][posY-add]);

                        if (grid.grid[posX+add][posY-add] instanceof Piece){
				//If piece is of own color, don't eat
                                if (((Piece)grid.grid[posX+add][posY-add]).color == color){
                                        possibles.remove(possibles.size()-1);
                                }
				break;
                        }
                        add++;
                }
		add = 1;

		//Diagonal down left
		while (posY+add < 8 && posX-add >= 0 ){
			possibles.add(grid.grid[posX-add][posY+add]);

			if (grid.grid[posX-add][posY+add] instanceof Piece){
				//If piece is of own color, don't eat
                                if (((Piece)grid.grid[posX-add][posY+add]).color == color){
                                        possibles.remove(possibles.size()-1);
                                }
				break;
			}
			add++;
		}
		add = 1;

		//Diagonal down right
                while (posY+add < 8 && posX+add < 8){
                        possibles.add(grid.grid[posX+add][posY+add]);

                        if (grid.grid[posX+add][posY+add] instanceof Piece){
				//If piece is of own color, don't eat
                                if (((Piece)grid.grid[posX+add][posY+add]).color == color){
                                        possibles.remove(possibles.size()-1);
                                }
				break;
                        }
                        add++;
                }

		return possibles;
        }
}
