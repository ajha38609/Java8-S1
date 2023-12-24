package ProblemStatement3;

import ProblemStatement3.IntegerMath.Calculator;

public class TestCalculator {
	
 public static void main(String[] args) {
 Calculator calculator = new Calculator();
 // Lambda expressions implementing IntegerMath interface for different operations
 IntegerMath addition = (a, b) -> a + b;
 IntegerMath subtraction = (a, b) -> a - b;
 IntegerMath multiplication = (a, b) -> a * b;
 IntegerMath division = (a, b) -> (b != 0) ? (a / b) : 0; 

 calculator.calculate(10, 5, addition); 
 calculator.calculate(10, 5, subtraction); 
 calculator.calculate(10, 5, multiplication); 
 calculator.calculate(10, 5, division); 
 }
}
