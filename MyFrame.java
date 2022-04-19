import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.ImageIcon;

//MyFrame Class
public class MyFrame extends JFrame {
	
	//Constructor
	public MyFrame(String title, Main main){
		super(title);
		setLayout(new GridLayout(1, 1));
                setSize(main.SCREEN_WIDTH, main.SCREEN_HEIGHT+36);
                setLocationRelativeTo(null);
                setResizable(false);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setVisible(true);
		setIconImage(new ImageIcon("images/w_king.png").getImage());
	}
}
