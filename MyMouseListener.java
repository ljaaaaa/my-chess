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
					highlightPossibles((Piece)selected);
					lastSelected = (Piece)selected;
				} 
				break;

			//Chess piece selected previously
			case SELECTED_PIECE:
				updateTiles(e.getPoint());
				selected = currentSelectedTile(e.getPoint());

				//Move piece
				if (((Rook)lastSelected).isPossibleMove(selected.posX, selected.posY)){
					lastSelected.move(selected.posX, selected.posY);
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
        public void highlightPossibles(Piece piece){
		ArrayList<C> possibles = piece.possibles[piece.posX][piece.posY].list;
		for (int x = 0; x < possibles.size(); x++){
			main.grid.grid[possibles.get(x).x][possibles.get(x).y].possible = true;
		}
        }

	//Print possibles
	public void printPossibles(Piece piece, ArrayList<Tile> possibles){
		System.out.print("possibles[" + piece.posX + "][" + piece.posY + "] = new CList(");
		for (int x = 0; x < possibles.size(); x++){
			if (x == possibles.size()-1){
			System.out.print("new C(" + possibles.get(x).posX + ", " + possibles.get(x).posY + "));");
			} else {
				System.out.print("new C(" + possibles.get(x).posX + ", " + possibles.get(x).posY + "), ");
			}
		}
		System.out.println();
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
