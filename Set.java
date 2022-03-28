import java.util.ArrayList;

public class Set {
	public char color;
	public Piece king;
	public ArrayList<Piece> pieces;

	public Set(char color){
		this.color = color;
		pieces = new ArrayList<Piece>();
	}

	public boolean kingCanBeEaten(Set otherSet){
		for (int x = 0; x < otherSet.pieces.size(); x++){
			if (otherSet.pieces.get(x).possibleMoves().contains(king)){
				return true;
			}
		}
		return false;
	}
}
