import javax.swing.ImageIcon;
import java.util.ArrayList;


//Pawn Class
public class Pawn extends Piece{
	public enum Direction {
                UP,
                DOWN
        }
	public Direction dir;
	
	//Construcotr
	public Pawn(int x, int y, char color){
		super(x, y, color);
		dir = color == 'w' ? Direction.DOWN : Direction.UP;
		currentIcon = new ImageIcon("images/" + color + "_pawn.png");
	}

	@Override
        public ArrayList<Tile> possibleMoves(Grid grid){
		ArrayList<Tile> possibles = new ArrayList<>(); 

	!!!Here check if all moves will put king in trouble

		switch(dir){
			//Piece is going down
			case DOWN:
				//Next tile
               			if (this.y+1 < 8 && !(grid.grid[this.x][this.y+1] instanceof Piece)){
                        		possibles.add(grid.grid[this.x][this.y+1]);

					//Next two tiles
                			if (this.y == 1 && !(grid.grid[this.x][this.y+2] instanceof Piece)){
                                		possibles.add(grid.grid[this.x][this.y+2]);
					}
				}
				
				//Diagonal tile
				if (this.y+1 < 8 && this.x+1 < 8 && (grid.grid[this.x+1][this.y+1] instanceof Piece) && ((Piece)grid.grid[this.x+1][this.y+1]).color != color){
                                        possibles.add(grid.grid[this.x+1][this.y+1]);

				//Diagonal tile
				} if (this.y+1 < 8 && this.x-1 >= 0 && (grid.grid[this.x-1][this.y+1] instanceof Piece) && ((Piece)grid.grid[this.x-1][this.y+1]).color != color){
                                        possibles.add(grid.grid[this.x-1][this.y+1]);
				}

				break;

			//Piece is going up
			case UP:
				//Next tile
                                if (this.y-1 >= 0 && !(grid.grid[this.x][this.y-1] instanceof Piece)){
                                        possibles.add(grid.grid[this.x][this.y-1]);

                                	//Next two tiles
                                	if (this.y == 6 && !(grid.grid[this.x][this.y-2] instanceof Piece)){
                                        	possibles.add(grid.grid[this.x][this.y-2]);
					}
				}
				//Diagonal tile
				if (this.y-1 >= 0 && this.x+1 < 8 && (grid.grid[this.x+1][this.y-1] instanceof Piece) && ((Piece)grid.grid[this.x+1][this.y-1]).color != color){
                                        possibles.add(grid.grid[this.x+1][this.y-1]);

				//Diagonal tile
				} if (this.y-1 >= 0 && this.x-1 >= 0 && (grid.grid[this.x-1][this.y-1] instanceof Piece) && ((Piece)grid.grid[this.x-1][this.y-1]).color != color){
                                        possibles.add(grid.grid[this.x-1][this.y-1]);
                                }

				break;
		}
		return possibles;	
	}
}
