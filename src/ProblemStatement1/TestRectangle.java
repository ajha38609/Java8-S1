package ProblemStatement1;

import java.util.Scanner;

public class TestRectangle {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        // Create an array of Rectangle objects
        Rectangle[] rectangles = new Rectangle[5];
        
             for (int i = 0; i < rectangles.length; i++) {
            System.out.println("Enter information for Rectangle " + (i + 1) + ":");
            System.out.print("Enter length: ");
            double length = scanner.nextDouble();

            System.out.print("Enter breadth: ");
            double breadth = scanner.nextDouble();

            // Create Rectangle object with user input
            rectangles[i] = new Rectangle(length, breadth);
        }
        
     // Display information and calculate area for each rectangle
        for (int i = 0; i < rectangles.length; i++) {
            rectangles[i].displayInfo();
            System.out.println("-----------------------");
        }

        scanner.close();

	}
}