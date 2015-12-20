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
        return getDimension() + getMinSide() * getSecondMinSide();
    }

    public double getMinSide() {
        return Math.min(length, Math.min(width, height));
    }

    public double getSecondMinSide() {
        double minDimension = getMinSide();
        if (minDimension == length) {
            return Math.min(width, height);
        } else if (minDimension == width) {
            return Math.min(length, height);
        } else {
            return Math.min(length, width);
        }
    }

    public double getRibbonToWrapLength() {
        return 2 * getMinSide() + 2 * getSecondMinSide();
    }

    public double getRibbonForBowLength() {
        return length * width * height;
    }

    public double getRequiredRibbonLength() {
        return getRibbonToWrapLength() + getRibbonForBowLength();
    }

    public static void main(String[] args) {
        List<String> presents = MyFileReader.getContentAsStringList("day2/presents.txt");
        double totalWrappingPaper = 0;
        double totalRibbon = 0;
        for (String p : presents) {
            String[] dimension = p.split("x");
            Present present = new Present(Double.parseDouble(dimension[0]), Double.parseDouble(dimension[1]), Double.parseDouble(dimension[2]));
            double wrappingPaperNeeded = present.getRequiredWrappingPaper();
            double ribbonNeeded = present.getRequiredRibbonLength();
            totalWrappingPaper += wrappingPaperNeeded;
            totalRibbon += ribbonNeeded;
        }
        System.out.println("Total Wrapping Paper : " + totalWrappingPaper);
        System.out.println("Total Ribbon : " + totalRibbon);
    }
}
