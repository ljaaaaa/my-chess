import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Main extends JPanel implements ActionListener{
	ImageIcon[][] grid = new ImageIcon[8][8];
	
	public static void main (String[] args) {
		new Main().setUpGame();
	}

	public void actionPerformed(ActionEvent event){	
		repaint();
                Toolkit.getDefaultToolkit().sync();
	}

	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
                Graphics2D g2d = (Graphics2D)g;

		drawGrid();
                for (int x = 0; x < grid.length; x++){
                        for (int y = 0; y < grid[x].length; y++){
                                g2d.drawImage(grid[x][y].getImage(), x*80, y*80, null);
                        }
                }
	}

	public void setUpGame(){	
		JFrame f = new JFrame("Chess");
		f.setLayout(new GridLayout(1, 1));
		f.add(this);
                f.setSize(640, 676);
                f.setLocationRelativeTo(null);
                f.setResizable(false);
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setVisible(true);

                Timer timer = new Timer(200, this);
                timer.start();
        }

	public void drawGrid(){          
                for (int x = 0; x < grid.length; x++){
                        for (int y = 0; y < grid[x].length; y++){
                                int num = y%2 + x%2;
                                if (num > 1){
                                        num = 0;
                                }
                                grid[x][y] = new ImageIcon("images/tile" + num + ".png");
                        }
                }
	}
}
