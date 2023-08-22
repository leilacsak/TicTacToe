public class TicTacToeGame{

    private static char[][] board = new char[3][3];

    private static char curentPlayer = 'X';

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

}








