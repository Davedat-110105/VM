package gate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AndGateTest {
    @Test
    void returnsFalseWhenBothInputsAreFalse() {
        AndGate AndTest = new AndGate(false, false);
        assertFalse(AndTest.evaluate());
    }

    @Test
    void returnsFalseWhenOnlySecondInputIsTrue() {
        AndGate AndTest = new AndGate(false, true);
        assertFalse(AndTest.evaluate());
    }

    @Test
    void returnsFalseWhenOnlyFirstInputIsTrue() {
        AndGate AndTest = new AndGate(true, false);
        assertFalse(AndTest.evaluate());
    }

    @Test
    void returnsTrueWhenBothInputsAreTrue() {
        AndGate AndTest = new AndGate(true, true);
        assertTrue(AndTest.evaluate());
    }
}
