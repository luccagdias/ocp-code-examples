/*
 * Introducing Abstract Classes
 *
 *     An abstract class is a class declared with the "abstract" modifier that cannot be
 *     instantiated directly and may contain abstract methods.
 *
 *     An abstract method is a method declared with the "abstract" modifier that does not define
 *     a body.
 *
 *     Some rules to be aware of:
 *         - Only instance methods can be marked abstract within a class, not variables,
 *           constructors, or static methods.
 *         - An abstract method can only be declared in an abstract class
 *         - A non-abstract class that extends an abstract class must implement all inherited
 *           abstract methods.
 *         - Overriding an abstract method follows the existing rules for overriding methods.
 *
 *     If you attempt to instantiate an abstract class, the compiler will report an exception.
 *
 */
abstract class Canine {
    public abstract String getSound();
}

class Wolf extends Canine {
    public String getSound() {
        return "Wooooooof";
    }
}

class Fox extends Canine {} // error: Fox is not abstract and does not override abstract method
                            // getSound() in Canine

abstract class Alligator {
    public static void main(String... food) {
        var a = new Alligator(); // error: Alligator is abstract; cannot be instantiated
    }
}



/*
 * Declaring Abstract Methods
 *
 *     An abstract method is always declared without a body. It also includes a semicolon (;) after
 *     the method declaration.
 *
 *     An abstract class can include all of the same members as a non-abstract class, including
 *     variables, static and instance methods, constructors, etc. An abstract class is not
 *     required to include any abstract methods.
 *
 *     Even without abstract methods, the class cannot be directly instantiated.
 *
 *     Like the "final" modifier, the "abstract" modifier can be placed before or after the
 *     access modifier in class and method declarations.
 *
 *     The "abstract" modifier cannot be placed after the "class" keyword in a class declaration
 *     or after the return type in a method declaration.
 *
 *     It is not possible to define an abstract method that has a body or default implementation.
 *
 */
abstract class Llama {          // not requred to include an abstract method
    public void chew() {}
}

abstract class Tiger {
    abstract public int claw(); // "abstract" modifier CAN be placed before the access modifier
}

class abstract Bear {           // "abstract" modifier CANNOT be placed after the "class" keyword
    public int abstract howl(); // "abstract" modifier CANNOT be placed after the return type
}



/*
 * Creating a Concrete Class
 *
 *     A concrete class is a non-abstract class. The first concrete subclass that extends an
 *     abstract class is required to implement all inherited abstract methods.
 *
 *     An abstract class can extend a non-abstract class and vice versa. Anytime a concrete class
 *     is extending an abstract class, it must implement all of the methods that are inherited
 *     as abstract.
 *
 *     An abstract class that extends another abstract class is not required to implement the
 *     abstract methods that are inherited.
 */
abstract class Mammal {
    abstract void showHorn();
    abstract void eatLeaf();
}

abstract class Rhino extends Mammal {
    void showHorn() {} // inherited from Mammal

                       // since the Rhino class is abstract, it is not required to implement all
                       // of the abstract methods of the parent class
}

class BlackRhino extends Rhino {
    void eatLeaf() {}  // inherited from Rhino

                       // since the parent class provides an implementation of showHorn(), the
                       // method is inherited as non-abstract, so it is not required to be
                       // overridden
}



/*
 * Creating Constructors in Abstract Classes
 *
 *     Even though abstract classes cannot be instantiated, they are still initialized through by
 *     their subclasses.
 *
 */
abstract class AnotherMammal {
    abstract CharSequence chew();

    public AnotherMammal() { // only called when being initialized through a subclass
        System.out.println(chew());
    }
}

class Platypus extends AnotherMammal {
    String chew() { return "yummy!"; }

    public static void main(String[] args) {
        new Platypus();
    }
}



/*
 * Spotting Invalid Declarations
 *
 *     abstract and final: "abstract" intend for someone else to extend or implement, "final" are
 *     preventing anyone from extending or implementing it. These concepts are in direct conflict
 *     with each other.
 *
 *     abstract and private: how would you define a subclass that implements a required method if
 *     the method is not inherited by the subclass?
 *
 *     abstract and static: static methods cannot be overridden, so it cannot be marked "abstract"
 *     since it can never be implemented.
 *
 */
abstract class Animal {
    abstract final void walk();   // error: illegal combination of modifiers: abstract and final
    private abstract void sing(); // error: illegal combination of modifiers: abstract and private
    abstract static void swim();  // error: illegal combination of modifiers: abstract and static
}
