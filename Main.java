//Main Class
public class Main {
	//Player itself
	Player player;

	//paintComponent() that paints to JFrame
	Painter painter; 

	//Frame itself
	MyFrame frame;

	//Mouse listener
	MyMouseListener mouseListener;

	//Run game
	public static void main (String[] args) {
		new Main();
	}

	//Constructor
	public Main(){
		player = new Player();
		painter = new Painter(player);
		mouseListener = new MyMouseListener();
		frame = new MyFrame("Chess", this);
	}
}
