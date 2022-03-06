import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.MouseInfo;
import java.awt.Point;
import javax.swing.ImageIcon;
import java.util.ArrayList;

//MyMouseListener Class
public class MyMouseListener implements MouseListener{
	enum State { 
		NO_SELECTION, 
		SELECTED_PIECE 
	}	
	
	private Grid grid;
	private Painter painter;
	State state;
	Piece lastSelected;

	//Constructor
	public MyMouseListener(Grid grid, Painter painter){

		this.grid = grid;
		this.painter = painter;
		state = State.NO_SELECTION;
		lastSelected = null;
	}

	@Override
        public void mouseClicked(MouseEvent e) {
		Tile selected = null;

		switch (state){
			//No chess piece selected
			case NO_SELECTION: 
				//Selected tile and grid points
				selected = currentSelectedTile(e.getPoint());
				updateTiles(e.getPoint());

				//Chess piece selected
				if (selected instanceof Piece){
					//Update current state
					state = State.SELECTED_PIECE;

					//Highlight possible moves
					highlightPossibles(((Piece)selected).possibleMoves(grid));
					lastSelected = (Piece)selected;
				} 
				break;

			//Chess piece selected previously
			case SELECTED_PIECE:
				updateTiles(e.getPoint());
				selected = currentSelectedTile(e.getPoint());
				updateTiles(e.getPoint());

				//Move piece
				if (lastSelected.possibleMoves(grid).contains(selected)){
					lastSelected.move(grid, selected.posX, selected.posY);
					state = State.NO_SELECTION;
				
				//Don't move piece
				} else {
					//New selected piece
					if (selected instanceof Piece){
						state = State.SELECTED_PIECE;

						//Highlight possible moves
                                        	highlightPossibles(((Piece)selected).possibleMoves(grid));
						lastSelected = (Piece)selected;
					} else {
						state = State.NO_SELECTION;
					}
				}
				break;
		}
		painter.repaint();
	}

	//Return selected tile
	public Tile currentSelectedTile(Point mousePoint){
		for (int x = 0; x < grid.grid.length; x++){
                        for (int y = 0; y < grid.grid[x].length; y++){
                                Tile tile = grid.grid[x][y];

                                if (tile.mouseOn(mousePoint)){
                                       	return tile;
                               	}
                        }
                }
		return null;
	}

	//Update tile selected and possible statuses
	public void updateTiles(Point mousePoint){
		for (int x = 0; x < grid.grid.length; x++){
                        for (int y = 0; y < grid.grid[x].length; y++){
				Tile tile = grid.grid[x][y];

				//Mouse on
				if (tile.mouseOn(mousePoint)){
					tile.setSelected(true);
					tile.possible = false;
				//Mouse not on
				} else {
					tile.setSelected(false);
					tile.possible = false;
				}
			}
		}
	}

	//Highlight possibles
	public void highlightPossibles(ArrayList<Tile> possibles){
		for (int x = 0; x < possibles.size(); x++){
			possibles.get(x).possible = true;
		}
	}
	
	@Override
        public void mousePressed(MouseEvent e) { }

        @Override
        public void mouseReleased(MouseEvent e) { }

        @Override
        public void mouseEntered(MouseEvent e) { }

        @Override
        public void mouseExited(MouseEvent e) { }
}
