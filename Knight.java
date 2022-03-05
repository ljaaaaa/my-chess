import javax.swing.ImageIcon;
import java.util.ArrayList;

//Bishop Class
public class Knight extends Piece{
	
	public Knight(int x, int y, char color){
		super(x, y, color);
		
		normalIcon = new ImageIcon("images/" + color + "_knight.png");
                selectedIcon = new ImageIcon("images/" + color + "_knight_selected.png");
		setSelected(false);
		setPossibles();
	}

	@Override
        public ArrayList<Tile> getPossibles(Grid grid){
                ArrayList<C> list = possibles[this.x][this.y].list;
                ArrayList<Tile> newPossibles = new ArrayList<Tile>();

                for (int x = 0; x < list.size(); x++){
                        Tile tile = grid.grid[list.get(x).x][list.get(x).y];

                        if (tile instanceof Piece && ((Piece)tile).color == this.color){
                         	continue;
			}
                        newPossibles.add(tile);
                }
                return newPossibles;
        }
	
	@Override
        protected void setPossibles(){
		possibles[0][0] = new CList(new C(1, 2), new C(2, 1));
		possibles[0][1] = new CList(new C(1, 3), new C(2, 0), new C(2, 2));
		possibles[0][2] = new CList(new C(1, 0), new C(1, 4), new C(2, 1), new C(2, 3));
		possibles[0][3] = new CList(new C(1, 1), new C(1, 5), new C(2, 2), new C(2, 4));
		possibles[0][4] = new CList(new C(1, 2), new C(1, 6), new C(2, 3), new C(2, 5));
		possibles[0][5] = new CList(new C(1, 3), new C(1, 7), new C(2, 4), new C(2, 6));
		possibles[0][6] = new CList(new C(1, 4), new C(2, 5), new C(2, 7));
		possibles[0][7] = new CList(new C(1, 5), new C(2, 6));
		possibles[1][0] = new CList(new C(0, 2), new C(2, 2), new C(3, 1));
		possibles[1][1] = new CList(new C(0, 3), new C(2, 3), new C(3, 0), new C(3, 2));
		possibles[1][2] = new CList(new C(0, 0), new C(2, 0), new C(0, 4), new C(2, 4), new C(3, 1), new C(3, 3));
		possibles[1][3] = new CList(new C(0, 1), new C(2, 1), new C(0, 5), new C(2, 5), new C(3, 2), new C(3, 4));
		possibles[1][4] = new CList(new C(0, 2), new C(2, 2), new C(0, 6), new C(2, 6), new C(3, 3), new C(3, 5));
		possibles[1][5] = new CList(new C(0, 3), new C(2, 3), new C(0, 7), new C(2, 7), new C(3, 4), new C(3, 6));
		possibles[1][6] = new CList(new C(0, 4), new C(2, 4), new C(3, 5), new C(3, 7));
		possibles[1][7] = new CList(new C(0, 5), new C(2, 5), new C(3, 6));
		possibles[2][0] = new CList(new C(1, 2), new C(3, 2), new C(0, 1), new C(4, 1));
		possibles[2][1] = new CList(new C(1, 3), new C(3, 3), new C(0, 0), new C(0, 2), new C(4, 0), new C(4, 2));
		possibles[2][2] = new CList(new C(1, 0), new C(3, 0), new C(1, 4), new C(3, 4), new C(0, 1), new C(0, 3), new C(4, 1), new C(4, 3));
		possibles[2][3] = new CList(new C(1, 1), new C(3, 1), new C(1, 5), new C(3, 5), new C(0, 2), new C(0, 4), new C(4, 2), new C(4, 4));
		possibles[2][4] = new CList(new C(1, 2), new C(3, 2), new C(1, 6), new C(3, 6), new C(0, 3), new C(0, 5), new C(4, 3), new C(4, 5));
		possibles[2][5] = new CList(new C(1, 3), new C(3, 3), new C(1, 7), new C(3, 7), new C(0, 4), new C(0, 6), new C(4, 4), new C(4, 6));
		possibles[2][6] = new CList(new C(1, 4), new C(3, 4), new C(0, 5), new C(0, 7), new C(4, 5), new C(4, 7));
		possibles[2][7] = new CList(new C(1, 5), new C(3, 5), new C(0, 6), new C(4, 6));
		possibles[3][0] = new CList(new C(2, 2), new C(4, 2), new C(1, 1), new C(5, 1));
		possibles[3][1] = new CList(new C(2, 3), new C(4, 3), new C(1, 0), new C(1, 2), new C(5, 0), new C(5, 2));
		possibles[3][2] = new CList(new C(2, 0), new C(4, 0), new C(2, 4), new C(4, 4), new C(1, 1), new C(1, 3), new C(5, 1), new C(5, 3));
		possibles[3][3] = new CList(new C(2, 1), new C(4, 1), new C(2, 5), new C(4, 5), new C(1, 2), new C(1, 4), new C(5, 2), new C(5, 4));
		possibles[3][4] = new CList(new C(2, 2), new C(4, 2), new C(2, 6), new C(4, 6), new C(1, 3), new C(1, 5), new C(5, 3), new C(5, 5));
		possibles[3][5] = new CList(new C(2, 3), new C(4, 3), new C(2, 7), new C(4, 7), new C(1, 4), new C(1, 6), new C(5, 4), new C(5, 6));
		possibles[3][6] = new CList(new C(2, 4), new C(4, 4), new C(1, 5), new C(1, 7), new C(5, 5), new C(5, 7));
		possibles[3][7] = new CList(new C(2, 5), new C(4, 5), new C(1, 6), new C(5, 6));
		possibles[4][0] = new CList(new C(3, 2), new C(5, 2), new C(2, 1), new C(6, 1));
		possibles[4][1] = new CList(new C(3, 3), new C(5, 3), new C(2, 0), new C(2, 2), new C(6, 0), new C(6, 2));
		possibles[4][2] = new CList(new C(3, 0), new C(5, 0), new C(3, 4), new C(5, 4), new C(2, 1), new C(2, 3), new C(6, 1), new C(6, 3));
		possibles[4][3] = new CList(new C(3, 1), new C(5, 1), new C(3, 5), new C(5, 5), new C(2, 2), new C(2, 4), new C(6, 2), new C(6, 4));
		possibles[4][4] = new CList(new C(3, 2), new C(5, 2), new C(3, 6), new C(5, 6), new C(2, 3), new C(2, 5), new C(6, 3), new C(6, 5));
		possibles[4][5] = new CList(new C(3, 3), new C(5, 3), new C(3, 7), new C(5, 7), new C(2, 4), new C(2, 6), new C(6, 4), new C(6, 6));
		possibles[4][6] = new CList(new C(3, 4), new C(5, 4), new C(2, 5), new C(2, 7), new C(6, 5), new C(6, 7));
		possibles[4][7] = new CList(new C(3, 5), new C(5, 5), new C(2, 6), new C(6, 6));
		possibles[5][0] = new CList(new C(4, 2), new C(6, 2), new C(3, 1), new C(7, 1));
		possibles[5][1] = new CList(new C(4, 3), new C(6, 3), new C(3, 0), new C(3, 2), new C(7, 0), new C(7, 2));
		possibles[5][2] = new CList(new C(4, 0), new C(6, 0), new C(4, 4), new C(6, 4), new C(3, 1), new C(3, 3), new C(7, 1), new C(7, 3));
		possibles[5][3] = new CList(new C(4, 1), new C(6, 1), new C(4, 5), new C(6, 5), new C(3, 2), new C(3, 4), new C(7, 2), new C(7, 4));
		possibles[5][4] = new CList(new C(4, 2), new C(6, 2), new C(4, 6), new C(6, 6), new C(3, 3), new C(3, 5), new C(7, 3), new C(7, 5));
		possibles[5][5] = new CList(new C(4, 3), new C(6, 3), new C(4, 7), new C(6, 7), new C(3, 4), new C(3, 6), new C(7, 4), new C(7, 6));
		possibles[5][6] = new CList(new C(4, 4), new C(6, 4), new C(3, 5), new C(3, 7), new C(7, 5), new C(7, 7));
		possibles[5][7] = new CList(new C(4, 5), new C(6, 5), new C(3, 6), new C(7, 6));
		possibles[6][0] = new CList(new C(5, 2), new C(7, 2), new C(4, 1));
		possibles[6][1] = new CList(new C(5, 3), new C(7, 3), new C(4, 0), new C(4, 2));
		possibles[6][2] = new CList(new C(5, 0), new C(7, 0), new C(5, 4), new C(7, 4), new C(4, 1), new C(4, 3));
		possibles[6][3] = new CList(new C(5, 1), new C(7, 1), new C(5, 5), new C(7, 5), new C(4, 2), new C(4, 4));
		possibles[6][4] = new CList(new C(5, 2), new C(7, 2), new C(5, 6), new C(7, 6), new C(4, 3), new C(4, 5));
		possibles[6][5] = new CList(new C(5, 3), new C(7, 3), new C(5, 7), new C(7, 7), new C(4, 4), new C(4, 6));
		possibles[6][6] = new CList(new C(5, 4), new C(7, 4), new C(4, 5), new C(4, 7));
		possibles[6][7] = new CList(new C(5, 5), new C(7, 5), new C(4, 6));
		possibles[7][0] = new CList(new C(6, 2), new C(5, 1));
		possibles[7][1] = new CList(new C(6, 3), new C(5, 0), new C(5, 2));
		possibles[7][2] = new CList(new C(6, 0), new C(6, 4), new C(5, 1), new C(5, 3));
		possibles[7][3] = new CList(new C(6, 1), new C(6, 5), new C(5, 2), new C(5, 4));
		possibles[7][4] = new CList(new C(6, 2), new C(6, 6), new C(5, 3), new C(5, 5));
		possibles[7][5] = new CList(new C(6, 3), new C(6, 7), new C(5, 4), new C(5, 6));
		possibles[7][6] = new CList(new C(6, 4), new C(5, 5), new C(5, 7));
		possibles[7][7] = new CList(new C(6, 5), new C(5, 6));
	}
}
