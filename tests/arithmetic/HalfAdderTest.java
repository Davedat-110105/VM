package arithmetic;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HalfAdderTest {

    @ParameterizedTest(name = "{0} + {1} = sum {2}, carry {3}")
    @CsvSource({
            // a, b, sum, carry
            "0, 0, 0, 0",
            "0, 1, 1, 0",
            "1, 0, 1, 0",
            "1, 1, 0, 1",
    })
    void addsTwoBits(int a, int b, int expectedSum, int expectedCarry) {
        HalfAdder.Result result = new HalfAdder(a == 1, b == 1).output();

        assertEquals(expectedSum == 1, result.sum());
        assertEquals(expectedCarry == 1, result.carry());
    }
}
