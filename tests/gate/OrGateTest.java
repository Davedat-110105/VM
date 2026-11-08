package gate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrGateTest {
    @Test
    void returnsFalseWhenBothInputsAreFalse() {
        OrGate OrTest = new OrGate(false, false);
        assertFalse(OrTest.output());
    }

    @Test
    void returnsTrueWhenOnlySecondInputIsTrue() {
        OrGate OrTest = new OrGate(false, true);
        assertTrue(OrTest.output());
    }

    @Test
    void returnsTrueWhenOnlyFirstInputIsTrue() {
        OrGate OrTest = new OrGate(true, false);
        assertTrue(OrTest.output());
    }

    @Test
    void returnsTrueWhenBothInputsAreTrue() {
        OrGate OrTest = new OrGate(true, true);
        assertTrue(OrTest.output());
    }
}
