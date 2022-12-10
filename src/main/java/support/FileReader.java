package support;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {

    public static String[] transformToStringArray(File txtFile) {
        Scanner scan = scanFile(txtFile);
        ArrayList<String> data = new ArrayList<>();
        while(scan.hasNextLine()){
            data.add(scan.nextLine());
        }
        return data.toArray(new String[]{});
    }

    public static Scanner scanFile(File txtFile) {
        Scanner scan = null;
        try {
            scan = new Scanner(txtFile);
        } catch (FileNotFoundException e) {
            System.out.println("Error occurred when trying to read file: " + e);
        }
        return scan;
    }
}

