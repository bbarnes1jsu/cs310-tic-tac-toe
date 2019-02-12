package edu.jsu.mcis;

import java.awt.event.ActionListener;

public class TicTacToeController implements ActionListener {

    private final TicTacToeModel model;
    private final TicTacToeView view;
    
    /* CONSTRUCTOR */

    public TicTacToeController(int width) {
        
        /* Initialize model, view, and width */

        model = new TicTacToeModel(width);
        view = new TicTacToeView(width);
        
    }

    public void start(){
    
        /* MAIN LOOP (repeats until game is over) */

        /* Display the board using the View's "showBoard()", then use
           "getNextMove()" to get the next move from the player.  Enter
           the move (using the Model's "makeMark()", or display an error
           using the View's "showInputError()" if the move is invalid. */
        /*
        while(!model.isGameover()){
            view.showBoard(model.toString());
            

            TicTacToeMove move =  view.getNextMove(model.isXTurn());
            view.updateSquares();

            while(!model.makeMark(move.getRow(), move.getCol())){
                view.showInputError();
                move =  view.getNextMove(model.isXTurn());
                break;
            }

        }
        
                
        
        /* After the game is over, show the final board and the winner */

        /*view.showBoard(model.toString());

        view.showResult(model.getResult().toString()); */
        
    }

    public String getMarkAsString(int row, int col) {        
        return (model.getMark(row, col).toString());        
    }
    
    public TicTacToeView getView() {        
        return view;        
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        JButton button = ((JButton) event.getSource()); // Get button name
        String squareSpot = button.getName();
        squareSpot = squareSpot.replaceFirst("Square","");
        
        String[] location = squareSpot.spilt("");
        int row = Integer.parseInt(location(0));
        int col = Integer.parseInt(location(1));
        model.makeMark(row, col);
        view.updateSquares();
        if(model.gameIsOver()){
            view.disableSquares();
             view.showResult(model.getResult().toString());
        }
    }


}
