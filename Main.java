import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

import java.util.ArrayList;

//Main Class
public class Main {
	//Screen Scale Settings here
	public final int SCREEN_WIDTH;
	public final int SCREEN_HEIGHT;
	public final int TILE_SIZE;

	//Visuals
	public Painter painter;
	public JFrame frame;
	public MyMouseListener mouseListener;

	//Game
	public Grid grid;
	public ArrayList<History> history;

	//Run game
	public static void main (String[] args) {
		new Main(args[0]); //args[0] will be used for TILE_SIZE
	}

	//Constructor
	public Main(String arg){
		TILE_SIZE = Integer.valueOf(arg);
		SCREEN_WIDTH = 8*TILE_SIZE + (TILE_SIZE*3);
		SCREEN_HEIGHT = 8*TILE_SIZE;

		//Init main game variables		
		history = new ArrayList<>();
		grid = new Grid(TILE_SIZE);

		//Init visuals
		setUpFrame();
		painter = new Painter(this);
                painter.setBounds(0, 0, TILE_SIZE*8, TILE_SIZE*8);
                frame.add(painter);
		painter.repaint();

		mouseListener = new MyMouseListener(this);
		frame.addMouseListener(mouseListener);
	}

	//Set up frame object
	public void setUpFrame(){
		frame = new JFrame("Chess");
		frame.setLayout(null);
                frame.setSize(SCREEN_WIDTH, SCREEN_HEIGHT+36);
                frame.setLocationRelativeTo(null);
                frame.setResizable(false);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
                frame.setIconImage(new ImageIcon("images/w_king.png").getImage());
	}
}
