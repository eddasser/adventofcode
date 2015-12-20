package day1;

import common.MyFileReader;

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
        int startingFloor = 0;
        String instructions = MyFileReader.getContentAsString("day1/puzzle.txt");
        int basementCharacterPosition = FloorFinder.getBasementCharacterPosition(instructions, startingFloor);
        System.out.println(String.format("Position : %d", basementCharacterPosition));
    }
}
