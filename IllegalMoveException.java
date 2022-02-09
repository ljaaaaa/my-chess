//IllegalMoveException Class
public class IllegalMoveException extends Exception { 

	//Thrown when an illegal chess move is played
	public IllegalMoveException(String errorMessage) {
        	super(errorMessage);
    	}
}
