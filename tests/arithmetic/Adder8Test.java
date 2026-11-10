package arithmetic;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Adder8Test {

    @ParameterizedTest(name = "{0} + {1} + carry {2} = {3}, carryOut {4}")
    @CsvSource({
            // a, b, carryIn, sum, carryOut
            "0,   0,   0, 0,   0",
            "5,   3,   0, 8,   0",
            "15,  1,   0, 16,  0",
            "128, 0,   0, 128, 0",
            "200, 55,  0, 255, 0",
            "255, 1,   0, 0,   1",
            "255, 255, 0, 254, 1",
            "0,   0,   1, 1,   0",
            "15,  0,   1, 16,  0",
            "255, 0,   1, 0,   1",
            "255, 255, 1, 255, 1"
    })
    void addsTwoEightBitNumbers(int a, int b, int carryIn, int expectedSum, int expectedCarryOut) {
        Adder8.Result result = new Adder8(toBits(a), toBits(b), carryIn == 1).output();

        assertEquals(8, result.sum().length);
        assertEquals(expectedSum, toInt(result.sum()));
        assertEquals(expectedCarryOut == 1, result.carryOut());
    }

    @Test
    void addsEveryPairWithBothCarryInValues() {
        for (int a = 0; a < 256; a++) {
            for (int b = 0; b < 256; b++) {
                for (int carryIn = 0; carryIn < 2; carryIn++) {
                    Adder8.Result result = new Adder8(toBits(a), toBits(b), carryIn == 1).output();
                    int expected = a + b + carryIn;
                    String inputs = a + " + " + b + " + carry " + carryIn;

                    assertEquals(expected % 256, toInt(result.sum()), inputs);
                    assertEquals(expected > 255, result.carryOut(), inputs + " carryOut");
                }
            }
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 4, 7, 9})
    void rejectsInputsThatAreNotEightBits(int length) {
        assertThrows(IllegalArgumentException.class,
                () -> new Adder8(new boolean[length], toBits(0), false));
        assertThrows(IllegalArgumentException.class,
                () -> new Adder8(toBits(0), new boolean[length], false));
    }

    @Test
    void rejectsNullInputs() {
        assertThrows(IllegalArgumentException.class, () -> new Adder8(null, toBits(0), false));
        assertThrows(IllegalArgumentException.class, () -> new Adder8(toBits(0), null, false));
    }

    @Test
    void changingInputArraysDoesNotChangeTheAdder() {
        boolean[] a = toBits(15);
        boolean[] b = toBits(1);
        Adder8 adder = new Adder8(a, b, false);

        a[0] = false;
        b[0] = false;

        assertEquals(16, toInt(adder.output().sum()));
    }

    @Test
    void changingReturnedInputsDoesNotChangeTheAdder() {
        Adder8 adder = new Adder8(toBits(15), toBits(1), false);

        adder.inputA()[0] = false;
        adder.inputB()[0] = false;

        assertEquals(16, toInt(adder.output().sum()));
    }

    @Test
    void changingTheOriginalSumArrayDoesNotChangeTheResult() {
        boolean[] sum = toBits(16);
        Adder8.Result result = new Adder8.Result(sum, false);

        sum[4] = false;

        assertEquals(16, toInt(result.sum()));
    }

    @Test
    void changingTheReturnedSumDoesNotChangeTheResult() {
        Adder8.Result result = new Adder8(toBits(15), toBits(1), false).output();

        result.sum()[0] = true;

        assertEquals(16, toInt(result.sum()));
    }

    /** Index 0 is the least significant bit. */
    private static boolean[] toBits(int value) {
        boolean[] bits = new boolean[8];
        for (int i = 0; i < bits.length; i++) {
            bits[i] = ((value >> i) & 1) == 1;
        }
        return bits;
    }

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
