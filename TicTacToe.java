import java.util.Scanner;

public class TicTacToe {
	
	public static boolean nextTurn (boolean turn){
		if (turn == true)
			return false;
		else
			return true;
	}
	
	public static void main (String args []) {
		int turnCounter = 0;
		int MAXTURNS =9;
		boolean gameOver = false;
		
		
		System.out.println("Let's play Tic Tac Toe:");
		//Initialize a new board object
		Board newboard = new Board();
		newboard.displayBoard();
		System.out.println("");
		System.out.println("Player 1 is x. Player 2 is o");
		//initialize a players
		Scanner playerInput = new Scanner(System.in);
		Player player1 = new Player('x');
		Player player2 = new Player('o');
		boolean player1Turn = true;
		
		while (gameOver == false && turnCounter != MAXTURNS) {
			System.out.println("");
			System.out.print("Player please enter coordinate for row: ");
			int userRow = playerInput.nextInt();
			System.out.print("Player please enter coordinate for column: ");
			int userCol = playerInput.nextInt();
			
			//Check to see if it is player1's turn
			if(player1Turn == true) 
				newboard.insertMove(userRow, userCol, player1.getSymbol());
			else 
				newboard.insertMove(userRow, userCol, player2.getSymbol());
			
			
			System.out.println("");
			newboard.displayBoard();
			System.out.println("");
			turnCounter++;
			player1Turn = nextTurn(player1Turn);
			gameOver = newboard.checkWinner();
		}
		if(newboard.checkWinner() == true) 
		System.out.println("We have a winner! The game is over!");
		else
		System.out.println("We have a tie. The game is over!");
		
		
	}
}