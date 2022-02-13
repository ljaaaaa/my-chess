import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.MouseInfo;
import java.awt.Point;
import javax.swing.ImageIcon;

//MyMouseListener Class
public class MyMouseListener implements MouseListener{
	private boolean onScreen = false;
	private Main main;

	//Constructor
	public MyMouseListener(Main main){
		this.main = main;
	}

	@Override
        public void mousePressed(MouseEvent e) {
		
        }

        @Override
        public void mouseReleased(MouseEvent e) {
		
        }

        @Override
        public void mouseEntered(MouseEvent e) {
                onScreen = true;
        }

        @Override
        public void mouseExited(MouseEvent e) {
		onScreen = false;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
		Pawn selected = main.set.pawns[pawnSelected(getMousePosition())];
		
		if (selected.imageName == "images/pawn2.png"){
			selected.setIcon("images/pawn.png");
		} else {
			selected.setIcon("images/pawn2.png");
		}
	}

	public Point getMousePosition() {	
		if (onScreen){
			int posX = MouseInfo.getPointerInfo().getLocation().x - main.frame.getLocationOnScreen().x;
 			int posY = MouseInfo.getPointerInfo().getLocation().y - main.frame.getLocationOnScreen().y;
			return new Point(posX, posY);
		} else {
			return new Point(-1, -1);
		}
	}

	public int pawnSelected(Point mouse){
		for (int x = 0; x < main.set.pawns.length; x++){
			if (main.set.pawns[x].mouseOn(mouse)){
                                return x;
                        }
		}
		return -1;
	}
}
