import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.ImageIcon;

import java.awt.Graphics;
import java.awt.Graphics2D;

public class Painter extends JPanel {
	private ImageIcon[][] bg;
        private Player player;

	public Painter(Player player){
		this.player = player;
		setBackground();
	}

	@Override
        protected void paintComponent(Graphics g){
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D)g;

		//Draw background
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

	private void setBackground(){
		bg = new ImageIcon[8][8];
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
