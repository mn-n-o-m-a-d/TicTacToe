package org.lecture;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class GameLogicTest {

    TicTacToeGameLogic ticTacToeGameLogic = new TicTacToeGameLogic('X');
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();


    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
    }


    @Test
    public void boardIsFull() {

        char[][] testGameBoard = new char[3][3];

        String fullBoard = """
                     
                >>>  Tic Tac Toe  <<<
                                
                     0   1   2
                0    X   X   X
                1    X   X   X
                2    X   X   X
                                
                Game Over - Game board is full...
                """;

        for (int i = 0; i < testGameBoard.length; i++) {
            for (int j = 0; j < testGameBoard.length; j++) {
                testGameBoard[i][j] = 'X';
            }
        }

        ticTacToeGameLogic.displayGameMenu(testGameBoard);

        Assertions.assertEquals(fullBoard, outputStream.toString());
    }

    @Test
    public void checkWinner() {

        char[][] testGameBoard = new char[3][3];

        String testWinner = """
                
                >>>  Tic Tac Toe  <<<
                                
                     0   1   2
                0    X   -   -
                1    -   X   -
                2    -   -   X
                                
                Player X is the Winner!       
                """;

        for (int i = 0; i < testGameBoard.length; i++) {
            for (int j = 0; j < testGameBoard.length; j++) {
                testGameBoard[i][j] = '-';
            }
        }
        testGameBoard[0][0] = 'X';
        testGameBoard[1][1] = 'X';
        testGameBoard[2][2] = 'X';

        ticTacToeGameLogic.displayGameMenu(testGameBoard);

        Assertions.assertEquals(testWinner, outputStream.toString());
    }
}
