import java.util.ArrayList;

//Main Class
public class Main {
	//Screen Scale Settings here
	public final int SCREEN_WIDTH;
	public final int SCREEN_HEIGHT;
	public final int TILE_SIZE;

	public Grid grid; //Grid on where game is played
	public ArrayList<History> history; //Running list of moves
	public Painter painter; //In charge of GUI
	public MyFrame frame; //Frame which painter paints on
	public MyMouseListener mouseListener; //Responds to mouse clicks

	//Run game
	public static void main (String[] args) {
		new Main(args[0]); //args[0] will be used for TILE_SIZE
	}

	//Constructor
	public Main(String arg){
		TILE_SIZE = Integer.valueOf(arg);
		SCREEN_WIDTH = 8*TILE_SIZE + (TILE_SIZE*3);
		SCREEN_HEIGHT = 8*TILE_SIZE;
		
		history = new ArrayList<>();
		grid = new Grid(history, TILE_SIZE);
		frame = new MyFrame("Chess", this);
		painter = new Painter(this);
		mouseListener = new MyMouseListener(this);

		//JPanel historyPanel = new JPanel();

	}
}
