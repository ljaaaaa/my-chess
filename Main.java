import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.Timer;

//Main Class
public class Main implements ActionListener{
	Player player;
	Painter painter;
	MyFrame frame;
	MyMouseListener mouseListener;

	//Run game
	public static void main (String[] args) {
		new Main();
	}

	public void actionPerformed(ActionEvent e){
		for (Pawn pawn : player.set.pawns){
			Point mPoint = mouseListener.getMousePosition();
                	if (mPoint.x != -1 && pawn.mouseOn(mPoint)){
                                pawn.imageIcon = new ImageIcon("images/pawn2.png");
                        } else {
                                pawn.imageIcon = new ImageIcon("images/pawn.png");
                	}
		}
		painter.repaint();
	}

	//Constructor
	public Main(){
		player = new Player();
		painter = new Painter(player);
		frame = new MyFrame("Chess");
		mouseListener = new MyMouseListener(frame);
		frame.setUp(this);
	
		Timer timer = new Timer(10, this);
		timer.start();
	}
}
