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
		main.grid.printGrid();
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
		Tile selected = findSelectedTile(e.getPoint());;

		System.out.println(selected);

		if (selected != null){
			selected.setSelected(true);
		}

		/*
		switch (state){
			//No chess piece selected
			case NO_SELECTION: 
				//Selected tile and grid points
				selected = findSelectedTile(e.getPoint());

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
                       		selected = findSelectedTile(e.getPoint());

				if (selected.possible && (oldSelected instanceof Piece)){
                                	((Piece)oldSelected).move(selected.posX, selected.posY);
				}
				state = State.NO_SELECTION;
				break;
		}
		*/
	}

	//Returns selected piece by mouse
	public Tile findSelectedTile(Point mousePoint){
		Tile selected = null;
		
		for (int x = 0; x < main.grid.grid.length; x++){
                        for (int y = 0; y < main.grid.grid[x].length; y++){
				Tile tile = main.grid.grid[x][y];

				//Mouse on
				if (tile.mouseOn(mousePoint)){
					tile.setSelected(true);
					tile.possible = false;
					selected = tile;
					System.out.println("bok");
			
				//Mouse not on
				} else {
					tile.setSelected(false);
					tile.possible = false;
				}
			}
		}
		return selected;
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

	//Highlight possibles
	public void highlightPossibles(ArrayList<Tile> possibles){
		for (int x = 0; x < possibles.size(); x++){
			possibles.get(x).possible = true;
		}
	}
}
