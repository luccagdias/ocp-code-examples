/*
 * Constructor is a special method that matches the name of the class and has no return type.
 * It is called when a new instance of the class is created.
 *
 */



/*
 * Creating a Constructor
 *
 *     The constructor name must match the name of the class and should not have a return type,
 *     not even void.
 *
 *     Like method parameters, constructor parameters can be any valid class, array, or primitive
 *     type, including generics, but may not include "var".
 *
 *     A class can have multiple constructors, as long as each constructor has a unique
 *     constructor signature (constructor overloading).
 *
 *     Constructors are used when creating a new object (instantiation). A constructor is called
 *     when we write "new" followed by the name of the class we want to instantiate.
 *
 */
class Bunny {
    public Bunny() { }      // valid constructor

    public void Bunny() { } // perfectly good method but is not a constructor

    public bunny() { }      // error: invalid method declaration; return type required
                            // doesn't match the class name, so it is treated as a regular method
}

class Turtle {

    // multiple constructors with unique signatures
    public Turtle() { }
    public Turtle(int age) { }
    public Turtle(long age) { }
    public Turtle(String name, String... favoriteFoods) { }

    public Turtle(var name) { } // error: 'var' is not allowed here
}



/*
 * The Default Constructor
 *
 *     If you don't include any constructors in the class, Java will create one for you without
 *     any parameters and with an empty body (the default constructor).
 *
 *     The compiler only inserts the default constructor when no constructors are defined.
 *
 *     Having only "private" constructors in a class tells the compiler not to provide a default
 *     no-argument constructor. It also prevents other classes from instantiating the class.
 */
class Rabbit {
    public static void main(String[] args) {
        new Rabbit(); // calls the default constructor
    }
}

class Rabbit2 {
    public Rabbit2() { }

    public static void main(String[] args) {
        new Rabbit2(); // calls the user-defined constructor
    }
}



/*
 * Calling Overloaded Constructors with "this()"
 *
 *     The multiple overloaded constructors in a class can call one another.
 *
 *     When "this()" is used, Java calls another constructor on the same instance of the class.
 *     If you choose to call it, the "this()" call must be the first statement in the constructor.
 *
 *     The compiler is capable of detecting that a constructor is calling itself infinitely.
 */
class Hamster {
    private String color;
    private int weight;

    public Hamster(int weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    public Hamster(int weight) {
        this(weight, "brown"); // calling another constructor
    }

    public Hamster(String color) {
        System.out.print(color); // error: call to this must be first statement in constructor
        this(5, color);
    }
}

class Gopher {
    public Gopher() { // error: recursive constructor invocation
        this(5);
    }

    public Gopher(int dugHoles) {
        this();
    }
}



/*
 * Calling Parent Constructors with "super()"
 *
 *      The first statement of every constructor is a call to a parent constructor using "super()"
 *      or another constructor in the class using "this()".
 *
 *      Like calling "this()", calling super() can only be used as the first statement of the
 *      constructor.
 *
 *      If the parent class has more than one constructor, the child class may use any valid
 *      parent constructor in its definition.
 *
 */
class Animal {
    public Animal(int age, String name) { }

    public Animal(int age) { }
}

class Gorilla extends Animal {
    public Gorilla (int age) {
        super(age, "Gorilla"); // calls the first Animal constructor
    }

    public Gorilla() {
        super(5); // calls the second Animal constructor
    }
}



/*
 * Understanding Compiler Enhancements
 *
 *     The compiler automatically inserts a call to the no-argument constructor "super()" if you
 *     do not explicitly call "this()" or "super()" as the first line of a constructor.
 *
 *     The following three class and constructor definitions are equivalent, because the compiler
 *     will automatically convert them all to the last example.
 *
 */
class Donkey { }

class Donkey2 {
    public Donkey2() { }
}

class Donkey3 {
    public Donkey3() {
        super();
    }
}



/*
 * Default Constructor Tips and Tricks
 *
 *     Lets say we have a class that doesn't include a no-argument constructor. What happens if we
 *     define a subclass with no constructors, or a subclass with a constructor that doesn't
 *     include a "super()" reference?
 *
 *     The answer is that neither subclass compiles. The compiler doesn't see a call to "super()"
 *     or "this()" as the first line of the constructor so it inserts a call to a nonexisting
 *     no-argument "super()" automatically.
 *
 */
class Mammal {
    public Mammal(int age) { }
}

class Seal extends Mammal { } // error: constructor Mammal in class Mammal cannot be applied to
                              // given types

class Elephant extends Mammal {
    public Elephant() { } // error: constructor Mammal in class Mammal cannot be applied to given
                          // types
}
