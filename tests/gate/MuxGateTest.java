package gate;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MuxGateTest {

    @ParameterizedTest(name = "A={0}, B={1}, select={2}, output={3}")
    @CsvSource({
            // inputA, inputB, selectedLine, expectedOutput
            "false, false, false, false",
            "false, false, true,  false",
            "false, true,  false, false",
            "false, true,  true,  true",
            "true,  false, false, true",
            "true,  false, true,  false",
            "true,  true,  false, true",
            "true,  true,  true,  true"
    })
    void selectsTheInputChosenByTheSelectLine(boolean inputA, boolean inputB,
                                            boolean selectedLine, boolean expectedOutput) {
        MuxGate gate = new MuxGate(inputA, inputB, selectedLine);

        assertEquals(expectedOutput, gate.output());
    }
}
