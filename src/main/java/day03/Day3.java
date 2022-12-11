package day03;

import support.FileReader;

import java.io.File;
import java.util.List;
import java.util.Optional;

public class Day3 {
    //Day 3: Rucksack reorganisation
    public static int getResultOfPart1(File txtFile) throws Exception {
        String[] input = FileReader.transformToStringArray(txtFile);
        int result = 0;
        for (String rucksack: input) {
            List<Character> compartement1 = rucksack.substring(0, rucksack.length() / 2).chars().mapToObj(c -> (char) c).toList();
            List<Character> compartement2 = rucksack.substring(rucksack.length() / 2).chars().mapToObj(c -> (char) c).toList();
            Optional<Character> commonItemChar = compartement1.stream().filter(compartement2::contains).findFirst();
            if (commonItemChar.isPresent()) {
                int thisRucksacksResult = (int) commonItemChar.get() - 'a' + 1;
                if (commonItemChar.get() >= 'A' && commonItemChar.get() <= 'Z') {
                    thisRucksacksResult = (int) commonItemChar.get() - 'A' + 27;
                }
                result += thisRucksacksResult;
            } else {
                throw new Exception("Can't find common item in " + compartement1 + " " + compartement2);
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        File txtFile = new File("./src/main/java/day03/input.txt");
        System.out.println("Part 1: " + getResultOfPart1(txtFile));
    }
}
