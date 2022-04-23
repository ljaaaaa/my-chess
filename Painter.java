import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.Color;
import java.util.ArrayList;

//Painter Class
public class Painter extends JPanel {
	public String[][] bgImages;
	private ImageIcon[][] bg;
        private Grid grid;
	
	public Painter(Main main){
		this.grid = main.grid;
		setBackground();
	}

	@Override
        protected void paintComponent(Graphics g){
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D)g;
		final int SIZE = grid.grid[0][0].TILE_SIZE;

		//Draw background
                for (int x = 0; x < bg.length; x++){
                        for (int y = 0; y < bg[x].length; y++){
                                g2d.drawImage(bg[x][y].getImage(), x*SIZE, y*SIZE, SIZE, SIZE, null);
                        }
                }

		//Draw grid
		Tile[][] tiles = grid.grid;
                for (int x = 0; x < tiles.length; x++){
                       	for (int y = 0; y < tiles[x].length; y++){
				g2d.drawImage(tiles[x][y].icon.getImage(), tiles[x][y].x*SIZE, tiles[x][y].y*SIZE, SIZE, SIZE, null);

				//Selected piece
				if (tiles[x][y].selected){
					g2d.drawImage(new ImageIcon("images/selected.png").getImage(), x*SIZE, y*SIZE, SIZE, SIZE, null);
				}	

				//Possible to move to
				if (tiles[x][y].possible){
					//Possible to eat
					if (tiles[x][y] instanceof Piece){
						g2d.drawImage(new ImageIcon("images/possible_eat.png").getImage(), x*SIZE, y*SIZE, SIZE, SIZE, null);
						
					} else {
						g2d.drawImage(new ImageIcon("images/possible.png").getImage(), x*SIZE, y*SIZE, SIZE, SIZE, null);
					}
				}
			}
		} 
	}

	//Set checkered background
	private void setBackground(){
		bg = new ImageIcon[8][8];
                bgImages = new String[8][8];
		for (int x = 0; x < bg.length; x++){
                        for (int y = 0; y < bg[x].length; y++){
                                int num = y%2 + x%2;
                                if (num > 1){
                                        num = 0;
                                }
				bgImages[x][y] = "images/tile" + num + ".png";
				bg[x][y] = new ImageIcon(bgImages[x][y]);
                        }

                }
        }
}
