import javax.swing.ImageIcon;

//Pawn Class
public class Pawn extends Piece{
	ImageIcon imageIcon;

	//Constructor
	public Pawn(int posX, int posY){
		super(posX, posY);
		imageIcon = new ImageIcon("images/pawn.png");
	}

	@Override
	//Move piece
	public void move(int newX, int newY) throws IllegalMoveException{
		if (moveIsLegal(newX, newY)){
			posX = newX;
			posY = newY;
		}
	}

	@Override
	//Check if move is valid
	protected boolean moveIsLegal(int newX, int newY){
		if (newY == posY+1 && newX == posX){
			return true;	
                }

		return false;
	}
}
