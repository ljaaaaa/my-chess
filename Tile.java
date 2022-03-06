import java.util.ArrayList;
import java.awt.Point;
import javax.swing.ImageIcon;

public class Tile {
	ImageIcon currentIcon;
	boolean possible;
	private boolean selected;
	protected ImageIcon normalIcon;
	protected ImageIcon selectedIcon;
	protected int posX;
	protected int posY;

	//Constructor
	public Tile(int posX, int posY){
		this.posX = posX;
		this.posY = posY;
		normalIcon = new ImageIcon("images/clear.png");
		selectedIcon = new ImageIcon("images/clear_selected.png");
		currentIcon = normalIcon;
	}

	//If mouse is touching area
        public boolean mouseOn(Point mouse){
       		if (mouse.x > posX*80 && mouse.x < posX*80+80
                        && mouse.y > posY*80+38 && mouse.y < posY*80+80+38){
                        return true;
                }

                return false;
        }

	//Set selected status
	public void setSelected(boolean selected){
		this.selected = selected;

		currentIcon = selected ? selectedIcon : normalIcon;
	}
	
	//Get selected status
	public boolean getSelected(){
		return selected;
	}
}
