package arithmetic;

/**
 * Adds two 4-bit numbers by chaining four FullAdders.
 * Bit order: index 0 is the least significant bit (LSB).
 */
public record RippleCarryAdder(boolean[] inputA, boolean[] inputB, boolean carryIn) {

    public static final int WIDTH = 4;

    /** Checks the inputs and copies the arrays so callers can't change them later. */
    public RippleCarryAdder {
        inputA = checkWidth(inputA).clone();
        inputB = checkWidth(inputB).clone();
    }

    @Override
    public boolean[] inputA() {
        return inputA.clone();
    }

    @Override
    public boolean[] inputB() {
        return inputB.clone();
    }

    public boolean[] sum() {
        boolean[] sum = new boolean[WIDTH];
        ripple(sum);
        return sum;
    }

    public boolean carryOut() {
        return ripple(new boolean[WIDTH]);
    }

    /** Runs the carry through all bits, fills in the sum bits, and returns the final carry. */
    private boolean ripple(boolean[] sum) {
        boolean carry = carryIn;
        for (int i = 0; i < WIDTH; i++) {
            FullAdder adder = new FullAdder(inputA[i], inputB[i], carry);
            sum[i] = adder.sum();
            carry = adder.carryOut();
        }
        return carry;
    }

    private static boolean[] checkWidth(boolean[] bits) {
        if (bits == null || bits.length != WIDTH) {
            throw new IllegalArgumentException("Expected " + WIDTH + " bits");
        }
        return bits;
    }
}
