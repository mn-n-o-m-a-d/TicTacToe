package org.lecture;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import java.util.InputMismatchException;

@Getter
@ToString
@EqualsAndHashCode
public class TicTacToeGameBoard {

    private final int row;
    private final int col;
    private final char[][] gameBoard;

    public TicTacToeGameBoard(int row, int col, char[][] gameBoard) {
        this.row = row;
        this.col = col;
        this.gameBoard = gameBoard;
    }

    public char[][] loadEmptyBoard() {
        return getEmptyBoard();
    }

    /**
     * Makes the players move into the game board, shows an exception if it doesn't work
     *
     * @param player who takes the move
     * @param row    target of the move
     * @param col    target of the move
     * @return a 2D char array, with the actual game board and the player move
     */
    public char[][] playerMove(char player, int row, int col) {
        char[][] board = this.gameBoard;

        try {
            board[row][col] = player;
        } catch (InputMismatchException exception) {
            System.err.println(exception.getMessage());
        }

        return board;
    }

    /**
     * Checks the game board, returns if it is possible to make a player move
     * @param gameBoard information about the actual game board
     * @return true when the game board is full
     */
    public static boolean checkBoardIsFull(char[][] gameBoard) {
        boolean boardIsFull = true;

        for (char[] c : gameBoard) {
            for (char value : c) {
                switch (value) {
                    case '-' -> boardIsFull = false;
                }
            }
        }

        return boardIsFull;
    }

    /**
     * Checks if the player input and returns if the input is a valid option. Checks the field numbers and if the field is free
     * @param choice player choice / player move
     * @return true if the player choice is possible
     */
    public boolean validPlayerChoice(String choice) {
        char[][] board = this.gameBoard;

        boolean validChoice = false;
        if (((choice.equals("00") || choice.equals("01") || choice.equals("02") || choice.equals("10") || choice.equals("11") || choice.equals("12")
        || choice.equals("20") || choice.equals("21") || choice.equals("22")) && (board[validPlayerMove(choice)[0]][validPlayerMove(choice)[1]] == '-'))) {
            validChoice = true;
        }

        return validChoice;
    }

    /**
     * Convert the player input to an int and put it into an array (convert from String to int)
     * @param choice player move input
     * @return an int array, with the converted player move
     */
    public int[] validPlayerMove(String choice) {
        return new int[]{Integer.parseInt(String.valueOf(choice.charAt(0))), Integer.parseInt(String.valueOf(choice.charAt(1)))};
    }

    /**
     * Build an empty game board with "-" signs on every position
     * @return a 2D char array with an empty game board
     */
    private char[][] getEmptyBoard() {
        char[][] board = this.gameBoard;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = '-';
            }
        }
        return board;
    }
}
