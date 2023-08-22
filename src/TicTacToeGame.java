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



}








