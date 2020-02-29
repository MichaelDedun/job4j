package ru.job4j.array;

public class MatrixCheck {

    public static boolean monoHorizontal(char[][] board, int row) {
        boolean result = true;
        for (int i = 0; i < board.length - 1; i++) {
            if (board[row][i] != board[row][i + 1]) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static boolean monoVertical(char[][] board, int column) {
        boolean result = true;
        for (int i = 0; i < board.length - 1; i++) {
            if (board[i][column] != board[i + 1][column]) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static char[] extractDiagonal(char[][] board) {
        char[] rsl = new char[board.length];
        for (int i = 0; i < board.length; i++)
            rsl[i] = board[i][i];
        return rsl;
    }

    public static boolean isWin(char[][] board) {
        boolean result = false;
        if (!isWith(board))
            return false;
        for (int i = 0; i < board.length; i++) {
            if ((checkHorizontal(board, i, 'X') && monoHorizontal(board, i)) || (checkVertical(board, i, 'X') && monoVertical(board, i))) {
                result = true;
                break;
            }
        }
        return result;
    }

    public static boolean isWith(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][i] == 'X') {
                return true;
            }
        }
        return false;
    }

    public static boolean checkHorizontal(char[][] board, int row, char symbol) {
        boolean result = false;
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == symbol) {
                result = true;
                break;
            }
        }
        return result;
    }

    public static boolean checkVertical(char[][] board, int column, char symbol) {
        boolean result = false;
        for (int i = 0; i < board.length; i++) {
            if (board[i][column] == symbol) {
                result = true;
                break;
            }
        }
        return result;
    }

}
