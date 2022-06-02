import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Font;
import java.util.ArrayList;

//Painter Class
public class Painter extends JPanel {
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

		final int FONT_SIZE = SIZE/5;
		//Draw 1-8 and A-H on grid
		char[] letters = new char[] {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
		g.setFont(new Font("Roboto", Font.PLAIN, FONT_SIZE));

		for (int x = 0; x < grid.grid.length; x++){
			g2d.drawString(letters[x] + "", (x+1)*SIZE-FONT_SIZE, FONT_SIZE);
			g2d.drawString(x+1 + "", 0, x*SIZE+FONT_SIZE);
		}

		//Draw Pieces
		for (int x = 0; x < grid.setW.pieces.size(); x++){
			Piece piece = grid.setW.pieces.get(x);
			g2d.drawImage(piece.icon.getImage(), piece.x*SIZE, piece.y*SIZE, SIZE, SIZE, null);

		} for (int x = 0; x < grid.setB.pieces.size(); x++){
                        Piece piece = grid.setB.pieces.get(x);
                        g2d.drawImage(piece.icon.getImage(), piece.x*SIZE, piece.y*SIZE, SIZE, SIZE, null);
		}

		//Selected piece
		if (grid.selectedTile != null){
			Tile selected = grid.selectedTile;
			g2d.drawImage(new ImageIcon("images/selected.png").getImage(), selected.x*SIZE, selected.y*SIZE, SIZE, SIZE, null);

			//Draw possibles for selected
			if (selected instanceof Piece){
				ArrayList<Tile> possibles = ((Piece)selected).validPossibleMoves();
				for (int x = 0; x < possibles.size(); x++){
					Tile tile = possibles.get(x);
					
					g2d.drawImage(new ImageIcon("images/possible.png").getImage(), tile.x*SIZE, tile.y*SIZE, SIZE, SIZE, null);
				}
			}
		}
	}

	//Set checkered background
	private void setBackground(){
		bg = new ImageIcon[8][8];
		for (int x = 0; x < bg.length; x++){
                        for (int y = 0; y < bg[x].length; y++){
				bg[x][y] = new ImageIcon("images/tile" + ((x%2 + y%2)%2) + ".png");
                        }

                }
        }
}