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

	//Return true if draw because of insufficient material
	public boolean drawInsufficientMaterial(Painter painter, Set otherSet){
		if ((this.pieces.size() == 1 && otherSet.pieces.size() == 1) || //King vs King
			(this.pieces.size() == 2 && this.pieces.get(1).type.equals("bishop") && otherSet.pieces.size() == 1) || //King + Bishop vs King
			(otherSet.pieces.size() == 2 && otherSet.pieces.get(1).type.equals("bishop") && this.pieces.size() == 1) ||
			
			(this.pieces.size() == 2 && this.pieces.get(1).type.equals("knight") && otherSet.pieces.size() == 1) || //King + Knight vs King
                        (otherSet.pieces.size() == 2 && otherSet.pieces.get(1).type.equals("knight") && this.pieces.size() == 1) ||

			(this.pieces.size() == 2 && otherSet.pieces.size() == 2 && this.pieces.get(1).type.equals("bishop") && otherSet.pieces.get(1).type.equals("bishop") &&
			 bishopsSameColor(painter, this.pieces.get(1), otherSet.pieces.get(1)))	
				){
			return true;
		}
		return false;
	}

	//Return true if two bishops are on same color tile
	public boolean bishopsSameColor(Painter painter, Piece bishop1, Piece bishop2){
		if (painter.bgImages[bishop1.x][bishop1.y].equals(painter.bgImages[bishop2.x][bishop2.y])){
			return true;
		}
		return false;
	}

	//Returns true if draw because of stalemate
	public boolean drawStalemate(Set otherSet){
		if (!playerLost(otherSet)){
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
	public boolean playerLost(Set otherSet){
		if (kingCanBeEaten(otherSet)){ //If king in trouble and no piece can move
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
