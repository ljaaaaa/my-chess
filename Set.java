public class Set {
	Pawn[] pawns;
	String color;

	public Set(String rcolor){
		this.color = color;
		initPawns();
	}

	//Bottom
	private void initPawns(){
		pawns = new Pawn[] {
			new Pawn(0, 1), new Pawn(1, 1), new Pawn(2, 1), new Pawn(3, 1),
			new Pawn(4, 1), new Pawn(5, 1), new Pawn(6, 1), new Pawn(7, 1)
		};
	}
}
