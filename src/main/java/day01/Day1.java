package day01;

import support.FileReader;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;

public class Day1 {
    //Day 1: Calorie Counting
    //Find the elf with the most calories
    public static int getResultOfPart1(File txtFile) {
        String[] input = FileReader.transformToStringArray(txtFile);
        int calories = 0;
        int maxCalories = 0;
        for (String row : input) {
            if (!Objects.equals(row, "")) {
                calories += Integer.parseInt(row);
            } else {
                if (calories > maxCalories) {
                    maxCalories = calories;
                }
                calories = 0;
            }
        }
        return maxCalories;
    }

    public static int getResultOfPart2(File txtFile) {
        //Day 1: Calorie Counting
        //Find the three elfs with the most calories
        String[] input = FileReader.transformToStringArray(txtFile);
        int calories = 0;
        Integer[] maxCalories = {0, 0, 0};
        for (int i = 0; i < input.length; i++) {
            if (!Objects.equals(input[i], "")) {
                calories += Integer.parseInt(input[i]);
                if (i == input.length - 1) {
                    switchWhenBigger(calories, maxCalories);
                }
            } else {
                switchWhenBigger(calories, maxCalories);
                calories = 0;
            }
        }
        return maxCalories[0] + maxCalories[1] + maxCalories[2];
    }

    private static void switchWhenBigger(int calories, Integer[] maxCalories) {
        Arrays.sort(maxCalories);
        if (calories > maxCalories[0]) {
            maxCalories[0] = calories;
        }
    }

    public static void main(String[] args) {
        File txtFile = new File("src/main/puzzles/day01/input.txt");
        System.out.println("Part 1: " + getResultOfPart1(txtFile));
        System.out.println("Part 2: " + getResultOfPart2(txtFile));
    }
}
