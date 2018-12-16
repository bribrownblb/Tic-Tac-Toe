
public class Board {
	//declared outside of the constructor so that it is accessible to Board methods
	char [][] board;
	
	
	//Constructor that creates a new tic tac toe board
	public Board(){
		board = new char [3][3];
		boolean checker = true;
	}
	
	//Displays a printout of the current board
	void displayBoard() {
		for (int x =0; x <3; x++) {
			for (int y = 0; y < 3; y++) {
			System.out.print(board[x][y]);
				if (y != board.length -1)//if the column index is less than 2 print " | "
					System.out.print(" | ");
			}
		if (x != board.length -1)//if the row index is less than 2 print out a dashed line
			System.out.println("\n-------------");
		
			}
	}

	//returns true if spot is taken
	public boolean isSpotEmpty(int x, int y) {
		if (board[x][y] == '\u0000')
			return true;
			else return false;
	}
	
	public void insertMove (int x, int y, char move) {
		if (isSpotEmpty(x,y) == false)
			System.out.println("Spot taken. Please try again.");
		else board[x][y] = move;
		
	}
	
	//Checks for a win on the 3 horizontals
	boolean checkHorizontalWin () {
		//Checks coordinates 00, 01, 02 and that they aren't null
		if (board[0][0] == board[0][1] && board[0][2] == board[0][0] && board[0][0] != '\u0000')
			return true;
		//Checks coordinates 10, 11, 12 and that they aren't null
		else if (board[1][0] == board[1][1] && board[1][2] == board[1][0] && board[1][0] != '\u0000')
			return true;
		//Checks coordinates 20, 21, 22 and that they aren't null
		else if (board[2][0] == board[2][1] && board[2][2] == board[2][0] && board[2][0] != '\u0000')
			return true;
		else return false;
	}
	
	//Checks for win on the 3 verticals
	boolean checkVerticalWin () {
		//Checks coordinates 00, 10, 20 and that they aren't null
		if (board[0][0] == board[1][0] && board[2][0] == board[0][0] && board[0][0] != '\u0000')
			return true;
		//Checks coordinates 01, 11, 21 and that they aren't null
		else if (board[0][1] == board[1][1] && board[2][1] == board[0][1] && board[0][1] != '\u0000')
			return true;
		//Checks coordinates 02, 12, 22 and that they aren't null
		else if (board[0][2] == board[1][2] && board[2][2] == board[0][2] && board[0][2] != '\u0000')
			return true;
		else return false;
	}
	
	//Checks for a win on the 2 diagonals
	boolean checkDiagonalWin() {
		//Checks coordinates 00, 11, 22 and that they aren't null
		if (board[0][0] == board[1][1] && board[2][2] == board[0][0] && board[0][0] != '\u0000')
			return true;
		//Checks coordinates 02, 11, 20 and that they aren't null
		if (board[0][2] == board[1][1] && board[2][0] == board[0][2] && board[0][2] != '\u0000')
			return true;
		else return false;
	}
	
	//Combines the checks for horizontal, vertical, and diagonal win to determine a win or not
	boolean checkWinner() {
		if(checkHorizontalWin() == true)
			return true;
		
		else if (checkVerticalWin() == true)
			return true;
		
		else if (checkDiagonalWin() == true) 
			return true;
		else return false;
	}
}
