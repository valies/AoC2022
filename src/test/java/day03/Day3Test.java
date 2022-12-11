package day03;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day3Test {

    @Test
    public void day3TestPart1() throws Exception {
        File txtFile = new File("src/test/java/day03/input.txt");
        int expected = 157;
        int actual = Day3.getResultOfPart1(txtFile);
        assertEquals(expected, actual);
    }

    @Test
    public void day3TestPart2() throws Exception {
        File txtFile = new File("src/test/java/day03/input.txt");
        int expected = 70;
        int actual = Day3.getResultOfPart2(txtFile);
        assertEquals(expected, actual);
    }
}
