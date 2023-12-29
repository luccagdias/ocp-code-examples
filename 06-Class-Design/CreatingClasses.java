/*
 * Extending a Class
 *
 *     Remember: private members are never inherited, and package members are only inherited if
 *     the two classes are in the same package.
 *
 */
class Animal {
    private int age;       // not directly accessible from the subclass
    protected String name;

    public int getAge() {
        return age;
    }

    public void setAge(int newAge) {
        age = newAge;
    }
}

class Lion extends Animal {
    protected void setProperties(int age, String n) {
        setAge(age);
        name = n;
    }

    public void roar() {
        System.out.println(name + ", age " + getAge() + ", says: Roar!");
    }

    public static void main(String[] args) {
        var lion = new Lion();
        lion.setProperties(3, "kion");
        lion.roar();
    }
}



/*
 * Applying Class Access Modifiers
 *
 *    Like variables and methods, you can apply access modifiers to classes.
 *
 *    Trying to declare a top-level class with "protected" or "private" class will lead to a
 *    compiler error.
 */
private class Bear { }   // error: modifier private not allowed here
protected class Fish { } // error: modifier protected not allowed here



/*
 * Accessing the "this" Reference
 *
 *     The "this" reference refers to the current instance of the class and can be used to
 *     access any member of the class, including inherited members.
 *
 *     It can be used in any instance method, constructor, or instance initializer block.
 *     It cannot be used in static methods or static initializer blocks (there is no implicit
 *     instance of the class).
 *
 */
class Bird {
    public String color;
}

class Duck extends Bird {
    private int length;
    private int height;

    public void setData(int length, int theHeight) {
        this.color = "white";    // "this" reference can be used to access inherited members
                                 // in this case, "this" reference is not necessary

        length = this.length;    // compiles, but does not modify the "length" instance variable
        this.height = theHeight; // fine, but "this" reference is not necessary
    }
}



/*
 * Calling the "super" Reference
 *
 *     In Java, a variable or method can be defined in both a parent class and a child class.
 *
 *     The "super" reference is similar to the "this" reference, except that it excludes any
 *     members found in the current class (in other words, the member must be accessible via
 *     inheritance).
 *
 *     Since "this" includes inherited members, you often only use "super" when you have a naming
 *     conflict via inheritance.
 *
 */

class Insect {
    protected int numberOfLegs = 4;
    String label = "buggy";
}

class Beetle extends Insect {
    protected int numberOfLegs = 6;
    short age = 3;

    public void printData() {
        System.out.println(this.label);
        System.out.println(super.label);
        System.out.println(this.age);     // defined in the subclass, accessible only via "this"
        System.out.println(super.age);    // error: cannot find symbol

        System.out.println(numberOfLegs); // starts with the narrowest scope, so prints 6

                                          // "this.numberOfLegs" and "super.numberOfLegs" refer to
                                          // different variables
    }
}
