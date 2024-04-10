package org.lecture;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReaderTest {

    private final Path validPath = Paths.get("src", "test", "resources", "testBoard.txt");
    private final Path invalidPath = Paths.get("src", "test", "resources", "nope.txt");
    private final TicTacToeFileReader fileReader = new TicTacToeFileReader();


    @Test
    public void checkPathExist() throws IOException {
        var readingDone = fileReader.readFile(validPath);
        Assertions.assertTrue(readingDone);
    }

    @Test
    public void checkPathNonExist() throws IOException {
        var readingDone = fileReader.readFile(invalidPath);
        Assertions.assertFalse(readingDone);
    }

    @Test
    public void readDataFromFile() {
        char[][] testGameBoard = fileReader.getGameBoard();
        Assertions.assertNotNull(testGameBoard);
    }
}
