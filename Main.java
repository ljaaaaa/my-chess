import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.DefaultListModel;
import java.awt.GridLayout;
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
	public JList<String> historyList;

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
		grid = new Grid(this);

		//Init visuals
		setUpFrame();
		painter = new Painter(this);
                painter.setBounds(0, 0, TILE_SIZE*8, TILE_SIZE*8);
                frame.add(painter);
		painter.repaint();

		//Set history panel
                JPanel historyPanel = new JPanel();
		historyPanel.setLayout(null);
		historyPanel.setBounds(TILE_SIZE*8, 0, TILE_SIZE*3, TILE_SIZE*8);
		frame.add(historyPanel);
                
                historyList = new JList<>(new DefaultListModel<>());

		JScrollPane scrollPane = new JScrollPane(historyList);

                scrollPane.setBounds(10, 10, TILE_SIZE*3-20, TILE_SIZE*8-20);
		historyPanel.add(scrollPane);

		//Add mouse listener
		mouseListener = new MyMouseListener(this);
		frame.addMouseListener(mouseListener);
	}

	//Update historyList panel
	public void updateHistoryModel(){
		((DefaultListModel<String>) historyList.getModel()).addElement(history.get(history.size()-1).color + " : " + history.get(history.size()-1).move);
	}

	//Set up frame object
	private void setUpFrame(){
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
