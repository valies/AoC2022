package day03;

import support.FileReader;

import java.io.File;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Day3 {
    //Day 3: Rucksack reorganisation
    //Find common item in two compartments
    public static int getResultOfPart1(File txtFile) throws Exception {
        String[] input = FileReader.transformToStringArray(txtFile);
        int result = 0;
        for (String rucksack : input) {
            List<Character> compartment1 = rucksack.substring(0, rucksack.length() / 2).chars().mapToObj(c -> (char) c).toList();
            List<Character> compartment2 = rucksack.substring(rucksack.length() / 2).chars().mapToObj(c -> (char) c).toList();
            Optional<Character> commonItemChar = compartment1.stream().filter(compartment2::contains).findFirst();
            if (commonItemChar.isPresent()) {
                int thisResult = (int) commonItemChar.get() - 'a' + 1;
                if (commonItemChar.get() >= 'A' && commonItemChar.get() <= 'Z') {
                    thisResult = (int) commonItemChar.get() - 'A' + 27;
                }
                result += thisResult;
            } else {
                throw new Exception("Can't find common item in " + compartment1 + ", " + compartment2);
            }
        }
        return result;
    }

    //Day 3: Rucksack reorganisation
    //Find common item in 3 rugsacks
    public static int getResultOfPart2(File txtFile) throws Exception {
        String[] input = FileReader.transformToStringArray(txtFile);
        int result = 0;
        for (int i = 0; i < input.length; i += 3) {
            List<Character> rugsack1 = input[i].chars().mapToObj(c -> (char) c).toList();
            List<Character> rugsack2 = input[i + 1].chars().mapToObj(c -> (char) c).toList();
            List<Character> rugsack3 = input[i + 2].chars().mapToObj(c -> (char) c).toList();
            List<Character> commonItemChars1And2 = rugsack1.stream()
                    .filter(rugsack2::contains).toList();
            Optional<Character> commonItemChar = commonItemChars1And2.stream()
                    .filter(rugsack3::contains).findFirst();
            if (commonItemChar.isPresent()) {
                int thisResult = (int) commonItemChar.get() - 'a' + 1;
                if (commonItemChar.get() >= 'A' && commonItemChar.get() <= 'Z') {
                    thisResult = (int) commonItemChar.get() - 'A' + 27;
                }
                result += thisResult;
            } else {
                throw new Exception("Can't find common item in " + rugsack1 + ", " + rugsack2 + ", " + rugsack3);
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        File txtFile = new File("./src/main/java/day03/input.txt");
        System.out.println("Part 1: " + getResultOfPart1(txtFile));
        System.out.println("Part 2: " + getResultOfPart2(txtFile));
    }
}
