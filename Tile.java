import java.util.ArrayList;
import java.awt.Point;
import javax.swing.ImageIcon;

//Tile Class
public class Tile {
	public ImageIcon icon;
	public boolean possible;
	public boolean selected;
	public final int SIZE = 100; //Icon size
	public static final int STATIC_SIZE = 100;
	
	protected int x;
	protected int y;
	
	//Constructor
	public Tile(int x, int y){
		this.x = x;
		this.y = y;
		icon = new ImageIcon("images/clear.png");
	}

	//If mouse is touching area
        public boolean mouseOn(Point mouse){
       		if (mouse.x >= this.x*SIZE && mouse.x <= this.x*SIZE+SIZE
                        && mouse.y >= this.y*SIZE+38 && mouse.y <= this.y*SIZE+SIZE+38){
                        return true;
                }
                return false;
        }

	//Return copy of this object
	public Tile getCopy(){
		return new Tile(this.x, this.y);
	}
}
