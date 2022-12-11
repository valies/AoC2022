package day02;

import support.FileReader;

import java.io.File;
import java.util.ArrayList;
import java.util.Optional;

public class Day2 {
    //Day 2: Rock, paper, scissors
    //Get my score
    public static int getResultOfPart1(File txtFile) {
        String[] input = FileReader.transformToStringArray(txtFile);
        ArrayList<String> points = new ArrayList<>();
        //Opponent, me, score for my choice, score for the outcome
        points.add("A X-1-3");
        points.add("A Y-2-6");
        points.add("A Z-3-0");
        points.add("B X-1-0");
        points.add("B Y-2-3");
        points.add("B Z-3-6");
        points.add("C X-1-6");
        points.add("C Y-2-0");
        points.add("C Z-3-3");
        //Calculate
        int myPoints = 0;
        for (String game : input) {
            Optional<String> optional = points.stream()
                    .filter(x -> x.startsWith(game)).findFirst();
            if(optional.isPresent()) {
                String result = optional.get();
                myPoints += Integer.parseInt(result.split("-")[1]) + Integer.parseInt(result.split("-")[2]);
            }
        }
        return myPoints;
    }

    //Day 2: Rock, paper, scissors
    //Get my score
    public static int getResultOfPart2(File txtFile) {
        String[] input = FileReader.transformToStringArray(txtFile);
        ArrayList<String> points = new ArrayList<>();
        //Opponent, me, score for my choice, score for the outcome
        points.add("A A-1-3");
        points.add("A B-2-6");
        points.add("A C-3-0");
        points.add("B A-1-0");
        points.add("B B-2-3");
        points.add("B C-3-6");
        points.add("C A-1-6");
        points.add("C B-2-0");
        points.add("C C-3-3");
        //Calculate
        int myPoints = 0;
        for (String game : input) {
            String opponentsChoice = game.split(" ")[0];
            String myChoice = game.split(" ")[1];
            String scoreOfMyChoice = switch(myChoice) {
                case "X" -> "0";
                case "Y" -> "3";
                default -> "6";
            };
            Optional<String> optional = points.stream()
                    .filter(x -> x.startsWith(opponentsChoice) && x.endsWith(scoreOfMyChoice))
                    .findFirst();
            if(optional.isPresent()) {
                String result = optional.get();
                myPoints += Integer.parseInt(result.split("-")[1]) + Integer.parseInt(result.split("-")[2]);
            }
        }
        return myPoints;
    }

    public static void main(String[] args) {
        File txtFile = new File("./src/main/java/day02/input.txt");
        System.out.println("Part 1: " + getResultOfPart1(txtFile));
        System.out.println("Part 2: " + getResultOfPart2(txtFile));
    }
}
