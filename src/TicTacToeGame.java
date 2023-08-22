import java.util.Scanner;

public class TicTacToeGame{

    private static char[][] board = new char[3][3];

    private static char currentPlayer = 'X';

    public static void main(String[] args) {
        TicTacToeGame game = new TicTacToeGame();
        game.initializeBoard();
        game.playGame();
    }

    private void initializeBoard() {
        for ( int i=0; i<3;i++ );
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    private void printBoard() {
        System.out.println(" 0 1 2");
        for (int i=0; i<3; i++){
            System.out.println(i + " ");
            for (int j=0; j<3; j++){
                System.out.print(board[i][j]+ " ");
            }

            System.out.println();
        }

    }

    private void playGame() {
        Scanner scanner = new Scanner(System.in);
        boolean gameWon = false;

        while (!gameWon){
            System.out.println("Player " + currentPlayer + ", enter row (0-2) and column (0-2): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
        }

        if (isValidMove(row, col)) {
            board[row][col] = currentPlayer;
            printBoard();
            gameWon = checkWin(row, col);
            if (gameWon) {
                System.out.println("Player " + currentPlayer + " wins!");
            } else if (isBoardFull()) {
                System.out.println("It's a draw!");
                break;
            }
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        } else {
            System.out.println("Invalid move. Try again.");
        }
    }

    scanner.close();

    private boolean isValidMove(int row, int col) {
        return row>=0 && row<3 && col>=0 && col<3 && board[row][col] == ' ';
    }








}

















