import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.MouseInfo;
import java.awt.Point;
import javax.swing.ImageIcon;
import java.util.ArrayList;

//MyMouseListener Class
public class MyMouseListener implements MouseListener{
	private enum State { 
		NO_SELECTION, 
		SELECTED_PIECE 
	}		
	private Grid grid; 
	private Painter painter;
	private State state;
	private Piece lastSelected;

	//Constructor
	public MyMouseListener(Painter painter, Grid grid){
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
				selected = currentSelectedTile(e.getPoint());
				updateTiles(e.getPoint());

				//Chess piece selected
				if (selected instanceof Piece){
					state = State.SELECTED_PIECE;

					//Highlight possible moves
					highlightPossibles((Piece)selected);
					lastSelected = (Piece)selected;
				} 
				break;

			//Chess piece selected previously
			case SELECTED_PIECE:
				updateTiles(e.getPoint());
				selected = currentSelectedTile(e.getPoint());

				//Move piece
				System.out.println("hey");
				if (lastSelected.isValidMoveLocation(grid, selected.x, selected.x)){
					System.out.println("waaa");
					lastSelected.move(grid, selected.x, selected.y);
					state = State.NO_SELECTION;
				
				//Don't move piece
				} else {
					//New selected piece
					if (selected instanceof Piece){
						state = State.SELECTED_PIECE;

						//Highlight possible moves
                                        	highlightPossibles((Piece)selected);
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
                                if (grid.grid[x][y].mouseOn(mousePoint)){
                                       	return grid.grid[x][y];
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
        public void highlightPossibles(Piece piece){
		ArrayList<C> possibles = piece.possibles[piece.x][piece.y].list;
		for (int x = 0; x < possibles.size(); x++){
			grid.grid[possibles.get(x).x][possibles.get(x).y].possible = true;
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
