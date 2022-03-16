public class Set {
	public char color;
	public Piece king;
	public Piece[] pieces;

	public Set(char color){
		this.color = color;
		pieces = new Piece[16];
	}

	public boolean kingCanBeEaten(Grid grid, Set otherSet){	
		for (int x = 0; x < otherSet.pieces.length; x++){
			if (otherSet.pieces[x].possibleMoves().contains(king)){
				return true;
			}
		}
		Sys
		return false;
	}
}
