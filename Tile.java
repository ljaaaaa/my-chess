import java.util.ArrayList;
import java.awt.Point;
import javax.swing.ImageIcon;

public class Tile {
	int posX;
	int posY;

	ImageIcon currentIcon;
	private boolean selected;
	protected ImageIcon normalIcon;
	protected ImageIcon selectedIcon;

	//Constructor
	public Tile(int posX, int posY){
		this.posX = posX;
		this.posY = posY;

		normalIcon = new ImageIcon("images/clear");
		selectedIcon = new ImageIcon("images/clear_selected");
		currentIcon = normalIcon;
	}

	//If mouse is touching area
        public boolean mouseOn(Point p){
                if (p.x > posX*80 && p.x < posX*80+80
                        && p.y > posY*80-36 && p.y < posY*80+80+38){
                        return true;
                }

                return false;
        }

	//Set selected status
	public void setSelected(boolean selected){
		this.selected = selected;

		if (selected){
			currentIcon = selectedIcon;
		} else {
			currentIcon = normalIcon;
		}
	}

	//Get selected status
	public boolean getSelected(){
		return selected;
	}
}
