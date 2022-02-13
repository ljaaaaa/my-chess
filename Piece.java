import java.util.ArrayList;
import java.awt.Point;
import javax.swing.ImageIcon;

//Piece Class
public class Piece{
	int posX;
	int posY;
	final int ICONSIZE = 80;
	final int GRIDSIZE = 8;
	String imageName;
	ImageIcon imageIcon;

	//Constructor
	public Piece(int posX, int posY){
		this.posX = posX;
		this.posY = posY;
	}

	//Sets image and imagename
	public void setIcon(String imageName){
                this.imageName = imageName;
                imageIcon = new ImageIcon(imageName);
        }

	//If mouse is touching area
	public boolean mouseOn(Point p){
		if (p.x > posX*80 && p.x < posX*80+ICONSIZE 
			&& p.y > posY*80-36 && p.y < posY*80+ICONSIZE+38){
			return true;
		}

		return false;
	}

	//Returns all possible move coordinates
	public ArrayList<Point> possibleMoves(){
		return new ArrayList<Point>();
	}
}
