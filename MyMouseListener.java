import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.MouseInfo;
import java.awt.Point;

//MyMouseListener Class
public class MyMouseListener implements MouseListener{
	private boolean onScreen = false;
	private MyFrame frame;

	//Constructor
	public MyMouseListener(MyFrame frame){
		this.frame = frame;
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
		
        }

	public Point getMousePosition() {	
		if (onScreen){
			int posX = MouseInfo.getPointerInfo().getLocation().x - frame.getLocationOnScreen().x;
 			int posY = MouseInfo.getPointerInfo().getLocation().y - frame.getLocationOnScreen().y;
			return new Point(posX, posY);
		} else {
			return new Point(-1, -1);
		}
	}
}
