import java.util.ArrayList;

public class Piece{
	int posX;
	int posY;

	final int GRIDSIZE = 8;

	public Piece(int posX, int posY){
		this.posX = posX;
		this.posY = posY;
	}

	public void move(int newX, int newY) throws IllegalMoveException{
		
	}

	//Move is a legal chess move for specific piece
	protected boolean moveIsLegal(int newX, int newY){
		return false;
	}
}
