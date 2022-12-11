package day02;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day2Test {

    @Test
    public void day2TestPart1()
    {
        File txtFile = new File("src/test/java/day02/input.txt");
        int expected = 15;
        int actual = Day2.getResultOfPart1(txtFile);
        assertEquals(expected, actual);
    }

    @Test
    public void day2TestPart2()
    {
        File txtFile = new File("src/test/java/day02/input.txt");
        int expected = 12;
        int actual = Day2.getResultOfPart2(txtFile);
        assertEquals(expected, actual);
    }
}
