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
		Tile selected = null;

		switch (state){
			//No chess piece selected
			case NO_SELECTION: 
				//Selected tile and grid points
				selected = findSelectedTile(e.getPoint());
				updateTiles(e.getPoint());

				//Chess piece selected
				if (selected instanceof Piece){
					//Update current state
					state = State.SELECTED_PIECE;

					//Highlight possible moves
					ArrayList<Tile> possibles = ((Piece)selected).possibleMoves();
                                	highlightPossibles(possibles);
				}
				break;

			//Chess piece selected previously
			case SELECTED_PIECE: 
				Tile oldSelected = getSelectedTile();
				updateTiles(e.getPoint());
				selected = findSelectedTile(e.getPoint());
				
				if (oldSelected instanceof Piece && ((Piece)oldSelected).possibleMoves().contains(selected)){
					((Piece)oldSelected).move(selected.posX, selected.posY);

				} else if (selected instanceof Piece){
					//Highlight possible moves
                                        ArrayList<Tile> possibles = ((Piece)selected).possibleMoves();
                                       	highlightPossibles(possibles);
				}
				updateTiles(e.getPoint());
				state = State.NO_SELECTION;
				break;
		}
	}

	//Return selected tile
	public Tile findSelectedTile(Point mousePoint){
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

	//Get the currently selected piece in grid
	public Tile getSelectedTile(){
		for (int x = 0; x < main.grid.grid.length; x++){
                        for (int y = 0; y < main.grid.grid[x].length; y++){
                                Tile tile = main.grid.grid[x][y];

                                if (tile.getSelected()){
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
