package day01;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day1Test {

    @Test
    public void day1TestPart1()
    {
        File txtFile = new File("src/test/java/day01/input.txt");
        int expected = 24000;
        int actual = Day1.getResultOfPart1(txtFile);
        assertEquals(expected, actual);
    }

    @Test
    public void day1TestPart2()
    {
        File txtFile = new File("src/test/java/day01/input.txt");
        int expected = 45000;
        int actual = Day1.getResultOfPart2(txtFile);
        assertEquals(expected, actual);
    }
}
