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
