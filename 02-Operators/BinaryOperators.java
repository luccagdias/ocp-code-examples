/* Arithmetic Operators
 * 
 *      - Addition (+), Subtraction (-), Multiplication (*), Division (/) and Modulus (%).
 *      - Operate on numeric values.
 *      - Multiplicative operators have higher precedence than the additive operators.
 *      - You can change the order of operation (precedence) using parentheses.
 *      - For a given divisor y, the modulus operaton results in a value between 0 and (y - 1) for
 *        positive dividends.
 *
 *      - Numeric Promotion Rules
 *          1. Two values with different data types: promoted to the larger data type.
 *          2. One integral and one floating-point: promote the integral to the floating-point
 *          3. Smaller types (byte, short, char): first promoted to int, even if neither of the
 *             operands is int.
 *          4. After all promotion: resulting value have the same data type as its promoted
 *             operands.
 *
 */
class ArithmeticOperators {
    public static void main(String[] args) {
        int price1 = 2 * 5 + 3 * 4 - 8;     // 14
        int price2 = 2 * ((5 + 3) * 4 - 8); // 48, parentheses changing the order of precedence

        // difference between division and modulus operators
        System.out.println(9 / 3); // 3
        System.out.println(9 % 3); // 0

        System.out.println(10 / 3); // 3
        System.out.println(10 % 3); // 1

        System.out.println(11 / 3); // 3
        System.out.println(11 % 3); // 2

        System.out.println(12 / 3); // 4
        System.out.println(12 % 3); // 0

        // examples of type promotion
        int a = 1;
        long b = 33;
        var c = a * b; // c = long

        double d = 39.21;
        float e = 2.1f;
        var f = d + e; // f = double

        short g = 10;
        short h = 3;
        var i = g * h; // i = int

        short j = 14;
        float k = 13f;
        double l = 30;
        var m = j * k / l; // m = double
    }
}
