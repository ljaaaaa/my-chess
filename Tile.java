import java.util.ArrayList;
import java.awt.Point;
import javax.swing.ImageIcon;

public class Tile {
	ImageIcon currentIcon;
	private boolean selected;
	public boolean possible;
	protected ImageIcon normalIcon;
	protected ImageIcon selectedIcon;
	Grid grid;

	//Constructor
	public Tile(Grid grid){
		this.grid = grid;
		normalIcon = new ImageIcon("images/clear.png");
		selectedIcon = new ImageIcon("images/clear_selected.png");
		currentIcon = normalIcon;
	}

	//If mouse is touching area
        public boolean mouseOn(Point p){
       		Point c = myCoords();

       		if (p.x > c.x*80 && p.x < c.x*80+80
                        && p.y > c.y*80+38 && p.y < c.y*80+80+38){
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

	//Where this tile is on grid
	protected Point myCoords(){
		for (int x = 0; x < grid.grid.length; x++){
                        for (int y = 0; y < grid.grid.length; y++){
                                if (grid.grid[x][y] == this){
                                        return new Point(x, y);
                                }
                        }
                }
		return null;
	}

	//Get selected status
	public boolean getSelected(){
		return selected;
	}
}
