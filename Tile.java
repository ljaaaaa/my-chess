import java.util.ArrayList;
import java.awt.Point;
import javax.swing.ImageIcon;

public class Tile {
	public boolean possible;
	public ImageIcon currentIcon;
	private boolean selected;
	protected ImageIcon normalIcon;
	protected ImageIcon selectedIcon;
	protected int x;
	protected int y;

	//Constructor
	public Tile(int x, int y){
		this.x = x;
		this.y = y;
		normalIcon = new ImageIcon("images/clear.png");
		selectedIcon = new ImageIcon("images/clear_selected.png");
		currentIcon = normalIcon;
	}

	//If mouse is touching area
        public boolean mouseOn(Point mouse){
       		if (mouse.x >= this.x*80 && mouse.x <= this.x*80+80
                        && mouse.y >= this.y*80+38 && mouse.y <= this.y*80+80+38){
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
