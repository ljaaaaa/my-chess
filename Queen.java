import javax.swing.ImageIcon;
import java.util.ArrayList;

//Queen Class
public class Queen extends Piece{

	public Queen (int x, int y, char color){
		super(x, y, color);
		normalIcon = new ImageIcon("images/" + color + "_rook.png");
                selectedIcon = new ImageIcon("images/" + color + "_rook_selected.png");
		setSelected(false);
		setPossibles();
	}

	@Override
	protected void setPossibles(){
	
	}
}	
