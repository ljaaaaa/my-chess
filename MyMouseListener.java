import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

//MyMouseListener Class
public class MyMouseListener implements MouseListener{

	private boolean onScreen = false;

	//Constructor
	public MyMouseListener(){

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
}
