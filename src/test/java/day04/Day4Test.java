package day04;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day4Test {

    @Test
    public void day4TestPart1() {
        File txtFile = new File("src/test/java/day04/input.txt");
        int expected = 2;
        int actual = Day4.getResultOfPart1(txtFile);
        assertEquals(expected, actual);
    }

    @Test
    public void day4TestPart2() {
        File txtFile = new File("src/test/java/day04/input.txt");
        int expected = 4;
        int actual = Day4.getResultOfPart2(txtFile);
        assertEquals(expected, actual);
    }
}
