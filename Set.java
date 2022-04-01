import java.util.ArrayList;

public class Set {
	public char color;
	public Piece king;
	public ArrayList<Piece> pieces;

	public Set(char color){
		this.color = color;
		pieces = new ArrayList<Piece>();
	}

	//Returns true if this set's king can be eaten
	public boolean kingCanBeEaten(Set otherSet){
		for (int x = 0; x < otherSet.pieces.size(); x++){
			if (otherSet.pieces.get(x).basePossibleMoves().contains(king)){
				return true;
			}
		}
		return false;
	}

	//Returns true if this color has died
	public boolean gameOver(Set otherSet){
		
		//If king is in trouble AND no piece can move
		if (kingCanBeEaten(otherSet)){
			for (int x = 0; x < pieces.size(); x++){ //Loops through this set's pieces
                        	ArrayList<Tile> possibles = pieces.get(x).basePossibleMoves();
                        	for (int y = 0; y < possibles.size(); y++){ //Loops through possible moves for this piece

                        	        //If move can be done without endangering king, game is not over
                        	        if (!pieces.get(x).movePutsOwnKingInDanger(possibles.get(y).x, possibles.get(y).y)){
                        	                return false;
                        	        }
                        	}
			}
			return true;
		} else {
			return false;
		}
	}
}
