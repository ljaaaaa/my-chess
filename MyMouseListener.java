import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.MouseInfo;
import java.awt.Point;
import javax.swing.ImageIcon;
import java.util.ArrayList;

//MyMouseListener Class
public class MyMouseListener implements MouseListener{
	private Main main; //reference to main

	//Constructor
	public MyMouseListener(Main main){
		this.main = main;
	}

	@Override
        public void mousePressed(MouseEvent e) { }

        @Override
        public void mouseReleased(MouseEvent e) { }

        @Override
        public void mouseEntered(MouseEvent e) { }

        @Override
        public void mouseExited(MouseEvent e) { }

        @Override
        public void mouseClicked(MouseEvent e) {
		Tile selected = main.grid.grid[pieceCoordsSelected(e.getPoint()).x]
			[pieceCoordsSelected(e.getPoint()).y];

		//If selected tile is a chess piece
		if (selected instanceof Piece){
			ArrayList<Point> possibles = ((Piece)selected).possibleMoves();
			highlightPossibles(possibles);
		}
	}

	public Point pieceCoordsSelected(Point mousePoint){
		Point mouseOn = new Point(0, 0);

		for (int x = 0; x < main.grid.grid.length; x++){
                        for (int y = 0; y < main.grid.grid[x].length; y++){
				Tile tile = main.grid.grid[x][y];

				if (tile.mouseOn(mousePoint)){
					tile.setSelected(true);
					tile.possible = false;
					mouseOn = new Point(x, y);
				} else {
					tile.setSelected(false);
					tile.possible = false;
				}
			}
		}
		return mouseOn;
	}

	public void highlightPossibles(ArrayList<Point> possibles){
		for (int x = 0; x < possibles.size(); x++){
			main.grid.grid[possibles.get(x).x][possibles.get(x).y].possible = true;
		}
	}
}
