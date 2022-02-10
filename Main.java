import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
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
		
	}

	//Constructor
	public Main(){
		player = new Player();
		painter = new Painter(player);
		frame = new MyFrame("Chess");
		mouseListener = new MyMouseListener(frame);
		frame.setUp(this);
	
		Timer timer = new Timer(1000, this);
		timer.start();
	}
}
