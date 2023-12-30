/*
 * Order of initialization refers to how members of a class are assigned values. They can be given
 * default values, like 0 for an int, or require explicit values, such as for "final" variables.
 *
 */




/*
 * Initializing Classes
 *
 *     The Java Virtual Machine (JVM) controls when the class is initialized, although you can
 *     assume the class is loaded before it is used. One of the most important rules with class
 *     initialization is that it happens at most once for each class.
 *
 */



/*
 * Initialize Class X
 *
 *     Order of initialization for a class:
 *         1. If there is a superclass Y of X, then initialize class Y first.
 *         2. Process all "static" variable declarations in the order in which they appear.
 *         3. Process all "static" initializers in the order in which they appear.
 *
 *     In the following example, Hippo prints "ABC", and Hippo Friend prints "CAB".
 *
 */
class Animal {
    static { System.out.print("A"); }
}

class Hippo extends Animal {
    public static void main(String[] grass) {
        System.out.print("C");
        new Hippo();
        new Hippo();
        new Hippo(); // even though the main() method creates three Hippo instances, the class is
                     // loaded only once.
    }

    static { System.out.print("B"); }
}

class HippoFriend {
    public static void main(String[] grass) {
        System.out.print("C");
        new Hippo();
    }
}



/*
 * Initializing "final" Fields
 *
 *     A default value is only applied to a non-final field. Fields marked "final" must be
 *     explicitly assigned a value exactly once.
 *
 *     They can be assigned values in the line in which they are declared, in an instrance
 *     initializer, or in a constructor (the constructor is part of the initialization process).
 *
 *     By the time the constructor completes, all "final" instance variables must be assigned
 *     a value exactly once.
 *
 */
class MouseHouse {
    private final String name = "The Mouse House"; // declaration assignment
    private final String type;
    private final int volume;

    { volume = 10; } // instance initializer assignment

    public MouseHouse(String type) {
        this.type = type;   // constructor assignment
    }

    public MouseHouse() { } // error: variable type might not have been initialized

    public MouseHouse(int n) {
        this("some type");  // does not perform any assignments to any "final" instance variables,
                            // but it calls the MouseHouse(String) constructor, which compiles
                            // without issue.
    }
}



/*
 * Initializing Instances
 *
 *     Start at the lowest-level constructor where the "new" keyword is used. Then, process upward
 *     and note the order of constructors. Finally, initialize each class starting with the
 *     superclass, processing each instance initializer and constructor in the reverse order in
 *     which it was called.
 *
 */



/*
 * Initialize Instance of X
 *
 *     Order of initialization for an instance:
 *         1. Initialize class X if it has not been previously initialized.
 *         2. If there is a superclass Y of X, then initialize the instance of Y first.
 *         3. Process all instance variable declarations in the order in which they appear.
 *         4. Process all instance initializers in the order in which they appear.
 *         5. Initialize the constructor, including any overloaded constructors referenced with
 *            "this()".
 *
 *
 *     The following example prints:
 *         AFBECHG
 *         BECHG
 *
 */
class GiraffeFamily {
    static { System.out.print("A"); }

    { System.out.print("B"); }

    public GiraffeFamily(String name) {
        this(1);
        System.out.print("C");
    }

    public GiraffeFamily() {
        System.out.print("D");
    }

    public GiraffeFamily(int stripes) {
        System.out.print("E");
    }
}

class Okapi extends GiraffeFamily {
    static { System.out.print("F"); }

    public Okapi(int stripes) {
        super("sugar");
        System.out.print("G");
    }

    { System.out.print("H"); }

    public static void main(String[] args) {
        new Okapi(1);
        System.out.println();
        new Okapi(2);
    }
}
