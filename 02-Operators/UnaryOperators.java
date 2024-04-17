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
