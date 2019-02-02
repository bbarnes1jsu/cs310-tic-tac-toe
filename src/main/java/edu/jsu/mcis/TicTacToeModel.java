package edu.jsu.mcis;

public class TicTacToeModel {
    
    private Mark[][] board; /* Game board */
    private boolean xTurn;  /* True if X is current player */
    private int width;      /* Size of game board */
    
    /* ENUM TYPE DEFINITIONS */
    
    /* Mark (represents X, O, or an empty square */
    
    public enum Mark {
        
        X("X"), 
        O("O"), 
        EMPTY("-");

        private String message;
        
        private Mark(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    /* Result (represents the final state of the game: X wins, O wins, a TIE,
       or NONE if the game is not yet over) */
    
    public enum Result {
        
        X("X"), 
        O("O"), 
        TIE("TIE"), 
        NONE("NONE");

        private String message;
        
        private Result(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    /* CONSTRUCTOR */
    
    public TicTacToeModel() {
        
        this(TicTacToe.DEFAULT_WIDTH);
        
    }
    
    /* CONSTRUCTOR */
    
    public TicTacToeModel(int width) {
        
        /* Initialize width; X goes first */
        
        this.width = width;
        xTurn = true;
        
        /* Create board (width x width) as a 2D Mark array */
        
        board = new Mark[width][width];

        /* Initialize board by filling every square with empty marks */
        
        for(int i = 0; i < width; i++){
            for(int h = 0; h < width;h++){
                board[i][h] = Mark.EMPTY;
            }
        }
        
    }
	
    public boolean makeMark(int row, int col) {
        
        /* Use "isValidSquare()" to check if the specified location is in range,
           and use "isSquareMarked()" to see if the square is empty!  If the
           specified location is valid, make a mark for the current player, then
           toggle "xTurn" from true to false (or vice-versa) to switch to the
           other player before returning TRUE.  Otherwise, return FALSE. */
        boolean check = false;
        if(isValidSquare(row,col)){
            if(!isSquareMarked(row,col)){
                if(xTurn){
                    board[row][col]= Mark.X;
                }
                else{
                    board[row][col]= Mark.O;
                }
                xTurn = !xTurn;
                check = true;
            }
            return check;
        }
        else{
            return false;
        }
        
        
        
    }
	
    private boolean isValidSquare(int row, int col) {
        
        /* Return TRUE if the specified location is within the bounds of the board */
        
        if((row < width) && (row >= 0) && (col < width) && (col >= 0)){
            return true;
        }
        else{
            return false;
        }
        
    }
	
    private boolean isSquareMarked(int row, int col) {
        
        /* Return TRUE if the square at specified location is marked */
        if(board[row][col] == Mark.EMPTY){
            return false;
        }
        else{
            return true;
        }

            
    }
	
    public Mark getMark(int row, int col) {
        
        /* Return the mark from the square at the specified location */
        
        Mark area = board[row][col];
        return area;
    
            
    }
	
    public Result getResult() {
        
        /* Call "isMarkWin()" to see if X or O is the winner, if the game is a
           TIE, or if the game is not over.  Return the corresponding Result
           value */
        
        if(isMarkWin(Mark.X)){
            return Result.X;
        }
        else if(isMarkWin(Mark.O)){
            return Result.O;
        }
        else if(isTie()){
            return Result.TIE;
        }
        else{
            return Result.NONE;
        }

        
    }
	
    private boolean isMarkWin(Mark mark) {
        
        /* Check the squares of the board to see if the specified mark is the
           winner */
        // Checks vertically 
        int count = 0;
        for(int a = 0; a < width; a++){
            count = 0;
            for(int b = 0; b < width; b++){
                if(getMark(a,b) == mark){
                    count++;
                }

            }
            if(count == width){
            return true;
            }    
        }
        
        //Checks horizontally
        for(int k = 0; k < width; k++){
            count = 0;
            for( int l = 0; l < width; l++){
                if(getMark(k,l) == mark){
                    count++;
                }
                if(count == width){
                    return true;
                }
            }
        }
        
        //Checks Diagonally
        for(int m = 0; m < width; m++){
            if(getMark(m,m) == mark){
                count++;
            }
        }
        if(count == width){
            return true;
        }

        //Checks Diagonally the other way
        count = 0;
        for(int n = 0; n < width; n++){
            if(getMark(n,width-n-1)==mark){
                count++;
            }
        }
        if(count==width){
            return true;
        }
        return false;
    }
	
    private boolean isTie() {
        
        /* Check the squares of the board to see if the game is a tie */
        
        if(isMarkWin(Mark.X)||isMarkWin(Mark.O)){
            return false;
        }
        for (int o = 0; o < width; o++) {
            for(int p = 0;p < width; p++) {
                if (getMark(o,p) == Mark.EMPTY) {
                    return false;
                }
            }
        }
        return true;
        
        
    }

    public boolean isGameover() {
        
        /* Return TRUE if the game is over */
        
        return (Result.NONE != getResult());
        
    }

    public boolean isXTurn() {
        
        /* Getter for xTurn */
        
        return xTurn;
        
    }

    public int getWidth() {
        
        /* Getter for width */
        
        return width;
        
    }
    
    @Override
    public String toString() {
        
        StringBuilder output = new StringBuilder("  ");
        
        /* Output the board contents as a string (see examples) */
        
        System.out.println("\n\n" + board);
        
        return output.toString();
        
    }
    
}
