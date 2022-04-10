import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.ImageIcon;

//MyFrame Class
public class MyFrame extends JFrame {
	public final int WIDTH = 8*Tile.STATIC_SIZE; //Screen width
	public final int HEIGHT = 8*Tile.STATIC_SIZE + 36; //Screen height

	//Constructor
	public MyFrame(String title){
		super(title);
		setLayout(new GridLayout(1, 1));
                setSize(WIDTH, HEIGHT);
                setLocationRelativeTo(null);
                setResizable(false);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setVisible(true);
		setIconImage(new ImageIcon("images/w_king.png").getImage());
	}
}
