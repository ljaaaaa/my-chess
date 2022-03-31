import java.util.ArrayList;
import javax.swing.ImageIcon;

//Piece Class
public class Piece extends Tile{
	public final char color;
	public String type;
	private Grid grid;
	int[][] moves; //Possible moves for piece

	//Constructor
	public Piece(int x, int y, char color, String type, Grid grid){
		super(x, y);
		this.grid = grid;
		this.color = color;
		this.type = type;
		icon = new ImageIcon("images/" + color + "_" + type + ".png");
	
		switch (type){
			case "pawn":
				if (color == 'w'){ //Down
					moves = new int[][] { {0, 1}, {0, 2}, {-1, 1}, {1, 1}, {1}};
		
				} else { //Up
					moves = new int[][] { {0, -1}, {0, -2}, {-1, -1}, {1, -1}, {6}};
				}

				break;
			case "bishop":
				moves = new int[][] { {-1, -1}, {1, -1}, {-1, 1}, {1, 1} };
				break;
			case "knight":
				moves = new int[][] { {-2, -1}, {-1, -2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}, {-1, 2}, {-2, 1} };
				break;
			case "rook": 
				moves = new int[][] { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
				break;
			case "queen":
				moves = new int[][] { {-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {1, -1}, {-1, 1}, {1, 1} };
				break;
			case "king":
				moves = new int[][] { {-1, -1}, {0, -1}, {1, -1}, {-1, 0}, {1, 0}, {-1, 1}, {0, 1}, {1, 1} };
				break;
		}
	}

	//Returns all possible move coordinates
	public ArrayList<Tile> possibleMoves(){
		ArrayList<Tile> possibles = new ArrayList<Tile>();
			
		//Loop in line for each possible
		if (type == "bishop" || type == "rook" || type == "queen"){
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

		//Only loop through possibilities
		} else if (type == "knight" || type == "king"){
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
		//Pawn
		} else { //Forward
			if (this.y+moves[0][1] < 8 && this.y+moves[0][1] >= 0 && 
					!(grid.grid[this.x][this.y+moves[0][1]] instanceof Piece)){
				possibles.add(grid.grid[this.x][this.y+moves[0][1]]);

				//Next two tiles
				if (this.y == moves[4][0] && !(grid.grid[this.x][this.y+moves[1][1]] instanceof Piece)){
					possibles.add(grid.grid[this.x][this.y+moves[1][1]]);
				}
			}

			//Diagonal
			if (this.y+moves[2][1] < 8 && this.y+moves[2][1] >= 0 && this.x+moves[2][0] < 8 && this.x+moves[2][0] >= 0 &&
					(grid.grid[this.x+moves[2][0]][this.y+moves[2][1]] instanceof Piece) && ((Piece)grid.grid[this.x+moves[2][0]][this.y+moves[2][1]]).color != color){
				possibles.add(grid.grid[this.x+moves[2][0]][this.y+moves[2][1]]);

			}

			//Diagonal
                        if (this.y+moves[3][1] < 8 && this.y+moves[3][1] >= 0 && this.x+moves[3][0] < 8 && this.x+moves[3][0] >= 0 &&
                                        (grid.grid[this.x+moves[3][0]][this.y+moves[3][1]] instanceof Piece) && ((Piece)grid.grid[this.x+moves[3][0]][this.y+moves[3][1]]).color != color){
                                possibles.add(grid.grid[this.x+moves[3][0]][this.y+moves[3][1]]);
			}
		}
		return possibles;	
	}

	//Move tile to new location
	public void move(int newX, int newY){

		if (grid.grid[newX][newY] instanceof Piece){ //Removed piece eaten from array
			Set otherSet = color == 'w' ? grid.setB : grid.setW;
			
			for (int x = 0; x < otherSet.pieces.size(); x++){
				if (otherSet.pieces.get(x) == grid.grid[newX][newY]){
					otherSet.pieces.remove(x);
				}
			}	

		}

		grid.grid[newX][newY] = this;
		grid.grid[this.x][this.y] = new Tile(this.x, this.y);
		this.x = newX;
		this.y = newY;
	}

	public boolean movePutsOwnKingInDanger(int newX, int newY){
		Grid dummy = grid.getDummyGrid();

		((Piece)dummy.grid[this.x][this.y]).move(newX, newY);

		Set thisSet = color == 'w' ? dummy.setW : dummy.setB;
		Set otherSet = color == 'w' ? dummy.setB : dummy.setW;

		if (thisSet.kingCanBeEaten(otherSet)){ //Will put king in danger
			return true;
		}
		return false;
	}
}
