import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Graphics2D;

//Painter Class
public class Painter extends JPanel {
	//Background images
	private ImageIcon[][] bg;
        private Grid grid;

	public Painter(Grid grid){
		this.grid = grid;
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

		//Draw grid
		Tile[][] tiles = grid.grid;
                for (int x = 0; x < tiles.length; x++){
                       	for (int y = 0; y < tiles[x].length; y++){
				g2d.drawImage(tiles[x][y].currentIcon.getImage(), x*80, y*80, null);
			}
		}
        }

	//Set checkered background
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
