
package ModifyProblemStatement1;

public class ModifyRectangle {
	
	private double length;
    private double width;

    // Default constructor
    public ModifyRectangle() {
        this.length = 1.0;
        this.width = 1.0;
    }

    // Parameterized constructor with validation
    public ModifyRectangle(double length, double width) {
        setLength(length);
        setWidth(width);
    }

    // Getter and setter methods with validation
    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        if (isValidValue(length)) {
            this.length = length;
        } else {
            System.out.println("Invalid length value. Using default value (1.0).");
            this.length = 1.0;
        }
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if (isValidValue(width)) {
            this.width = width;
        } else {
            System.out.println("Invalid width value. Using default value (1.0).");
            this.width = 1.0;
        }
    }

    // Pure member functions to calculate perimeter and area
    public double calculatePerimeter() {
        return 2 * (length + width);
    }

    public double calculateArea() {
        return length * width;
    }

    // Private helper function to validate value
    private boolean isValidValue(double value) {
        return value > 0.0 && value < 20.0;
    }
}
