import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TicTacToeGame extends JFrame {

    private final char[][] board = new char[3][3];

    private final JButton[][] buttons = new JButton[3][3];

    private static char currentPlayer = 'X';


    public TicTacToeGame() {

        setTitle("Tic-Tac-Toe");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 3));

        initializeButtons();
        initializeBoard();
    }
        private void initializeButtons() {
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    buttons[row][col] = new JButton("");
                    buttons[row][col].setFont(new Font("Arial", Font.PLAIN, 48));
                    buttons[row][col].setFocusPainted(false);
                    buttons[row][col].setBackground(Color.WHITE);
                    buttons[row][col].addActionListener(new ButtonClickListener(row, col));
                    add(buttons[row][col]);
                }
            }
        }

    private void initializeBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = ' ';
            }
        }
    }

    private void printBoard() {
        System.out.println("Current board:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private class ButtonClickListener implements ActionListener {
        private final int row;
        private final int col;

        public ButtonClickListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (buttons[row][col].getText().equals("") && !isGameWon() && !isBoardFull()) {
                buttons[row][col].setText(String.valueOf(currentPlayer));
                buttons[row][col].setForeground(currentPlayer == 'X' ? Color.BLUE : Color.RED);
                board[row][col] = currentPlayer;
                printBoard();
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';

                if (isGameWon()) {
                    JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " wins!");
                    resetBoard();
                } else if (isBoardFull()) {
                    JOptionPane.showMessageDialog(null, "It's a draw!");
                    resetBoard();
                }
            }
        }
    }

    private boolean isGameWon() {
        for (int i = 0; i < 3; i++) {
            if (checkRow(i) || checkColumn(i)) {
                return true;
            }
        }

        return checkDiagonals() || checkAntiDiagonals();
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

    private void resetBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col].setText("");
                buttons[row][col].setBackground(Color.WHITE);
            }
        }
        currentPlayer = 'X';
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TicTacToeGame game = new TicTacToeGame();
            game.setVisible(true);
        });
    }


}

























