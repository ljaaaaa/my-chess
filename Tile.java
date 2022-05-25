import java.util.ArrayList;
import java.awt.Point;
import javax.swing.ImageIcon;

//Tile Class
public class Tile {
	public ImageIcon icon;
	public final int TILE_SIZE;
	protected int x;
	protected int y;
	
	//Constructor
	public Tile(int x, int y, int TILE_SIZE){
		this.x = x;
		this.y = y;
		this.TILE_SIZE = TILE_SIZE;
		icon = new ImageIcon("no image for blank tiles :/");
	}

	//Get this square's chess notation
	public String getNotation(){
                char[] letters = new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
                return letters[x] + "" + (y+1);
	}

	//If mouse is touching area
        public boolean mouseOn(Point mouse){
       		if (mouse.x >= this.x*TILE_SIZE && mouse.x <= this.x*TILE_SIZE+TILE_SIZE &&
                        mouse.y >= this.y*TILE_SIZE+38 && mouse.y <= this.y*TILE_SIZE+TILE_SIZE+38){
                        return true;
                }
                return false;
        }
}
