import java.io.*;

/*
 * Inheriting a class not only grants access to inherited methods in the parent class but also
 * sets the stage for collisions between methods defined in both the parent class and subclass.
 *
 */



/* Overriding a Method
 *
 *     Overriding a method occurs when a subclass declares a new implementation for an inherited
 *     method with the same signature and compatible return type.
 *
 *     When you override a method, you may still reference the parent version of the method using
 *     the "super" keyword.
 *
 *     To override a method, you must follow some rules:
 *         1. The method in the child class must have the same signature as the method in the
 *            parent class.
 *         2. The method in the child class must be at least as accessible as the method in the
 *            parent class (cannot be more restrictive).
 *         3. The method in the child class may not declare a checked exception that is new or
 *            broader than the class of any exception declared in the parent class method (applies
 *            only for checked exceptions).
 *         4. If the method returns a value, it must be the same or a subtype of the method in the
 *            parent class, known as covariant return types.
 *
 *    Obs.: overloading differs from overriding in that overloaded methods use a different
 *          parameter list.
 *
 */
class Camel {
    public int getNumberOfHumps() { return 1; }
}

class BactrianCamel extends Camel {
    private int getNumberOfHumps() { return 2; } // error: attempting to assign weaker access 
                                                 // privileges; was public
}

class Reptile {
    protected void sleep() throws IOException {}

    protected void hide() {}

    protected void exitShell() throws FileNotFoundException {}
}

class GalapagosTortoise extends Reptile {
    public void sleep() throws FileNotFoundException {} // compiles because the declared exception
                                                        // is narrower than the exception in the
                                                        // parent class

    public void hide() throws FileNotFoundException {}  // error: overridden method does not throw
                                                        // FileNotFoundException


    public void exitShell() throws IOException {}       // error: overridden method does not throw
                                                        // IOException
}

class Rhino {
    protected CharSequence getName() { return ""; }

    protected String getColor() { return ""; }
}

class JavanRhino extends Rhino {
    protected String getName() { return ""; }        // compiles because String is a subtype of 
                                                     // CharSequence

    protected CharSequence getColor() { return ""; } // error: return type CharSequence is not 
                                                     // compatible with String
}



/*
 * Redeclaring private Methods
 *
 *     In Java, you can't override private methods since they are not inherited.
 *
 *     Java permits you to redeclare a new method in the child class with the same or modified
 *     signature as the method in the parent class. This method in the child class is a separate
 *     and independent method, unrelated to the parent version's method.
 *
 */
class Beetle {
    private String getSize() {
        return "Undefined";
    }
}

class RhinocerosBeetle extends Beetle {
    private String getSize() { // unrelated to the parent version's method
        return "Undefined";
    }
}


/*
 * Hiding Static Methods
 *
 *     A static method cannot be overridden because class objects do not inherit from each other in
 *     the same way as instance objects. On the other hand, they can be hidden.
 *
 *     A hidden method occurs when a child class defines a static method with the same name and
 *     signature as an inherited static method defined in a parent class.
 *
 *     The previous four rules for overriding a method must be followed when a method is hidden. In
 *     addition, a new fifth rule is added for hiding a method:
 *         5. The method defined in the child class must be marked as static if it is marked as
 *            static in a parent class.
 *
 *     If one is marked static and the other is not, the class will not compile.
 *
 */
class Bear {
    public static void eat() {
        System.out.println("Bear is eating");
    }

    public void hibernate() {
        System.out.println("Bear is hibernating");
    }
}

class SunBear extends Bear {
    public static void eat() {
        System.out.println("Sun Bear is eating");
    }

    public static void hibernate() { // error: hibernate() in SunBear cannot override hibernate()
                                     // in Bear
        System.out.println("Sun Bear is hibernating");
    }
}


/*
 * Hiding Variables
 *
 *     A hidden variable occurs when a child class defines a variable with the same name as an
 *     inherited variable defined in the parent class.
 *
 *     You can't override a variable, you can only hide it.
 *
 */
class Carnivore {
    protected boolean hasFur = false;
}

class Meerkat extends Carnivore {
    protected boolean hasFur = true;

    public static void main(String[] args) {
        Meerkat m = new Meerkat();
        Carnivore c = m;
        System.out.println(m.hasFur); // true
        System.out.println(c.hasFur); // false, the output changes depending on the reference
    }
}



/*
 * Writing final Methods
 *
 *     By marking a method "final", you forbid a child class from replacing this method. This rule
 *     is in place both when you override a method and when you hide a method.
 *
 */
class Bird {
    public final boolean hasFeathers() {
        return true;
    }

    private final void flyAway() {}
}

class Penguin extends Bird {
    public final boolean hasFeathers() { // error: hasFeathers() in Penguin cannot override
                                         // hasFeathers() in Bird
        return false;
    }

    private final void flyAway() {}      // private methods are redeclared, not overridden or hidden
}
