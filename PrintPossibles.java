import java.util.ArrayList;

//Print Possibles Class
public class PrintPossibles {

	public static void main(String[] args){
		for (int x = 0; x < 8; x++){
			for (int y = 0; y < 8; y++){
				Knight p = new Knight(x, y, 'w');
				ArrayList<Tile> possibles = new PrintPossibles().knightPossibleMoves(x, y, new Grid());
				printPossibles(p, possibles);
			}
		}
	}

        public static void printPossibles(Piece piece, ArrayList<Tile> possibles){
                System.out.print("possibles[" + piece.x + "][" + piece.y + "] = new CList(");
                for (int x = 0; x < possibles.size(); x++){
                        if (x == possibles.size()-1){
                        System.out.print("new C(" + possibles.get(x).x + ", " + possibles.get(x).y + ")");
                        } else {
                                System.out.print("new C(" + possibles.get(x).x + ", " + possibles.get(x).y + "), ");
                        }
                }
                System.out.print(");\n");
        }

	public ArrayList<Tile> knightPossibleMoves(int posX, int posY, Grid grid){
		ArrayList<Tile> possibles = new ArrayList<>(); 

		//Top
		if (posY - 2 >= 0){
			if (posX - 1 >= 0){
				possibles.add(grid.grid[posX-1][posY-2]);	
			} if (posX + 1 < 8){
				possibles.add(grid.grid[posX+1][posY-2]);
			}
		}

		//Bottom
                if (posY + 2 < 8){
                        if (posX - 1 >= 0){
                                possibles.add(grid.grid[posX-1][posY+2]);
                        } if (posX + 1 < 8){
                                possibles.add(grid.grid[posX+1][posY+2]);
                        }
                }

		//Left
                if (posX - 2 >= 0){
                        if (posY - 1 >= 0){
                                possibles.add(grid.grid[posX-2][posY-1]);
                        } if (posY + 1 < 8){
                                possibles.add(grid.grid[posX-2][posY+1]);
                        }
                }

		//Right
                if (posX + 2 < 8){
                        if (posY - 1 >= 0){
                                possibles.add(grid.grid[posX+2][posY-1]);
                        } if (posY + 1 < 8){
                                possibles.add(grid.grid[posX+2][posY+1]);
                        }
                }

		return possibles;
        }

        public ArrayList<Tile> bishopPossibleMoves(int posX, int posY, Grid grid, char color){
		ArrayList<Tile> possibles = new ArrayList<>();
		int add = 1;

		//Diagonal up left
		while (posY-add >= 0 && posX-add >= 0){
			possibles.add(grid.grid[posX-add][posY-add]);
			add++;
		}
		add = 1;

		//Diagonal up right
		while (posY-add >= 0 && posX+add < 8){
                        possibles.add(grid.grid[posX+add][posY-add]); 
                        add++;
                }
		add = 1;

		//Diagonal down left
		while (posY+add < 8 && posX-add >= 0 ){
			possibles.add(grid.grid[posX-add][posY+add]);

			add++;
		}
		add = 1;

		//Diagonal down right
                while (posY+add < 8 && posX+add < 8){
			possibles.add(grid.grid[posX+add][posY+add]);
                        add++;
                }

		return possibles;
        }

        public ArrayList<Tile> pawnPossibleMoves(int posX, int posY, Grid grid, char color, Pawn.Direction dir){
		ArrayList<Tile> possibles = new ArrayList<>();

		switch(dir){
			//Piece is going down
			case DOWN:
				//Next tile
               			if (posY+1 < 8){
                        		possibles.add(grid.grid[posX][posY+1]);

					//Next two tiles
                			if (posY == 1){
                                		possibles.add(grid.grid[posX][posY+2]);
					}
				}

				//Diagonal tile
				//if (posY+1 < 8 && posX+1 < 8){
                                //        possibles.add(grid.grid[posX+1][posY+1]);

				//Diagonal tile
				//} if (posY+1 < 8 && posX-1 >= 0){
                                //        possibles.add(grid.grid[posX-1][posY+1]);
				//}
				break;

			//Piece is going up
			case UP:
				//Next tile
                                if (posY-1 >= 0){
                                        possibles.add(grid.grid[posX][posY-1]);

                                	//Next two tiles
                                	if (posY == 6){
                                        	possibles.add(grid.grid[posX][posY-2]);
					}
				}
				//Diagonal tile
				//if (posY-1 >= 0 && posX+1 < 8){
                                //        possibles.add(grid.grid[posX+1][posY-1]);

				//Diagonal tile
				//} if (posY-1 >= 0 && posX-1 >= 0){
                                //        possibles.add(grid.grid[posX-1][posY-1]);
                                //}

				break;
		}
		return possibles;
        }

	public static ArrayList<Tile> rookPossibleMoves(int posX, int posY, Grid grid, char color){
		ArrayList<Tile> possibles = new ArrayList<>(); 
		int add = 1;

		//Up
		while (posY-add >= 0){	
			possibles.add(grid.grid[posX][posY-add]);

			//Has hit a piece, stop
			if (grid.grid[posX][posY-add] instanceof Piece){
				//If piece is of own color, don't eat
				if (((Piece)grid.grid[posX][posY-add]).color == color){
					possibles.remove(possibles.size()-1);
				}
				break;
			}
			add++;
		}
		add = 1;

		//Down
		while (posY+add < 8){
                        possibles.add(grid.grid[posX][posY+add]);

                        if (grid.grid[posX][posY+add] instanceof Piece){
				//If piece is of own color, don't eat
                                if (((Piece)grid.grid[posX][posY+add]).color == color){
                                        possibles.remove(possibles.size()-1);
                                }
				break;
                        }
                        add++;
                }
		add = 1;

		//Left
		while (posX-add >= 0 ){
			possibles.add(grid.grid[posX-add][posY]);

			if (grid.grid[posX-add][posY] instanceof Piece){
				//If piece is of own color, don't eat
                                if (((Piece)grid.grid[posX-add][posY]).color == color){
                                        possibles.remove(possibles.size()-1);
                                }
				break;
			}
			add++;
		}
		add = 1;

		//Right
                while (posX+add < 8){
                        possibles.add(grid.grid[posX+add][posY]);

                        if (grid.grid[posX+add][posY] instanceof Piece){
				//If piece is of own color, don't eat
                                if (((Piece)grid.grid[posX+add][posY]).color == color){
                                        possibles.remove(possibles.size()-1);
                                }
				break;
                        }
                        add++;
                }

		return possibles;
        }
}
