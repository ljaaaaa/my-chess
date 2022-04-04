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
		frame = new MyFrame("Chess");
		painter = new Painter(this);
		mouseListener = new MyMouseListener(grid, painter, frame);
	}
}
