import java.util.ArrayList;

//Main Class
public class Main {
	public Grid grid; //Grid on where game is played
	public ArrayList<History> history; //Running list of moves
	public Painter painter; //In charge of GUI
	public MyFrame frame; //Frame which painter paints on
	public MyMouseListener mouseListener; //Responds to mouse clicks

	//Run game
	public static void main (String[] args) {
		new Main();
	}

	//Constructor
	public Main(){
		history = new ArrayList<>();
		grid = new Grid(this);
		frame = new MyFrame("Chess");
		painter = new Painter(this);
		mouseListener = new MyMouseListener(this);
	}
}
