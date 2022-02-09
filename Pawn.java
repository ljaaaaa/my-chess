import javax.swing.ImageIcon;

public class Pawn extends Piece{
	ImageIcon imageIcon;

	public Pawn(int posX, int posY){
		super(posX, posY);
		imageIcon = new ImageIcon("images/pawn.png");
	}

	@Override
	public void move(int newX, int newY) throws IllegalMoveException{
		if (moveIsLegal(newX, newY)){
			posX = newX;
			posY = newY;
		}
	}

	@Override
	protected boolean moveIsLegal(int newX, int newY){
		if (newY == posY+1 && newX == posX){
			return true;	
                }

		return false;
	}
}
