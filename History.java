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
	public char getHistoryPieceType(){
		return move.charAt(0);
	}

	//Return end X Coordinate of move
	public int getXPos(){
		char[] letters = new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};

		return new String(letters).indexOf(move.charAt(4))+1;
	}

	//Return end Y coordinate of move
	public int getYPos(){
		return move.charAt(5) - '1';
	}

	//change in x for move
	public int getXChange(){
		char[] letters = new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};

		int x1 = new String(letters).indexOf(move.charAt(1))+1;
		int x2 = new String(letters).indexOf(move.charAt(4))+1;
		return Math.abs(x1-x2);
	}

	//change in y for move
        public int getYChange(){
                int y1 = move.charAt(2) - '0';
                int y2 = move.charAt(5) - '0';
                return Math.abs(y1-y2);
        }
}
