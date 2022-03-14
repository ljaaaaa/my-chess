public class Set {
	public char color;
	public Piece king;
	public Piece[] pieces;

	public Set(char color){
		this.color = color;
		pieces = new Piece[16];
	}
}
