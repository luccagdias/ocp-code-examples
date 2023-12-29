/*
 * Inheritance is the process by which a subclass automatically includes certain members of
 * the class, including primitives, objects, or methods, defined in the parent class.
 *
 */



/*
 * Declaring a subclass
 *
 *     We indicate a class is a subclass by declaring it with the "extends" keyword. We don't
 *     need to declare anything in the superclass other than making sure it is not marked final.
 *
 *     Given three classes [X, Y, Z], if X extends Y, and Y extends Z, then X is considered a
 *     subclass or descendant of Z.
 *
 *     When one class inherits from a parent class, all public and protected members are
 *     automatically available as part of the child class. If they are in the same package,
 *     then package members are available to the child class.
 *
 *     Private members are restricted to the class they are defined in and are never available
 *     via inheritance.
 *
 */
class BigCat {
    protected double size;
}

class Jaguar extends BigCat {
    public Jaguar() {
        size = 10.2;
    }

    public void printDetails() {
        System.out.println(size);
    }
}

class Spider {
    public void printDetails() {
        System.out.println(size); // error: cannot find symbol
                                  // has no access to "size" since it is not inherited
    }
}



/*
 * Class Modifiers
 *
 *     A class declaration can have various modifiers: final, abstract, sealed, non-sealed and 
 *     static. For now, let's talk about marking a class "final".
 *
 *     The "final" modifier prevents a class from being extended any further.
 *
 */
class Mammal { }

final class Rhinoceros extends Mammal { }

class Clara extends Rhinoceros { } // error: cannot inherit from final Rhinoceros



/* Single vs. Multiple Inheritance
 *
 *     Java supports single inheritance, by which a class may inherit from only one direct parent
 *     class. 
 *
 *     You can have any number of levels of inheritance (one class that extends another class,
 *     which in turn extends another class, etc...), allowing each descendant to gain access to its
 *     ancestor's members.
 *
 */



/*
 * Inheriting Object
 *
 *     In Java, all classes inherit from a single class: java.lang.Object (or Object for short).
 *     Object is the only class that doesn't have a parent class.
 *
 *     When Java sees you define a class that doesn't extend another class, the compiler
 *     automatically adds the syntax "extends java.lang.Object" to the class definition.
 *
 */
class Zoo extends java.lang.Object { }
