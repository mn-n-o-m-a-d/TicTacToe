package org.lecture;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class GameBoardTest {

    private final char[][] testGameBoard = new char[3][3];
    private final TicTacToeGameBoard ticTacToeGameBoard = new TicTacToeGameBoard(3, 3, testGameBoard);
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void boardIsFull() {

        char [][] fullBoard = new char[3][3];

        for (int i = 0; i < fullBoard.length; i++) {
            for (int j = 0; j < fullBoard.length; j++) {
                fullBoard[i][j] = (char) (i+j);
            }
        }

        Assertions.assertTrue(TicTacToeGameBoard.checkBoardIsFull(fullBoard));
    }

    @Test
    public void legalPlayerMove() {

        char[][] testBoard = ticTacToeGameBoard.loadEmptyBoard();
        testBoard = ticTacToeGameBoard.playerMove('T', 1, 1);
        // System.out.println(Arrays.deepToString(testBoard));
        String errorPlayerMove = "";

        Assertions.assertEquals(errorPlayerMove, outputStream.toString());
    }

    @Test
    public void illegalPlayerMove() {

        char[][] testBoard = ticTacToeGameBoard.loadEmptyBoard();
        boolean testOutOfBounds = false;

        try {
            testBoard = ticTacToeGameBoard.playerMove('O', 123, 123);
        } catch (IndexOutOfBoundsException e) {
            testOutOfBounds = true;
        }

        Assertions.assertTrue(testOutOfBounds);
    }

    @Test
    public void validPlayerChoice() {

        char[][] testBoard = ticTacToeGameBoard.loadEmptyBoard();
        String testChoice = "01";

        Assertions.assertTrue(ticTacToeGameBoard.validPlayerChoice(testChoice));
    }

    @Test
    public void invalidPlayerChoice() {

        char[][] testBoard = ticTacToeGameBoard.loadEmptyBoard();
        String testChoice = "33";

        Assertions.assertFalse(ticTacToeGameBoard.validPlayerChoice(testChoice));
    }
}
