import javax.swing.ImageIcon;
import java.util.ArrayList;

//Bishop Class
public class Bishop extends Piece{
	//Constructor
	public Bishop(int x, int y, char color){
		super(x, y, color);
		
		normalIcon = new ImageIcon("images/" + color + "_bishop.png");
                selectedIcon = new ImageIcon("images/" + color + "_bishop_selected.png");
		setSelected(false);
		setPossibles();
	}

	@Override
	public ArrayList<Tile> getPossibles(Grid grid){
		ArrayList<C> list = possibles[this.x][this.y].list;
		ArrayList<Tile> newPossibles = new ArrayList<Tile>();
		boolean hitTile = false;

		for (int x = 0; x < list.size(); x++){
			Tile tile = grid.grid[list.get(x).x][list.get(x).y];

			if (x-1 >= 0 && list.get(x).num > list.get(x-1).num){
				hitTile = false;
				System.out.println(list.get(x).num);
			}

			//Stop collecting possibles
			if (tile instanceof Piece){
				if (((Piece)tile).color != this.color && !hitTile){
					newPossibles.add(tile);
					hitTile = true;
				}
				continue;
			}
			newPossibles.add(tile);
		}
		return newPossibles;
	}

	@Override
        protected void setPossibles(){
	possibles[0][0] = new CList(new C(1, 1, 3), new C(2, 2, 3), new C(3, 3, 3), new C(4, 4, 3), new C(5, 5, 3), new C(6, 6, 3), new C(7, 7, 3));
possibles[0][1] = new CList(new C(1, 0, 1), new C(1, 2, 3), new C(2, 3, 3), new C(3, 4, 3), new C(4, 5, 3), new C(5, 6, 3), new C(6, 7, 3));
possibles[0][2] = new CList(new C(1, 1, 1), new C(2, 0, 1), new C(1, 3, 3), new C(2, 4, 3), new C(3, 5, 3), new C(4, 6, 3), new C(5, 7, 3));
possibles[0][3] = new CList(new C(1, 2, 1), new C(2, 1, 1), new C(3, 0, 1), new C(1, 4, 3), new C(2, 5, 3), new C(3, 6, 3), new C(4, 7, 3));
possibles[0][4] = new CList(new C(1, 3, 1), new C(2, 2, 1), new C(3, 1, 1), new C(4, 0, 1), new C(1, 5, 3), new C(2, 6, 3), new C(3, 7, 3));
possibles[0][5] = new CList(new C(1, 4, 1), new C(2, 3, 1), new C(3, 2, 1), new C(4, 1, 1), new C(5, 0, 1), new C(1, 6, 3), new C(2, 7, 3));
possibles[0][6] = new CList(new C(1, 5, 1), new C(2, 4, 1), new C(3, 3, 1), new C(4, 2, 1), new C(5, 1, 1), new C(6, 0, 1), new C(1, 7, 3));
possibles[0][7] = new CList(new C(1, 6, 1), new C(2, 5, 1), new C(3, 4, 1), new C(4, 3, 1), new C(5, 2, 1), new C(6, 1, 1), new C(7, 0, 1));
possibles[1][0] = new CList(new C(0, 1, 2), new C(2, 1, 3), new C(3, 2, 3), new C(4, 3, 3), new C(5, 4, 3), new C(6, 5, 3), new C(7, 6, 3));
possibles[1][1] = new CList(new C(0, 0, 0), new C(2, 0, 1), new C(0, 2, 2), new C(2, 2, 3), new C(3, 3, 3), new C(4, 4, 3), new C(5, 5, 3), new C(6, 6, 3), new C(7, 7, 3));
possibles[1][2] = new CList(new C(0, 1, 0), new C(2, 1, 1), new C(3, 0, 1), new C(0, 3, 2), new C(2, 3, 3), new C(3, 4, 3), new C(4, 5, 3), new C(5, 6, 3), new C(6, 7, 3));
possibles[1][3] = new CList(new C(0, 2, 0), new C(2, 2, 1), new C(3, 1, 1), new C(4, 0, 1), new C(0, 4, 2), new C(2, 4, 3), new C(3, 5, 3), new C(4, 6, 3), new C(5, 7, 3));
possibles[1][4] = new CList(new C(0, 3, 0), new C(2, 3, 1), new C(3, 2, 1), new C(4, 1, 1), new C(5, 0, 1), new C(0, 5, 2), new C(2, 5, 3), new C(3, 6, 3), new C(4, 7, 3));
possibles[1][5] = new CList(new C(0, 4, 0), new C(2, 4, 1), new C(3, 3, 1), new C(4, 2, 1), new C(5, 1, 1), new C(6, 0, 1), new C(0, 6, 2), new C(2, 6, 3), new C(3, 7, 3));
possibles[1][6] = new CList(new C(0, 5, 0), new C(2, 5, 1), new C(3, 4, 1), new C(4, 3, 1), new C(5, 2, 1), new C(6, 1, 1), new C(7, 0, 1), new C(0, 7, 2), new C(2, 7, 3));
possibles[1][7] = new CList(new C(0, 6, 0), new C(2, 6, 1), new C(3, 5, 1), new C(4, 4, 1), new C(5, 3, 1), new C(6, 2, 1), new C(7, 1, 1));
possibles[2][0] = new CList(new C(1, 1, 2), new C(0, 2, 2), new C(3, 1, 3), new C(4, 2, 3), new C(5, 3, 3), new C(6, 4, 3), new C(7, 5, 3));
possibles[2][1] = new CList(new C(1, 0, 0), new C(3, 0, 1), new C(1, 2, 2), new C(0, 3, 2), new C(3, 2, 3), new C(4, 3, 3), new C(5, 4, 3), new C(6, 5, 3), new C(7, 6, 3));
possibles[2][2] = new CList(new C(1, 1, 0), new C(0, 0, 0), new C(3, 1, 1), new C(4, 0, 1), new C(1, 3, 2), new C(0, 4, 2), new C(3, 3, 3), new C(4, 4, 3), new C(5, 5, 3), new C(6, 6, 3), new C(7, 7, 3));
possibles[2][3] = new CList(new C(1, 2, 0), new C(0, 1, 0), new C(3, 2, 1), new C(4, 1, 1), new C(5, 0, 1), new C(1, 4, 2), new C(0, 5, 2), new C(3, 4, 3), new C(4, 5, 3), new C(5, 6, 3), new C(6, 7, 3));
possibles[2][4] = new CList(new C(1, 3, 0), new C(0, 2, 0), new C(3, 3, 1), new C(4, 2, 1), new C(5, 1, 1), new C(6, 0, 1), new C(1, 5, 2), new C(0, 6, 2), new C(3, 5, 3), new C(4, 6, 3), new C(5, 7, 3));
possibles[2][5] = new CList(new C(1, 4, 0), new C(0, 3, 0), new C(3, 4, 1), new C(4, 3, 1), new C(5, 2, 1), new C(6, 1, 1), new C(7, 0, 1), new C(1, 6, 2), new C(0, 7, 2), new C(3, 6, 3), new C(4, 7, 3));
possibles[2][6] = new CList(new C(1, 5, 0), new C(0, 4, 0), new C(3, 5, 1), new C(4, 4, 1), new C(5, 3, 1), new C(6, 2, 1), new C(7, 1, 1), new C(1, 7, 2), new C(3, 7, 3));
possibles[2][7] = new CList(new C(1, 6, 0), new C(0, 5, 0), new C(3, 6, 1), new C(4, 5, 1), new C(5, 4, 1), new C(6, 3, 1), new C(7, 2, 1));
possibles[3][0] = new CList(new C(2, 1, 2), new C(1, 2, 2), new C(0, 3, 2), new C(4, 1, 3), new C(5, 2, 3), new C(6, 3, 3), new C(7, 4, 3));
possibles[3][1] = new CList(new C(2, 0, 0), new C(4, 0, 1), new C(2, 2, 2), new C(1, 3, 2), new C(0, 4, 2), new C(4, 2, 3), new C(5, 3, 3), new C(6, 4, 3), new C(7, 5, 3));
possibles[3][2] = new CList(new C(2, 1, 0), new C(1, 0, 0), new C(4, 1, 1), new C(5, 0, 1), new C(2, 3, 2), new C(1, 4, 2), new C(0, 5, 2), new C(4, 3, 3), new C(5, 4, 3), new C(6, 5, 3), new C(7, 6, 3));
possibles[3][3] = new CList(new C(2, 2, 0), new C(1, 1, 0), new C(0, 0, 0), new C(4, 2, 1), new C(5, 1, 1), new C(6, 0, 1), new C(2, 4, 2), new C(1, 5, 2), new C(0, 6, 2), new C(4, 4, 3), new C(5, 5, 3), new C(6, 6, 3), new C(7, 7, 3));
possibles[3][4] = new CList(new C(2, 3, 0), new C(1, 2, 0), new C(0, 1, 0), new C(4, 3, 1), new C(5, 2, 1), new C(6, 1, 1), new C(7, 0, 1), new C(2, 5, 2), new C(1, 6, 2), new C(0, 7, 2), new C(4, 5, 3), new C(5, 6, 3), new C(6, 7, 3));
possibles[3][5] = new CList(new C(2, 4, 0), new C(1, 3, 0), new C(0, 2, 0), new C(4, 4, 1), new C(5, 3, 1), new C(6, 2, 1), new C(7, 1, 1), new C(2, 6, 2), new C(1, 7, 2), new C(4, 6, 3), new C(5, 7, 3));
possibles[3][6] = new CList(new C(2, 5, 0), new C(1, 4, 0), new C(0, 3, 0), new C(4, 5, 1), new C(5, 4, 1), new C(6, 3, 1), new C(7, 2, 1), new C(2, 7, 2), new C(4, 7, 3));
possibles[3][7] = new CList(new C(2, 6, 0), new C(1, 5, 0), new C(0, 4, 0), new C(4, 6, 1), new C(5, 5, 1), new C(6, 4, 1), new C(7, 3, 1));
possibles[4][0] = new CList(new C(3, 1, 2), new C(2, 2, 2), new C(1, 3, 2), new C(0, 4, 2), new C(5, 1, 3), new C(6, 2, 3), new C(7, 3, 3));
possibles[4][1] = new CList(new C(3, 0, 0), new C(5, 0, 1), new C(3, 2, 2), new C(2, 3, 2), new C(1, 4, 2), new C(0, 5, 2), new C(5, 2, 3), new C(6, 3, 3), new C(7, 4, 3));
possibles[4][2] = new CList(new C(3, 1, 0), new C(2, 0, 0), new C(5, 1, 1), new C(6, 0, 1), new C(3, 3, 2), new C(2, 4, 2), new C(1, 5, 2), new C(0, 6, 2), new C(5, 3, 3), new C(6, 4, 3), new C(7, 5, 3));
possibles[4][3] = new CList(new C(3, 2, 0), new C(2, 1, 0), new C(1, 0, 0), new C(5, 2, 1), new C(6, 1, 1), new C(7, 0, 1), new C(3, 4, 2), new C(2, 5, 2), new C(1, 6, 2), new C(0, 7, 2), new C(5, 4, 3), new C(6, 5, 3), new C(7, 6, 3));
possibles[4][4] = new CList(new C(3, 3, 0), new C(2, 2, 0), new C(1, 1, 0), new C(0, 0, 0), new C(5, 3, 1), new C(6, 2, 1), new C(7, 1, 1), new C(3, 5, 2), new C(2, 6, 2), new C(1, 7, 2), new C(5, 5, 3), new C(6, 6, 3), new C(7, 7, 3));
possibles[4][5] = new CList(new C(3, 4, 0), new C(2, 3, 0), new C(1, 2, 0), new C(0, 1, 0), new C(5, 4, 1), new C(6, 3, 1), new C(7, 2, 1), new C(3, 6, 2), new C(2, 7, 2), new C(5, 6, 3), new C(6, 7, 3));
possibles[4][6] = new CList(new C(3, 5, 0), new C(2, 4, 0), new C(1, 3, 0), new C(0, 2, 0), new C(5, 5, 1), new C(6, 4, 1), new C(7, 3, 1), new C(3, 7, 2), new C(5, 7, 3));
possibles[4][7] = new CList(new C(3, 6, 0), new C(2, 5, 0), new C(1, 4, 0), new C(0, 3, 0), new C(5, 6, 1), new C(6, 5, 1), new C(7, 4, 1));
possibles[5][0] = new CList(new C(4, 1, 2), new C(3, 2, 2), new C(2, 3, 2), new C(1, 4, 2), new C(0, 5, 2), new C(6, 1, 3), new C(7, 2, 3));
possibles[5][1] = new CList(new C(4, 0, 0), new C(6, 0, 1), new C(4, 2, 2), new C(3, 3, 2), new C(2, 4, 2), new C(1, 5, 2), new C(0, 6, 2), new C(6, 2, 3), new C(7, 3, 3));
possibles[5][2] = new CList(new C(4, 1, 0), new C(3, 0, 0), new C(6, 1, 1), new C(7, 0, 1), new C(4, 3, 2), new C(3, 4, 2), new C(2, 5, 2), new C(1, 6, 2), new C(0, 7, 2), new C(6, 3, 3), new C(7, 4, 3));
possibles[5][3] = new CList(new C(4, 2, 0), new C(3, 1, 0), new C(2, 0, 0), new C(6, 2, 1), new C(7, 1, 1), new C(4, 4, 2), new C(3, 5, 2), new C(2, 6, 2), new C(1, 7, 2), new C(6, 4, 3), new C(7, 5, 3));
possibles[5][4] = new CList(new C(4, 3, 0), new C(3, 2, 0), new C(2, 1, 0), new C(1, 0, 0), new C(6, 3, 1), new C(7, 2, 1), new C(4, 5, 2), new C(3, 6, 2), new C(2, 7, 2), new C(6, 5, 3), new C(7, 6, 3));
possibles[5][5] = new CList(new C(4, 4, 0), new C(3, 3, 0), new C(2, 2, 0), new C(1, 1, 0), new C(0, 0, 0), new C(6, 4, 1), new C(7, 3, 1), new C(4, 6, 2), new C(3, 7, 2), new C(6, 6, 3), new C(7, 7, 3));
possibles[5][6] = new CList(new C(4, 5, 0), new C(3, 4, 0), new C(2, 3, 0), new C(1, 2, 0), new C(0, 1, 0), new C(6, 5, 1), new C(7, 4, 1), new C(4, 7, 2), new C(6, 7, 3));
possibles[5][7] = new CList(new C(4, 6, 0), new C(3, 5, 0), new C(2, 4, 0), new C(1, 3, 0), new C(0, 2, 0), new C(6, 6, 1), new C(7, 5, 1));
possibles[6][0] = new CList(new C(5, 1, 2), new C(4, 2, 2), new C(3, 3, 2), new C(2, 4, 2), new C(1, 5, 2), new C(0, 6, 2), new C(7, 1, 3));
possibles[6][1] = new CList(new C(5, 0, 0), new C(7, 0, 1), new C(5, 2, 2), new C(4, 3, 2), new C(3, 4, 2), new C(2, 5, 2), new C(1, 6, 2), new C(0, 7, 2), new C(7, 2, 3));
possibles[6][2] = new CList(new C(5, 1, 0), new C(4, 0, 0), new C(7, 1, 1), new C(5, 3, 2), new C(4, 4, 2), new C(3, 5, 2), new C(2, 6, 2), new C(1, 7, 2), new C(7, 3, 3));
possibles[6][3] = new CList(new C(5, 2, 0), new C(4, 1, 0), new C(3, 0, 0), new C(7, 2, 1), new C(5, 4, 2), new C(4, 5, 2), new C(3, 6, 2), new C(2, 7, 2), new C(7, 4, 3));
possibles[6][4] = new CList(new C(5, 3, 0), new C(4, 2, 0), new C(3, 1, 0), new C(2, 0, 0), new C(7, 3, 1), new C(5, 5, 2), new C(4, 6, 2), new C(3, 7, 2), new C(7, 5, 3));
possibles[6][5] = new CList(new C(5, 4, 0), new C(4, 3, 0), new C(3, 2, 0), new C(2, 1, 0), new C(1, 0, 0), new C(7, 4, 1), new C(5, 6, 2), new C(4, 7, 2), new C(7, 6, 3));
possibles[6][6] = new CList(new C(5, 5, 0), new C(4, 4, 0), new C(3, 3, 0), new C(2, 2, 0), new C(1, 1, 0), new C(0, 0, 0), new C(7, 5, 1), new C(5, 7, 2), new C(7, 7, 3));
possibles[6][7] = new CList(new C(5, 6, 0), new C(4, 5, 0), new C(3, 4, 0), new C(2, 3, 0), new C(1, 2, 0), new C(0, 1, 0), new C(7, 6, 1));
possibles[7][0] = new CList(new C(6, 1, 2), new C(5, 2, 2), new C(4, 3, 2), new C(3, 4, 2), new C(2, 5, 2), new C(1, 6, 2), new C(0, 7, 2));
possibles[7][1] = new CList(new C(6, 0, 0), new C(6, 2, 2), new C(5, 3, 2), new C(4, 4, 2), new C(3, 5, 2), new C(2, 6, 2), new C(1, 7, 2));
possibles[7][2] = new CList(new C(6, 1, 0), new C(5, 0, 0), new C(6, 3, 2), new C(5, 4, 2), new C(4, 5, 2), new C(3, 6, 2), new C(2, 7, 2));
possibles[7][3] = new CList(new C(6, 2, 0), new C(5, 1, 0), new C(4, 0, 0), new C(6, 4, 2), new C(5, 5, 2), new C(4, 6, 2), new C(3, 7, 2));
possibles[7][4] = new CList(new C(6, 3, 0), new C(5, 2, 0), new C(4, 1, 0), new C(3, 0, 0), new C(6, 5, 2), new C(5, 6, 2), new C(4, 7, 2));
possibles[7][5] = new CList(new C(6, 4, 0), new C(5, 3, 0), new C(4, 2, 0), new C(3, 1, 0), new C(2, 0, 0), new C(6, 6, 2), new C(5, 7, 2));
possibles[7][6] = new CList(new C(6, 5, 0), new C(5, 4, 0), new C(4, 3, 0), new C(3, 2, 0), new C(2, 1, 0), new C(1, 0, 0), new C(6, 7, 2));
possibles[7][7] = new CList(new C(6, 6, 0), new C(5, 5, 0), new C(4, 4, 0), new C(3, 3, 0), new C(2, 2, 0), new C(1, 1, 0), new C(0, 0, 0));
	}
}
