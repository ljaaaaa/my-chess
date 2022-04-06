import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
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
	private MyFrame frame;
	private Painter painter;
	private State state;
	private Piece lastSelected;
	private int movesSinceLastEat;

	//Constructor
	public MyMouseListener(Main main){
		grid = main.grid;
		frame = main.frame;
		painter = main.painter;
		state = State.NO_SELECTION;
		frame.addMouseListener(this);
	}

	@Override
        public void mouseClicked(MouseEvent e) {
		Tile selected = currentSelectedTile(e.getPoint());
		
		switch (state){
			//No chess piece selected previously
			case NO_SELECTION:
				//Chess piece selected
				if (selected instanceof Piece){
					state = State.SELECTED_PIECE;
					lastSelected = (Piece)selected;
					highlightPossibles(lastSelected);
				}
				break;

			//Chess piece selected previously
			case SELECTED_PIECE:
				//Move piece
				if (lastSelected.validPossibleMoves().contains(selected)){
					lastSelected.move(selected.x, selected.y); //Move last selected piece
					state = State.NO_SELECTION;
					movesSinceLastEat++;
				
					//Reset count for 50 move rule for draw
					if (selected instanceof Piece || (lastSelected instanceof Piece && lastSelected.type.equals("pawn"))){
						movesSinceLastEat = 0;
					}

				//Don't move new selected piece
				} else if (selected instanceof Piece){
                                        lastSelected = (Piece)selected;
					highlightPossibles(lastSelected);

				} else {
					state = State.NO_SELECTION;
				}
				break;
		}

		//Black Checkmate ✓
		if (grid.setW.playerLost(grid.setB)){
			frame.setTitle("Black Wins");
			frame.removeMouseListener(this);
		
		//White Checkmate ✓
		} else if (grid.setB.playerLost(grid.setW)){
			frame.setTitle("White Wins");
                        frame.removeMouseListener(this);
		
		// Draw Insufficient Material ✓
		} else if (grid.setW.drawInsufficientMaterial(painter, grid.setB)){
			frame.setTitle("Draw - Insufficient Material");
                        frame.removeMouseListener(this);
		
		//Draw Stalemate ✓
		} else if (grid.setW.drawStalemate(grid.setB) || grid.setB.drawStalemate(grid.setW)){
			frame.setTitle("Draw - Stalemate");
                        frame.removeMouseListener(this);
		
		//Draw Fifty Move Rule ✓
		} else if (movesSinceLastEat >= 100){
			frame.setTitle("Draw - 50 Move Rule");
                        frame.removeMouseListener(this);
		
		//Draw Threefold Repition.... ugh
		} else if (false){

		}

		painter.repaint();
	}

	//Return selected tile and update variables based on selection
	public Tile currentSelectedTile(Point mousePoint){
		Tile selected = null;
		
		for (int x = 0; x < grid.grid.length; x++){
                        for (int y = 0; y < grid.grid[x].length; y++){
				Tile tile = grid.grid[x][y];

				//Mouse on
				if (tile.mouseOn(mousePoint)){
					tile.selected = true;
					tile.possible = false;
					selected = tile;
				//Mouse not on
				} else {
					tile.selected = false;
					tile.possible = false;
				}
			}
		}
		return selected;
	}

	//Highlight possibles
	public void highlightPossibles(Piece selected){
		ArrayList<Tile> possibles = selected.validPossibleMoves();

		//Set boolean possible to true, so painter paints it as possible
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
