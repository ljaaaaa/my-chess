import java.util.ArrayList;

public class Set {
	public char color;
	public Piece king;
	public ArrayList<Piece> pieces;
	private Set otherSet; //Reference to other set

	public Set(char color){
		this.color = color;
		pieces = new ArrayList<Piece>();
	}

	//Sets otherSet variable
	public void setOtherSet(Set otherSet){
		this.otherSet = otherSet;
	}

	//Returns true if this set's king can be eaten
	public boolean kingCanBeEaten(){
		for (int x = 0; x < otherSet.pieces.size(); x++){
			if (otherSet.pieces.get(x).basePossibleMoves().contains(king)){
				return true;
			}
		}
		return false;
	}

	//Return true if draw because of insufficient material
	public boolean drawInsufficientMaterial(){	
		if ((this.pieces.size() == 1 && otherSet.pieces.size() == 1) || //King vs King
			(this.pieces.size() == 2 && this.pieces.get(0).type.equals("bishop") && otherSet.pieces.size() == 1) || //King + Bishop vs King
			(otherSet.pieces.size() == 2 && otherSet.pieces.get(0).type.equals("bishop") && this.pieces.size() == 1) ||
			
			(this.pieces.size() == 2 && this.pieces.get(0).type.equals("knight") && otherSet.pieces.size() == 1) || //King + Knight vs King
                        (otherSet.pieces.size() == 2 && otherSet.pieces.get(0).type.equals("knight") && this.pieces.size() == 1) ||

			(this.pieces.size() == 2 && otherSet.pieces.size() == 2 && this.pieces.get(0).type.equals("bishop") && otherSet.pieces.get(0).type.equals("bishop") &&
			 bishopsOnSameColor(this.pieces.get(0), otherSet.pieces.get(0)))	//King + Bishop vs King + Bishop (on same color)
				){
			return true;
		}
		return false;
	}

	//Return true if two bishops are on same color tile
	private boolean bishopsOnSameColor(Piece bishop1, Piece bishop2){
		if ((bishop1.x%2 + bishop1.y%2)%2 == (bishop2.x%2 + bishop2.y%2)%2){
			return true;
		}
		return false;
	}

	//Returns true if draw because of stalemate
	public boolean drawStalemate(){
		if (!playerLost()){
			for (int x = 0; x < pieces.size(); x++){
				if (pieces.get(x).validPossibleMoves().size() > 0){
					return false;
				}
			}
			return true;

		} else { //Player has lost already
			return false;
		}
	}

	//Returns true if this color has died
	public boolean playerLost(){
		if (kingCanBeEaten()){ //If king in trouble and no piece can move
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
