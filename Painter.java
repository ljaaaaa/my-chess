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
	private ImageIcon[][] bg;
        private Grid grid;
	private ArrayList<History> history;
	
	public Painter(Main main){
		this.grid = main.grid;
		this.history = main.history;
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

					if (tile instanceof Piece){ //Can be eaten tile
						g2d.drawImage(new ImageIcon("images/possible_eat.png").getImage(), tile.x*SIZE, tile.y*SIZE, SIZE, SIZE, null);

					} else if (((Piece)selected).enPassantPossible() && history.get(history.size()-1).endX == tile.x) { //Check En Passant [Special Case]
						g2d.drawImage(new ImageIcon("images/possible_eat.png").getImage(), tile.x*SIZE, tile.y*SIZE, SIZE, SIZE, null);	

					} else { //Possible to move to tile
						g2d.drawImage(new ImageIcon("images/possible.png").getImage(), tile.x*SIZE, tile.y*SIZE, SIZE, SIZE, null);
					
						//Here if En Passant highlight red instead
					}
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
