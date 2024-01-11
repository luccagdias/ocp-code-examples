import java.util.*;

/*
 * The immutable objects pattern is an object-oriented design patterns in which an object cannot
 * be modified after it is created.
 *
 */



/*
 * Declaring an Immutable Class
 *
 *     Although there are a variety of techniques for writing an immutable class, this is a
 *     common strategy:
 *         1. Mark the class as "final" or make all of the constructors private.
 *         2. Mark all the instance variables "private" or "final".
 *         3. Don't define any setter methods.
 *         4. Don't allow referenced mutable objects to be modified.
 *         5. Use a constructor to set all properties of the object, making a copy if needed.
 *
 */
final class Animal {
    private final ArrayList<String> favoriteFoods;

    public Animal() {
        this.favoriteFoods = new ArrayList<String>();
        this.favoriteFoods.add("Apples");
    }

    public List<String> getFavoriteFoods() {
        return favoriteFoods; // not an immutable object since "favoriteFoods" can be changed
                              // example: getFavoriteFoods().add("Chocolate Chip Cookies");
    }

    public String getFavoriteFoodsItem(int index) {
        return favoriteFoods.get(index); // now it is a true immutable object because the mutable
                                         // variable cannot be modified by the caller
    }

    public List<String> getFavoriteFoods2() {
        // another approach is to make a copy of the mutable object any time it is requested
        return new ArrayList<String>(this.favoriteFoods);

        // this approach is called "Copy on Read", and can be an expensive operation if called
        // frequently by the caller
    }
}



/*
 * Performing a Defensive Copy
 *
 */
