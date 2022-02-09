import java.awt.GridLayout;
import javax.swing.JFrame;

public class MyFrame extends JFrame {
	public final int WIDTH = 640;
	public final int HEIGHT = 640 + 36; 

	public MyFrame(String title, Painter painter){
		super(title);
                setLayout(new GridLayout(1, 1));
		add(painter);
                setSize(WIDTH, HEIGHT);
                setLocationRelativeTo(null);
                setResizable(false);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setVisible(true);
	}
}
