import java.io.*;
import java.util.*;

public class Main {

    public static class LineSegment {
        double x1, y1, x2, y2;

        public LineSegment(double x1, double y1, double x2, double y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }

        public double length() {
            return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        }
    }

    public static class Rectangle {
        double x1, y1, x2, y2;

        public Rectangle(double x1, double y1, double x2, double y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }

        public double perimeter() {
            return 2 * ((x2 - x1) + (y2 - y1));
        }
    }

    public static class Circle {
        double x, y, radius;

        public Circle(double x, double y, double radius) {
            this.x = x;
            this.y = y;
            this.radius = radius;
        }

        public double area() {
            return Math.PI * Math.pow(radius, 2);
        }
    }
  
    public static void processFile(String inputFile, String outputFile) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

        String line;
        
        LineSegment longestLineSegment = null;
        double maxLineLength = -Double.MAX_VALUE;
        
        Rectangle largestRectangle = null;
        double maxPerimeter = -Double.MAX_VALUE;
        
        Circle smallestCircle = null;
        double minArea = Double.MAX_VALUE;

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("\\s+");
            int figureType = Integer.parseInt(parts[0]);

            switch (figureType) {
                case 1:
                    if (parts.length == 5) {
                        double x1 = Double.parseDouble(parts[1]);
                        double y1 = Double.parseDouble(parts[2]);
                        double x2 = Double.parseDouble(parts[3]);
                        double y2 = Double.parseDouble(parts[4]);
                        LineSegment lineSegment = new LineSegment(x1, y1, x2, y2);
                        double length = lineSegment.length();
                        if (length > maxLineLength) {
                            maxLineLength = length;
                            longestLineSegment = lineSegment;
                        }
                    }
                    break;
                case 2:
                    if (parts.length == 5) {
                        double x1 = Double.parseDouble(parts[1]);
                        double y1 = Double.parseDouble(parts[2]);
                        double x2 = Double.parseDouble(parts[3]);
                        double y2 = Double.parseDouble(parts[4]);
                        Rectangle rectangle = new Rectangle(x1, y1, x2, y2);
                        double perimeter = rectangle.perimeter();
                        if (perimeter > maxPerimeter) {
                            maxPerimeter = perimeter;
                            largestRectangle = rectangle;
                        }
                    }
                    break;
                case 3:
                    if (parts.length == 4) {
                        double x = Double.parseDouble(parts[1]);
                        double y = Double.parseDouble(parts[2]);
                        double radius = Double.parseDouble(parts[3]);
                        Circle circle = new Circle(x, y, radius);
                        double area = circle.area();
                        if (area < minArea) {
                            minArea = area;
                            smallestCircle = circle;
                        }
                    }
                    break;
                default:
                    break;
            }
        }
        
        reader.close();

        writer.write("Longest Line Segment Length: " + (longestLineSegment != null ? maxLineLength : "None") + "\n");
        writer.write("Largest Rectangle Perimeter: " + (largestRectangle != null ? maxPerimeter : "None") + "\n");
        writer.write("Smallest Circle Area: " + (smallestCircle != null ? minArea : "None") + "\n");
        
        writer.close();
    }

    public static void main(String[] args) {
        try {
            String inputFile = "input.txt";
            String outputFile = "output.txt";

            processFile(inputFile, outputFile);
            System.out.println("Results written to " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
