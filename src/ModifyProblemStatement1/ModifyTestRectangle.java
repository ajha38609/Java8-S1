
package ModifyProblemStatement1;
public class ModifyTestRectangle{

	public static void main(String[] args) {
		// Create a Rectangle object using default constructor
        ModifyRectangle rectangle1 = new ModifyRectangle();
        displayRectangleInfo(rectangle1);

        // Create a Rectangle object using parameterized constructor
        ModifyRectangle rectangle2 = new ModifyRectangle(5.0, 8.0);
        displayRectangleInfo(rectangle2);

        // Update the length and width of rectangle2 using setter methods
        rectangle2.setLength(10.0);
        rectangle2.setWidth(15.0);
        displayRectangleInfo(rectangle2);
    }

    // Function to display information of the Rectangle
    private static void displayRectangleInfo(ModifyRectangle rectangle) {
        System.out.println("Rectangle Information:");
        System.out.println("Length: " + rectangle.getLength());
        System.out.println("Width: " + rectangle.getWidth());
        System.out.println("Perimeter: " + rectangle.calculatePerimeter());
        System.out.println("Area: " + rectangle.calculateArea());
        System.out.println("-----------------------");
	}
}