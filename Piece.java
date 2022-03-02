import java.util.ArrayList;

//Piece Class
public class Piece extends Tile{
	public final char color;
	public CList[][] possibles;

	//Constructor
	public Piece(int x, int y, char color){
		super(x, y);
		this.color = color;
		setSelected(false);
		possibles = new CList[8][8];
	}

	//Move tile to new location
	public void move(Grid grid, int x, int y){
		grid.grid[this.x][this.y] = new Tile(this.x, this.y);
		grid.grid[x][y] = this;
		this.x = x;
		this.y = y;
	}

	//Tell if a move is possible
	public boolean isValidMoveLocation(Grid grid, int x, int y){
		ArrayList<C> list = possibles[this.x][this.y].list;
	
		for (int i = 0; i < list.size(); i++){
                        if (list.get(i).x == x && list.get(i).y == y){
                                return true;
                        }
                }
                return false;
	}

	//Set all possible moves for each grid position
	protected void setPossibles(){

	}
}
