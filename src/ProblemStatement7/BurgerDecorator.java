package ProblemStatement7;

import java.util.function.Function;

//Component interface
interface Burger {
 String make();
}

//Concrete component
class BaseBurger implements Burger {
 private final String burgerType;

 public BaseBurger(String burgerType) {
     this.burgerType = burgerType;
 }

 @Override
 public String make() {
     return burgerType;
 }
}

//Decorator
class BurgerDecorator implements Burger {
 private final Burger burger;
 private final Function<Burger, String> decoratorFunction;

 public BurgerDecorator(Burger burger, Function<Burger, String> decoratorFunction) {
     this.burger = burger;
     this.decoratorFunction = decoratorFunction;
 }

 @Override
 public String make() {
     return decoratorFunction.apply(burger);
 }
}

//Concrete decorators
class VeggiesDecorator extends BurgerDecorator {
 public VeggiesDecorator(Burger burger) {
     super(burger, b -> "Veggie " + b.make());
 }
}

class CheeseDecorator extends BurgerDecorator {
 public CheeseDecorator(Burger burger) {
    
     super(burger, b -> "Cheese " + b.make());
 }
}


