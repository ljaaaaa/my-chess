public class History {
	char color;
	String move;

	public History(Piece movedPiece, Tile location){
		//Set move in proper chess notation here.
		char startCharacter = movedPiece.character;
		String startNotation = movedPiece.getNotation();
		String endNotation = location.getNotation();

		//Ex: Na2-c3
		move = startCharacter + startNotation + "-" + endNotation;
		color = movedPiece.color;	
	}

	//Get piece type of moving piece
	public String getHistoryPieceType(){
		return move.substring(0, 1);
	}
}
