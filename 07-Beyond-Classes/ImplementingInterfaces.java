/*
 * Declaring and Using an Interface
 *
 *     An interface is defined with the "interface" keyword.
 *
 *     An interface contains implicit modifiers (modifiers that the compiler
 *     automatically inserts into the code):
 *
 *         * for methods: "public abstract"
 *         * for variables: "public static final" (referred to as constants)
 *         * for the interface itself: "abstract"
 *
 *     Interfaces are not required to define any method, and cannot be marked as final.
 *     They can be "public" or "package private".
 *
 */
abstract interface CanBurrow {                 // "abstract":            implicit modifier
    public static final int MINIMUM_DEPTH = 2; // "public static final": implicit modifiers
    
    public abstract Float getSpeed(int age);   // "public abstract":     implicit modifier
}

interface Climb {
    Number getSpeed(int age);
}

class FieldMouse implements Climb, CanBurrow {
    public Float getSpeed(int age) { // overrides two abstract methods at the same time
        return 11f;
    }
}
