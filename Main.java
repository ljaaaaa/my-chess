import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Main extends JPanel implements ActionListener{
	ImageIcon[][] bg = new ImageIcon[8][8];
	Player player = new Player();

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

                for (int x = 0; x < bg.length; x++){
                        for (int y = 0; y < bg[x].length; y++){
                                g2d.drawImage(bg[x][y].getImage(), x*80, y*80, null);
                        }
                }

		//Draw pawns
		for (int x = 0; x < player.set.pawns.length; x++){
			int posX = player.set.pawns[x].posX;
			int posY = player.set.pawns[x].posY;
			
			g2d.drawImage(player.set.pawns[x].imageIcon.getImage(), posX*80, posY*80, null);
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

		setBackground();

                Timer timer = new Timer(200, this);
                timer.start();
        }

	public void setBackground(){
		for (int x = 0; x < bg.length; x++){
                        for (int y = 0; y < bg[x].length; y++){
                                int num = y%2 + x%2;
                                if (num > 1){
                                        num = 0;
                                }
                                bg[x][y] = new ImageIcon("images/tile" + num + ".png");
                        }

                }
	}
}
