public class Player {
	Set set; //Set of chess pieces
	Grid grid; //Grid

	public Player(){
		grid = new Grid();
		set = new Set("white");
	}
}
