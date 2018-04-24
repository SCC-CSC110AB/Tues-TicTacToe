package tues.tictactoe;

/**
 *
 * @author john
 */
public class GameBoard {
    public static final int BOARD_SIZE = 3;
    
    private BoardToken[][] boardState;
    private boolean isPlayerOnesTurn;
    
    public GameBoard() {
        boardState = new BoardToken[BOARD_SIZE][BOARD_SIZE];
        
        for (int i = 0; i < boardState.length; i++) {
            for (int j = 0; j < boardState[i].length; j++) {
                boardState[i][j] = BoardToken.createEmptyToken();
            }
        }
        
        isPlayerOnesTurn = true;
    }
    
    public boolean isGameOver() {
        // TODO: FINISH THIS METHOD
        return false;
    }
    
    public void printBoard() {
        System.out.println();
        
        for(int i = 0; i < boardState.length; i++) {
            if (i != 0) {
                System.out.println("---------");
            }
            
            for(int j = 0; j < boardState[i].length; j++) {
                if (j != 0) {
                    System.out.print(" | ");
                }
                
                System.out.print(boardState[i][j].toString());
            }
            
            System.out.println();
        }
        
        System.out.println();
    }
    
    public void placeToken(BoardToken token, int row, int col) {
        boardState[row][col] = token;
        isPlayerOnesTurn = !isPlayerOnesTurn;
    }
    
    public boolean canPlaceToken(int row, int col) {
        return boardState[row][col].equals(BoardToken.createEmptyToken());
    }
    
    public boolean getIsPlayerOnesTurn() {
        return this.isPlayerOnesTurn;
    }
    
    public BoardToken getGameWinner() {
        // TODO: FINISH THIS METHOD
        return BoardToken.createEmptyToken();
    }
}
