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
	
	private Main main; 
	State state;
	Piece lastSelected;

	//Constructor
	public MyMouseListener(Main main){
		this.main = main;
		state = State.NO_SELECTION;
		lastSelected = null;
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
					highlightPossibles(((Piece)selected).possibleMoves());
					lastSelected = (Piece)selected;
				} 
				break;

			//Chess piece selected previously
			case SELECTED_PIECE:
				updateTiles(e.getPoint());
				selected = currentSelectedTile(e.getPoint());
				updateTiles(e.getPoint());

				//Move piece
				if (lastSelected.possibleMoves().contains(selected)){
					lastSelected.move(selected.posX, selected.posY);
					state = State.NO_SELECTION;
				
				//Don't move piece
				} else {
					//New selected piece
					if (selected instanceof Piece){
						state = State.SELECTED_PIECE;

						//Highlight possible moves
                                        	highlightPossibles(((Piece)selected).possibleMoves());
						lastSelected = (Piece)selected;
					} else {
						state = State.NO_SELECTION;
					}
				}
				break;
		}
	}

	//Return selected tile
	public Tile currentSelectedTile(Point mousePoint){
		for (int x = 0; x < main.grid.grid.length; x++){
                        for (int y = 0; y < main.grid.grid[x].length; y++){
                                Tile tile = main.grid.grid[x][y];

                                if (tile.mouseOn(mousePoint)){
                                       	return tile;
                               	}
                        }
                }
		return null;
	}

	//Update tile selected and possible statuses
	public void updateTiles(Point mousePoint){
		for (int x = 0; x < main.grid.grid.length; x++){
                        for (int y = 0; y < main.grid.grid[x].length; y++){
				Tile tile = main.grid.grid[x][y];

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
}
