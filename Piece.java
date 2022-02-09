import java.util.ArrayList;

//Piece Class
public class Piece{
	int posX;
	int posY;
	final int GRIDSIZE = 8;

	//Constructor
	public Piece(int posX, int posY){
		this.posX = posX;
		this.posY = posY;
	}

	//Move piece
	public void move(int newX, int newY) throws IllegalMoveException{
		
	}

	//Check if move is valid
	protected boolean moveIsLegal(int newX, int newY){
		return false;
	}
}
