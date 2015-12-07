package day1;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class FloorFinder {
    private final static char goUpChar = '(';
    private final static char goDownChar = ')';

    public static int getFloor(String instructions, int startingFloor) {
        return startingFloor + StringUtils.countMatches(instructions, goUpChar) - StringUtils.countMatches(instructions, goDownChar);
    }

    public static void main(String[] args) {
        try {
            int startingFloor = 0;
            StringBuilder instructions = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(FloorFinder.class.getClassLoader().getResourceAsStream("day1/puzzle.txt")));
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                instructions.append(currentLine);
            }
            int floor = FloorFinder.getFloor(instructions.toString(), startingFloor);
            System.out.println(String.format("Floor : %d", floor));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
