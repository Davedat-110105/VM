package gate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrGateTest {
    @Test
    void returnsFalseWhenBothInputsAreFalse() {
        OrGate OrTest = new OrGate(false, false);
        assertFalse(OrTest.evaluate());
    }

    @Test
    void returnsTrueWhenOnlySecondInputIsTrue() {
        OrGate OrTest = new OrGate(false, true);
        assertTrue(OrTest.evaluate());
    }

    @Test
    void returnsTrueWhenOnlyFirstInputIsTrue() {
        OrGate OrTest = new OrGate(true, false);
        assertTrue(OrTest.evaluate());
    }

    @Test
    void returnsTrueWhenBothInputsAreTrue() {
        OrGate OrTest = new OrGate(true, true);
        assertTrue(OrTest.evaluate());
    }
}
