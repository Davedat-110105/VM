package arithmetic;

import java.util.Arrays;

/**
 * Adds two 8-bit numbers by chaining two 4-bit RippleCarryAdders.
 * Bit order: index 0 is the least significant bit (LSB).
 */
public record Adder8(boolean[] inputA, boolean[] inputB, boolean carryIn) {

    public static final int WIDTH = 8;

    /** The 8 sum bits, and whether the answer was too big for 8 bits. */
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
    public Adder8 {
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
        int blockWidth = RippleCarryAdder.WIDTH;
        for (int start = 0; start < WIDTH; start += blockWidth) {
            boolean[] partA = Arrays.copyOfRange(inputA, start, start + blockWidth);
            boolean[] partB = Arrays.copyOfRange(inputB, start, start + blockWidth);
            RippleCarryAdder.Result block = new RippleCarryAdder(partA, partB, carry).output();

            System.arraycopy(block.sum(), 0, sum, start, blockWidth);
            carry = block.carryOut();
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
