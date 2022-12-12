package day04;

import support.FileReader;

import java.io.File;
import java.util.ArrayList;

public class Day4 {
    //Day 4: Camp cleanup
    //Fully contains
    public static int getResultOfPart1(File txtFile) {
        ArrayList<String[]> input = FileReader.transformToList(txtFile, ",");
        int result = 0;
        for (String[] team : input) {
            ArrayList<Integer> sectionsElf1 = new ArrayList<>();
            for (int i = Integer.parseInt(team[0].split("-")[0]); i <= Integer.parseInt(team[0].split("-")[1]); i++) {
                sectionsElf1.add(i);
            }
            ArrayList<Integer> sectionsElf2 = new ArrayList<>();
            for (int i = Integer.parseInt(team[1].split("-")[0]); i <= Integer.parseInt(team[1].split("-")[1]); i++) {
                sectionsElf2.add(i);
            }
            if (sectionsElf1.containsAll(sectionsElf2) || sectionsElf2.containsAll(sectionsElf1)) {
                result += 1;
            }
        }
        return result;
    }

    //Day 4: Camp cleanup
    //Overlap
    public static int getResultOfPart2(File txtFile) {
        ArrayList<String[]> input = FileReader.transformToList(txtFile, ",");
        int result = 0;
        for (String[] team : input) {
            ArrayList<Integer> sections = new ArrayList<>();
            for (int i = Integer.parseInt(team[0].split("-")[0]); i <= Integer.parseInt(team[0].split("-")[1]); i++) {
                sections.add(i);
            }
            for (int i = Integer.parseInt(team[1].split("-")[0]); i <= Integer.parseInt(team[1].split("-")[1]); i++) {
                sections.add(i);
            }
            if (sections.size() > sections.stream().distinct().toList().size()) {
                result += 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        File txtFile = new File("./src/main/java/day04/input.txt");
        System.out.println("Part 1: " + getResultOfPart1(txtFile));
        System.out.println("Part 2: " + getResultOfPart2(txtFile));
    }
}
