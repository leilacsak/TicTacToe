import java.util.Scanner;

public class TicTacToeGame {

    private static char[][] board = new char[3][3];

    private static char currentPlayer = 'X';
    Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        TicTacToeGame game = new TicTacToeGame();
        game.initializeBoard();
        game.playGame();
        game.closeScanner();
    }

    // initialization of the board
    private void initializeBoard() {
        for (int i = 0; i < 3; i++) ;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    // print the board on consol
    private void printBoard() {
        System.out.println(" 0 1 2");
        for (int i = 0; i < 3; i++) {
            System.out.println(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }

            System.out.println();
        }

    }

    // game logic
    private void playGame() {

        boolean gameWon = false;


        while (!gameWon) {
            System.out.println("Player " + currentPlayer + ", enter row (0-2) and column (0-2): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

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

    }

    // Check the validity of movement
    private boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ';
    }

    // Check Methods

    // Checks if there is a winner
    private boolean checkWin(int row, int col) {
        return checkRow(row) || checkColumn(col) || checkDiagonals() || checkAntiDiagonals();
    }

    // Checks whether the same player has filled all the fields in a given row
    private boolean checkRow(int row) {
        return board[row][0] == currentPlayer && board[row][1] == currentPlayer && board[row][2] == currentPlayer;
    }

    // Checks whether the same player has filled all the fields in a given column
    private boolean checkColumn(int col) {
        return board[0][col] == currentPlayer && board[1][col] == currentPlayer && board[2][col] == currentPlayer;
    }

    //Checks the main diagonal to see if the same player has filled all the fields in it
    private boolean checkDiagonals() {
        return board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer;
    }

    //Checks the main anti-diagonal to see if the same player has filled all the fields in it.
    private boolean checkAntiDiagonals() {
        return board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer;
    }

    // Checking if the game is a draw

    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    private void closeScanner() {
        scanner.close();

    }
}

















