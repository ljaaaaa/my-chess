import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.MouseInfo;
import java.awt.Point;
import javax.swing.ImageIcon;
import java.util.ArrayList;

//MyMouseListener Class
public class MyMouseListener implements MouseListener{
	private Main main; //reference to main
	enum State { NO_SELECTION, SELECTED_PIECE }	
	State state;

	//Constructor
	public MyMouseListener(Main main){
		this.main = main;
		state = State.NO_SELECTION;
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
		Point newPoints;
		Tile selected;
		
		switch (state){
			//No chess piece selected
			case NO_SELECTION: 
				//Selected tile and grid points
				newPoints = pieceCoordsSelected(e.getPoint());
				selected = main.grid.grid[newPoints.x][newPoints.y];

				//Chess piece selected
				if (selected instanceof Piece){
					//Update current state
					state = State.SELECTED_PIECE;

					//Highlight possible moves
					ArrayList<Point> possibles = ((Piece)selected).possibleMoves();
                                	highlightPossibles(possibles);
				}
				break;

			//Chess piece selected previously
			case SELECTED_PIECE: 
				Point oldPoints = getSelectedPoint();
				Tile oldSelected = main.grid.grid[oldPoints.x][oldPoints.y];

				newPoints = pieceCoordsSelected(e.getPoint());
                       		selected = main.grid.grid[newPoints.x][newPoints.y];

				if (selected.possible && oldSelected instanceof Piece){
                                	((Piece)oldSelected).move(oldPoints, newPoints);
				}

				break;
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

	public Point getSelectedPoint(){
		for (int x = 0; x < main.grid.grid.length; x++){
                        for (int y = 0; y < main.grid.grid[x].length; y++){
                                Tile tile = main.grid.grid[x][y];

                                if (tile.getSelected()){
					return new Point(x, y);
				}	
                        }
                }
		return null;
	}

	public void highlightPossibles(ArrayList<Point> possibles){
		for (int x = 0; x < possibles.size(); x++){
			main.grid.grid[possibles.get(x).x][possibles.get(x).y].possible = true;
		}
	}
}
