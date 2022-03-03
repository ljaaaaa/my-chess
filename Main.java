//Main Class
public class Main {
	Grid grid;
	Painter painter;
	MyFrame frame;
	MyMouseListener mouseListener;

	//Run game
	public static void main (String[] args) {
		new Main();
	}

	//Constructor
	public Main(){
		grid = new Grid();
		painter = new Painter(grid);
		mouseListener = new MyMouseListener(painter, grid);
		frame = new MyFrame("Chess", this);
	}
}
