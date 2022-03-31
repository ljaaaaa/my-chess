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
	private boolean gameOver;

	//Constructor
	public MyMouseListener(Grid grid, Painter painter, MyFrame frame){
		this.grid = grid;
		this.frame = frame;
		this.painter = painter;
		state = State.NO_SELECTION;
		frame.addMouseListener(this);
                frame.setTitle("Chess");
	}

	@Override
        public void mouseClicked(MouseEvent e) {
		Tile selected = currentSelectedTile(e.getPoint());
		
		switch (state){
			//No chess piece selected
			case NO_SELECTION:
				//Chess piece selected
				if (selected instanceof Piece){
					state = State.SELECTED_PIECE;
					lastSelected = (Piece)selected;
					lastSelected.possibleMoves();
				}
				break;

			//Chess piece selected previously
			case SELECTED_PIECE:
				//Move selected piece
				if (lastSelected.possibleMoves().contains(selected)){
					lastSelected.move(selected.x, selected.y);
					state = State.NO_SELECTION;
				
				//Don't move new selected piece
				} else if (selected instanceof Piece){
                                        lastSelected = (Piece)selected;
					lastSelected.possibleMoves();

				} else {
					state = State.NO_SELECTION;
				}
				break;
		}

		//Win - black
		if (grid.setW.gameOver(grid.setB)){
			frame.setTitle("Game Over - Black");
			frame.removeMouseListener(this);

		//Win - white
		} else if (grid.setB.gameOver(grid.setW)){
			frame.setTitle("Game Over - White");
                        frame.removeMouseListener(this);

		//Draw	- Two kings left (dead position) or
		//	- Stalmate or 
		//	- Fifty move rule or
		//	- Threefold repition
		} else if (false || 
				false || 
				false || 
				false){
			frame.setTitle("Draw");
			frame.removeMouseListener(this);
		} 

		painter.repaint();
	}

	//Return selected tile and update tile selected and possible statuses
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
	
	@Override
        public void mousePressed(MouseEvent e) { }

        @Override
        public void mouseReleased(MouseEvent e) { }

        @Override
        public void mouseEntered(MouseEvent e) { }

        @Override
        public void mouseExited(MouseEvent e) { }
}
