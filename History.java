public class History {
	//Move in correct chess notation
	public char color;
	public String move;

	//Helper variables for debugging, delete later
	public int startX;
	public int startY;
	public int endX;
	public int endY;
	public char type;

	public History(Piece movedPiece, Tile location){
		//Set move in proper chess notation here.
		//Ex: Na2-c3
		move = Character.toUpperCase(movedPiece.type) + movedPiece.getNotation() + " - " + location.getNotation();
		color = movedPiece.color;

		//Init helper variables
		startX = movedPiece.x;
		endX = location.x;
		startY = movedPiece.y;
		endY = location.y;
		type = movedPiece.type;
	}

	//change in x for move
	public int getXChange(){
		return Math.abs(endX - startX);
	}

	//change in y for move
        public int getYChange(){
                return Math.abs(endY - startY);
        }
}
