package day2;

import common.MyFileReader;

import java.util.List;

public class Present {
    private double length;
    private double width;
    private double height;

    public Present(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public double getDimension() {
        return 2 * (length * width) + 2 * (width * height) + 2 * (length * height);
    }

    public double getRequiredWrappingPaper() {
        return getDimension() + Math.min(length * width, Math.min(width * height, length * height)
        );
    }

    public static void main(String[] args) {
        List<String> presents = MyFileReader.getContentAsStringList("day2/presents.txt");
        double total = 0;
        for (String p : presents) {
            String[] dimension = p.split("x");

            Present present = new Present(Double.parseDouble(dimension[0]), Double.parseDouble(dimension[1]), Double.parseDouble(dimension[2]));
            Double needed = present.getRequiredWrappingPaper();
            total += needed;
            System.out.println("PRESNET : " + p + " = " + needed);
        }
        System.out.println("Total : " + total);
    }
}
