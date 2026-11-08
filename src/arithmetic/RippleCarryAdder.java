package arithmetic;

/**
 * Adds two 4-bit numbers by chaining four FullAdders.
 * Bit order: index 0 is the least significant bit (LSB).
 */
public record RippleCarryAdder(boolean[] inputA, boolean[] inputB, boolean carryIn) {

    public static final int WIDTH = 4;

    /** The 4 sum bits, and whether the answer was too big for 4 bits. */
    public record Result(boolean[] sum, boolean carryOut) {

        public Result {
            sum = sum.clone();
        }

        @Override
        public boolean[] sum() {
            return sum.clone();
        }
    }

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

    public Result output() {
        boolean[] sum = new boolean[WIDTH];
        boolean carry = carryIn;
        for (int i = 0; i < WIDTH; i++) {
            FullAdder.Result bit = new FullAdder(inputA[i], inputB[i], carry).output();
            sum[i] = bit.sum();
            carry = bit.carryOut();
        }
        return new Result(sum, carry);
    }

    private static boolean[] checkWidth(boolean[] bits) {
        if (bits == null || bits.length != WIDTH) {
            throw new IllegalArgumentException("Expected " + WIDTH + " bits");
        }
        return bits;
    }
}
