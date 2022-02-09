import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Main implements ActionListener{
	Player player;
	Painter painter;
	MyFrame frame;

	public static void main (String[] args) {
		new Main();
	}

	public Main(){
		player = new Player();
		painter = new Painter(player);
		frame = new MyFrame("Chess", painter);
	
		Timer timer = new Timer(200, this);
                timer.start();
	}

	public void actionPerformed(ActionEvent event){	
		painter.repaint();
                Toolkit.getDefaultToolkit().sync();
	}
}
