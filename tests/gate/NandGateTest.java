package gate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NandGateTest {
    @Test
    void returnsTrueWhenBothInputsAreFalse() {
        NandGate NandTest = new NandGate(false, false);
        assertTrue(NandTest.evaluate());
    }

    @Test
    void returnsTrueWhenOnlySecondInputIsTrue() {
        NandGate NandTest = new NandGate(false, true);
        assertTrue(NandTest.evaluate());
    }

    @Test
    void returnsTrueWhenOnlyFirstInputIsTrue() {
        NandGate NandTest = new NandGate(true, false);
        assertTrue(NandTest.evaluate());
    }

    @Test
    void returnsFalseWhenBothInputsAreTrue() {
        NandGate NandTest = new NandGate(true, true);
        assertFalse(NandTest.evaluate());
    }
}
