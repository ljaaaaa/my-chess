import javax.swing.ImageIcon;
import java.util.ArrayList;

//Bishop Class
public class Knight extends Piece{
	
	public Knight(int x, int y, char color){
		super(x, y, color);
		
		normalIcon = new ImageIcon("images/" + color + "_knight.png");
                selectedIcon = new ImageIcon("images/" + color + "_knight_selected.png");
		setSelected(false);
		setPossibles();
	}

	@Override
        protected void setPossibles(){

	}
}
