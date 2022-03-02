import java.util.ArrayList;

public class PrintPossibles {

	public ArrayList<Tile> possibleMovesRook(int posX, int posY, Grid grid, char color){
		ArrayList<Tile> possibles = new ArrayList<>(); 
		int add = 1;

		//Up
		while (posY-add >= 0){	
			possibles.add(grid.grid[posX][posY-add]);

			//Has hit a piece, stop
			if (grid.grid[posX][posY-add] instanceof Piece){
				//If piece is of own color, don't eat
				if (((Piece)grid.grid[posX][posY-add]).color == color){
					possibles.remove(possibles.size()-1);
				}
				break;
			}
			add++;
		}
		add = 1;

		//Down
		while (posY+add < 8){
                        possibles.add(grid.grid[posX][posY+add]);

                        if (grid.grid[posX][posY+add] instanceof Piece){
				//If piece is of own color, don't eat
                                if (((Piece)grid.grid[posX][posY+add]).color == color){
                                        possibles.remove(possibles.size()-1);
                                }
				break;
                        }
                        add++;
                }
		add = 1;

		//Left
		while (posX-add >= 0 ){
			possibles.add(grid.grid[posX-add][posY]);

			if (grid.grid[posX-add][posY] instanceof Piece){
				//If piece is of own color, don't eat
                                if (((Piece)grid.grid[posX-add][posY]).color == color){
                                        possibles.remove(possibles.size()-1);
                                }
				break;
			}
			add++;
		}
		add = 1;

		//Right
                while (posX+add < 8){
                        possibles.add(grid.grid[posX+add][posY]);

                        if (grid.grid[posX+add][posY] instanceof Piece){
				//If piece is of own color, don't eat
                                if (((Piece)grid.grid[posX+add][posY]).color == color){
                                        possibles.remove(possibles.size()-1);
                                }
				break;
                        }
                        add++;
                }

		return possibles;
        }
}