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
               
        }

        @Override
        public void mouseExited(MouseEvent e) {
		
        }

        @Override
        public void mouseClicked(MouseEvent e) {
		Pawn selected = main.set.pawns[pawnSelected(new Point(e.getX(), e.getY()))];
		
		if (selected.imageName == "images/pawn2.png"){
			selected.setIcon("images/pawn.png");
		} else {
			selected.setIcon("images/pawn2.png");
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
