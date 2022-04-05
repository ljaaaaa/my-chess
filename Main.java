//Main Class
public class Main {
	public Grid grid;
	public Painter painter;
	public MyFrame frame;
	public MyMouseListener mouseListener;

	//Run game
	public static void main (String[] args) {
		new Main();
	}

	//Constructor
	public Main(){
		grid = new Grid();
		frame = new MyFrame("Chess");
		painter = new Painter(this);
		mouseListener = new MyMouseListener(this);
	}
}
