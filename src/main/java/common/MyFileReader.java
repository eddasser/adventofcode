package common;

import day1.FloorFinder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MyFileReader {

    public static List<String> getContentAsStringList(String filename) {
        List<String> content = new ArrayList();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(FloorFinder.class.getClassLoader().getResourceAsStream(filename)));
        String currentLine;
        try {
            while ((currentLine = bufferedReader.readLine()) != null) {
                content.add(currentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }


    public static String getContentAsString(String filename) {
        StringBuilder content = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(FloorFinder.class.getClassLoader().getResourceAsStream(filename)));
        String currentLine;
        try {
            while ((currentLine = bufferedReader.readLine()) != null) {
                content.append(currentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }
}
