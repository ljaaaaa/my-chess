import java.util.ArrayList;

public class Piece {
	int posX;
	int posY;

	public Piece(int posX, int posY){
		this.posX = posX;
		this.posY = posY;
	}

	public void move(){

	}

	public ArrayList<Coords> possibleMoves(){
		return new ArrayList<Coords>();
	}
}
