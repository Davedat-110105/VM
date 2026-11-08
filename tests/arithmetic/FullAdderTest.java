package arithmetic;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FullAdderTest {

    @ParameterizedTest(name = "{0} + {1} + carry {2} = sum {3}, carryOut {4}")
    @CsvSource({
            // a, b, carryIn, sum, carryOut
            "0, 0, 0, 0, 0",
            "0, 0, 1, 1, 0",
            "0, 1, 0, 1, 0",
            "0, 1, 1, 0, 1",
            "1, 0, 0, 1, 0",
            "1, 0, 1, 0, 1",
            "1, 1, 0, 0, 1",
            "1, 1, 1, 1, 1",
    })
    void addsTwoBitsAndCarryIn(int a, int b, int carryIn, int expectedSum, int expectedCarryOut) {
        FullAdder.Result result = new FullAdder(a == 1, b == 1, carryIn == 1).output();

        assertEquals(expectedSum == 1, result.sum());
        assertEquals(expectedCarryOut == 1, result.carryOut());
    }
}
