package _5_primitive_types;

public class PrimitivwUtils {

    public static short countBits(int x) {
        short numBits = 0;
        while (x != 0) {
            numBits += (x & 1);
            x >>>= 1;
        }
        return numBits;
    }

    public static void main(String[] args) {
        int x = -16;
        // >> is move, the empty space can be 0 or 1 as before. >>> will always be 0.
        System.out.println("x       is " + Integer.toBinaryString(x));
        System.out.println("x >> 1  is " + Integer.toBinaryString(x >> 1));
        System.out.println("x >>> 1 is " + Integer.toBinaryString(x >>> 1));

        System.out.println("6 & 4 val is " + (6 & 4));
        System.out.println("1 | 2 val is " + (1 & 2));
        System.out.println("8 >> 1 val is " + (8 >> 1));
        System.out.println("-16 >>> 2 val is " + (-16 >>> 2));
        System.out.println("-16 >> 2 val is " + (-16 >> 2));
        System.out.println("1 << 10 val is " + (1 << 10));
        System.out.println("~0 " + (~0));
        System.out.println("~3 " + (~3));
        System.out.println("int min value is " + Integer.MIN_VALUE);
        System.out.println("int max value is " + Integer.MAX_VALUE);
        System.out.println("float max value is " + Float.MAX_VALUE);
        System.out.println("float min value is " + Float.MIN_VALUE);
        System.out.println("double value is " + Double.SIZE);
        System.out.println("Boolean.TRUE is " + Boolean.TRUE);

        Character[] C = new Character[]{'a', 'b'};
    }
}
