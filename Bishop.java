import javax.swing.ImageIcon;
import java.util.ArrayList;

//Bishop Class
public class Bishop extends Piece{
	//Constructor
	public Bishop(int x, int y, char color){
		super(x, y, color);
		
		normalIcon = new ImageIcon("images/" + color + "_bishop.png");
                selectedIcon = new ImageIcon("images/" + color + "_bishop_selected.png");
		setSelected(false);
		setPossibles();
	}

	@Override
        protected void setPossibles(){

	}
}
