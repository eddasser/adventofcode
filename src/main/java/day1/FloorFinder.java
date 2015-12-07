package day1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class FloorFinder {
    private final static char goUpChar = '(';
    private final static char goDownChar = ')';

    public static int getBasementCharacterPosition(String instructions, int startingFloor) {
        int characterPosition = -1;
        int currentFloor = startingFloor;
        for (int i = 0; i < instructions.length() && characterPosition == -1; i++) {
            char currentChar = instructions.charAt(i);
            if (goUpChar == currentChar) {
                currentFloor++;
            } else if (goDownChar == currentChar) {
                currentFloor--;
            }
            if (currentFloor == -1) {
                characterPosition = i + 1;
            }
        }
        return characterPosition;
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
            int basementCharacterPosition = FloorFinder.getBasementCharacterPosition(instructions.toString(), startingFloor);
            System.out.println(String.format("Position : %d", basementCharacterPosition));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
