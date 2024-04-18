/* Complement and Negation Operators
 *
 *      logical complement operator (!): flips the value of a boolean expression.
 *          obs: applied to booleans
 *
 *      bitwise complement operator (~): flips all of the 0s and 1s in a number.
 *          obs: applied to integer types (byte, short, char, int, long)
 *               to find the bitwise complement of a number: -(n) - 1
 *
 *      negation operator (-): reverses the sign of a numeric expression
 *          obs: applied to all numeric types
 *
 */
class ComplementAndNegation {
    public static void main(String[] args) {
        // logical complement
        boolean isAnimalAsleep = false;
        System.out.println(!isAnimalAsleep); // true

        // bitwise complement
        int value = 12;
        System.out.println(~value); // -13

        // negation operator
        double temperature = 21.2;
        System.out.println(-temperature); // -21.2
    }
}


/* Increment and Decrement Operators
 *
 *      pre-increment / pre-decrement (++w, --w): increases/decreases the value by 1 and returns
 *      the NEW value
 *
 *      post-increment / post-decrement (w++, w--): increases/decreases the value by 1 and returns
 *      the ORIGINAL value
 *
 */
class IncrementAndDecrement {
    public static void main(String[] args) {
        int parkAttendance = 0;
        System.out.println(parkAttendance);   // 0
        System.out.println(++parkAttendance); // 1
        System.out.println(parkAttendance);   // 1
        System.out.println(parkAttendance--); // 1
        System.out.println(parkAttendance);   // 0
    }
}


/* Casting Values
 * 
 *      - operation where one ddata type is explicitly interpreted as another ddata type.
 *      - optional and unncessary when converting toa smaller or narrowing data type.
 *      - casting primitives is required any time you are going from a larger numerical data type.
 *        to a smaller numerical data type, or converting from a floating-point number to an
 *        integral value.
 *      - overflow is when a number is so large that it will no longer fit within the data type,
 *        so the system "wraps around" to the lowest negative value and conuts up from there.
 *
 */
class CastingValues {
    int fur = (int)5;
    int hair = (short) 2;
    String type = (String) "Bird";
    short tail = (short)(4 + 10); // since casting is a unary operation, it would only be applied
                                  // to the 4 if we didn't enclose 4 + 10 with parentheses
}
