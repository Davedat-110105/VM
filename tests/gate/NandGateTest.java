package gate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NandGateTest {
    @Test
    void returnsTrueWhenBothInputsAreFalse() {
        NandGate NandTest = new NandGate(false, false);
        assertTrue(NandTest.output());
    }

    @Test
    void returnsTrueWhenOnlySecondInputIsTrue() {
        NandGate NandTest = new NandGate(false, true);
        assertTrue(NandTest.output());
    }

    @Test
    void returnsTrueWhenOnlyFirstInputIsTrue() {
        NandGate NandTest = new NandGate(true, false);
        assertTrue(NandTest.output());
    }

    @Test
    void returnsFalseWhenBothInputsAreTrue() {
        NandGate NandTest = new NandGate(true, true);
        assertFalse(NandTest.output());
    }
}
