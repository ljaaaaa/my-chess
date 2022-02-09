import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.Timer;

//Main Class
public class Main implements ActionListener{
	//Player itself
	Player player;

	//paintComponent() that paints to JFrame
	Painter painter; 

	//Frame itself
	MyFrame frame;

	//Run game
	public static void main (String[] args) {
		new Main();
	}

	//Constructor
	public Main(){
		player = new Player();
		painter = new Painter(player);
		frame = new MyFrame("Chess", painter);
	
		//Start running every 1/5 second
		Timer timer = new Timer(200, this);
                timer.start();
	}

	//Thread running every 1/5 second
	public void actionPerformed(ActionEvent event){	
		painter.repaint();
                Toolkit.getDefaultToolkit().sync();
	}
}
