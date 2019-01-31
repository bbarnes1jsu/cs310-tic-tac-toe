package edu.jsu.mcis;

import java.util.Scanner;

public class TicTacToeView {
    
    private final Scanner keyboard;
    
    /* CONSTRUCTOR */
	
    public TicTacToeView() {
        
        /* Initialize scanner (for console keyboard) */
        
        keyboard = new Scanner(System.in);
        
    }
	
    public TicTacToeMove getNextMove(boolean isXTurn) {
        
        /* Prompt the player to enter the row and the column of their next move.
           Return as a TicTacToeMove object. */
        System.out.println("Enter the row and the column of your next move: ");
        int row = keyboard.getNextInt(); //Retrieves next Keyboard Int Input and stores it in row
        int col = keyboard.getNextInt(); //Retrieves next Keyboard Int Input and stores it in col
        TicTacToeMove getRow = newTicTacToeMove(row); //Call method from TicTacToeMove
        TicTacToeMove getCol = newTicTacToeMove(col); //Call method from TicTacToeMove
        getRow.start();
        getCol.start();
        

    }

    public void showInputError() {

        System.out.println("Entered location is invalid, already marked, or out of bounds.");

    }

    public void showResult(String r) {

        System.out.println(r + "!");

    }
    
    public void showBoard(String board) {
        
        System.out.println("\n\n" + board);
        
    }
	
}
