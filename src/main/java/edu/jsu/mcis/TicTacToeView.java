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

        /*if(isXTurn()){
            System.out.println("Player 1 (X) Move: ");
        }
        else{
            System.out.println("Player 2 (O) Move: ");
        } */
        
        System.out.println("Enter the row and the column numbers, speperated by a space: ");

        int row = Integer.parseInt(keyboard.next()); //Retrieves next Keyboard Int Input and stores it
        int col = Integer.parseInt(keyboard.next()); //Retrieves next Keyboard Int Input and stores it

        TicTacToeMove move = new TicTacToeMove(row,col);

        return move;

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
