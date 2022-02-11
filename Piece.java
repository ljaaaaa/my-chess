import java.util.ArrayList;
import java.awt.Point;

//Piece Class
public class Piece{
	int posX;
	int posY;
	final int ICONSIZE = 80;
	final int GRIDSIZE = 8;

	//Constructor
	public Piece(int posX, int posY){
		this.posX = posX;
		this.posY = posY;
	}

	//Move piece
	public void move(int newX, int newY) throws IllegalMoveException{
		
	}

	//If mouse is touching area
	public boolean mouseOn(Point p){
		if (p.x > posX*80 && p.x < posX*80+ICONSIZE 
			&& p.y > posY*80-36 && p.y < posY*80+ICONSIZE+38){
			return true;
		}

		return false;
	}

	//Check if move is valid
	protected boolean moveIsLegal(int newX, int newY){
		return false;
	}
}
