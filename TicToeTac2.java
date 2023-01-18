
import java.util.Scanner;

public class TicToeTac {
    static char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
    static char currentPlayer = 'X';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean gameOver = false;
        while (!gameOver) {
            printBoard();
            System.out.print("Enter row (0, 1, 2) for player " + currentPlayer + ": ");
            int row = scanner.nextInt();
            System.out.print("Enter column (0, 1, 2) for player " + currentPlayer + ": ");
            int col = scanner.nextInt();
            if (board[row][col] == ' ') {
                board[row][col] = currentPlayer;
            } else {
                System.out.println("The cell is already filled. Try again.");
                continue;
            }
            if (checkWin()) {
                System.out.println(currentPlayer + " wins!");
                gameOver = true;
            }
            if (checkTie()) {
                System.out.println("Tie game!");
                gameOver = true;
            }
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }

    private static void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean checkWin() {
        // check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true;
            }
        }
        // check columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                return true;
            }
        }
        // check diagonals
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            return true;
        }
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
            return true;
        }
        return false;
    }

    private static boolean checkTie() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}