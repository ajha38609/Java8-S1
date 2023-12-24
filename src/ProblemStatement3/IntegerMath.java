package ProblemStatement3;

interface IntegerMath {
 int operation(int a, int b);

public class Calculator {
 public void calculate(int x, int y, IntegerMath math) {
 int result = math.operation(x, y);
 System.out.println("Results: "  + result);
 
 }
}
}


