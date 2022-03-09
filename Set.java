public class Set {
	public char color;

	public King king;
	public Queen queen;
	public Rook rook1;
	public Rook rook2;
	public Bishop bishop1;
	public Bishop bishop2;
	public Knight knight1;
	public Knight knight2;
	public Pawn[] pawns;
	public Piece[] pieces;

	public Set(char color){
		this.color = color;
		pawns = new Pawn[8];
	}

	public void initAllPieces(){
		pieces = new Piece[16];

		for (int x = 0; x < pawns.length; x++){
			pieces[x] = pawns[x];
		}

		pieces[8] = knight1;
		pieces[9] = knight2;
		pieces[10] = bishop1;
		pieces[11] = bishop2;
		pieces[12] = rook1;
                pieces[13] = rook2;
		pieces[14] = king;
                pieces[15] = queen;
	}
}
