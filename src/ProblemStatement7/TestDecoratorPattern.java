package ProblemStatement7;

public class TestDecoratorPattern {

	public static void main(String[] args) {
		
		// Create a base burger
        Burger baseBurger = new BaseBurger("burger");
        System.out.println("Base burger: " + baseBurger.make());

        // Add veggies to the burger
        Burger veggieBurger = new VeggiesDecorator(baseBurger);
        System.out.println("Adding veggies to the burger");
        System.out.println("Base Burger: " + veggieBurger.make());

        // Add cheese to the burger
        Burger veggieCheeseBurger = new CheeseDecorator(veggieBurger);
        System.out.println("Adding cheese to the burger");
        System.out.println("I get " + veggieCheeseBurger.make());
    
	}

}
