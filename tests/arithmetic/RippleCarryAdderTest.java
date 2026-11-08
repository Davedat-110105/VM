package arithmetic;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RippleCarryAdderTest {

    @ParameterizedTest(name = "{0} + {1} + carry {2} = {3}, carryOut {4}")
    @CsvSource({
            // a, b, carryIn, sum, carryOut
            "0,  0,  0, 0,  0",
            "1,  1,  0, 2,  0",
            "5,  3,  0, 8,  0",
            "7,  3,  0, 10, 0",
            "9,  6,  0, 15, 0",
            "15, 1,  0, 0,  1",
            "15, 15, 0, 14, 1",
            "0,  0,  1, 1,  0",
            "15, 0,  1, 0,  1",
    })
    void addsTwoNumbers(int a, int b, int carryIn, int expectedSum, int expectedCarryOut) {
        RippleCarryAdder.Result result = new RippleCarryAdder(toBits(a), toBits(b), carryIn == 1).output();

        assertEquals(expectedSum, toInt(result.sum()));
        assertEquals(expectedCarryOut == 1, result.carryOut());
    }

    @Test
    void addsEveryPairOfFourBitNumbers() {
        for (int a = 0; a < 16; a++) {
            for (int b = 0; b < 16; b++) {
                RippleCarryAdder.Result result = new RippleCarryAdder(toBits(a), toBits(b), false).output();

                assertEquals((a + b) % 16, toInt(result.sum()), a + " + " + b);
                assertEquals(a + b > 15, result.carryOut(), a + " + " + b + " carry");
            }
        }
    }

    @Test
    void rejectsInputThatIsNotFourBits() {
        assertThrows(IllegalArgumentException.class,
                () -> new RippleCarryAdder(new boolean[3], toBits(0), false));
        assertThrows(IllegalArgumentException.class,
                () -> new RippleCarryAdder(toBits(0), new boolean[5], false));
    }

    @Test
    void changingInputArrayLaterDoesNotChangeAdder() {
        boolean[] seven = toBits(7);
        RippleCarryAdder adder = new RippleCarryAdder(seven, toBits(1), false);

        seven[0] = false;

        assertEquals(8, toInt(adder.output().sum()));
    }

    @Test
    void changingReturnedSumDoesNotChangeResult() {
        RippleCarryAdder.Result result = new RippleCarryAdder(toBits(7), toBits(1), false).output();

        result.sum()[0] = true;

        assertEquals(8, toInt(result.sum()));
    }

    /** Turns a number from 0 to 15 into 4 bits, index 0 = least significant bit. */
    private static boolean[] toBits(int value) {
        boolean[] bits = new boolean[RippleCarryAdder.WIDTH];
        for (int i = 0; i < bits.length; i++) {
            bits[i] = ((value >> i) & 1) == 1;
        }
        return bits;
    }

    /** Turns 4 bits back into a number, index 0 = least significant bit. */
    private static int toInt(boolean[] bits) {
        int value = 0;
        for (int i = 0; i < bits.length; i++) {
            if (bits[i]) {
                value += 1 << i;
            }
        }
        return value;
    }
}
