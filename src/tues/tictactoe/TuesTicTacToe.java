package tues.tictactoe;

import java.util.Scanner;

/**
 *
 * @author john
 */
public class TuesTicTacToe {

    public static final Scanner stdin = new Scanner(System.in);

    public static int getPlayerRowColInput() {
        do {
            try {
                int rowOrCol = stdin.nextInt();

                if (rowOrCol < 0) {
                    System.out.println(rowOrCol + " is too low, please try again");
                } else if (rowOrCol >= GameBoard.BOARD_SIZE) {
                    System.out.println(rowOrCol + " is too high, please try again");
                } else {
                    return rowOrCol;
                }
            } catch (Exception e) {
                System.out.println("Invalid input, please try again.");
                stdin.nextLine();
            }
        } while (true);
    }

    public static int[] getMoveFromPlayer(GameBoard board) {
        int[] results = new int[2];
        int row;
        int col;
        boolean isMoveValid;

        if (board.getIsPlayerOnesTurn()) {
            System.out.println("Player One's turn (X)");
        } else {
            System.out.println("Player Two's turn (O)");
        }
        
        do {
            System.out.println("Enter row for token: ");
            row = getPlayerRowColInput();
            System.out.println("Enter column for token: ");
            col = getPlayerRowColInput();

            isMoveValid = board.canPlaceToken(row, col);

            if (!isMoveValid) {
                System.out.println(
                        "That spot is already taken! "
                        + "Please choose another."
                );
            }
        } while (!isMoveValid);

        results[0] = row;
        results[1] = col;
        
        return results;
    }

    public static void playRound() {
        GameBoard board = new GameBoard();
        BoardToken winner;

        do {
            board.printBoard();
            int[] rowAndCol = getMoveFromPlayer(board);
            int row = rowAndCol[0];
            int col = rowAndCol[1];
            BoardToken token;
            
            if (board.getIsPlayerOnesTurn()) {
                token = BoardToken.createXToken();
            } else {
                token = BoardToken.createOToken();
            }
            
            board.placeToken(token, row, col);

        } while (!board.isGameOver());
        
        winner = board.getGameWinner();
        
        if (winner.equals(BoardToken.createXToken())) {
            System.out.println("Player one wins!!");
        } else if (winner.equals(BoardToken.createOToken())) {
            System.out.println("Player two wins!!");
        } else {
            System.out.println("Cat's game.");
            System.out.println("The only winning move is not to play.");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean keepPlaying = true;
        String userInput;

        System.out.println("Let's play a game of Tic-Tac-Toe");

        do {
            playRound();

            System.out.println("Would you like to play again? (y/n)");
            userInput = stdin.nextLine();

            switch (userInput.charAt(0)) {
                case 'y':
                case 'Y':
                    keepPlaying = true;
                    break;
                case 'n':
                case 'N':
                default:
                    keepPlaying = false;
                    break;
            }
        } while (keepPlaying);
    }

}
