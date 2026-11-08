package gate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class XorGateTest {
    @Test
    void returnsFalseWhenBothInputsAreFalse() {
        XorGate XorTest = new XorGate(false, false);
        assertFalse(XorTest.evaluate());
    }

    @Test
    void returnsTrueWhenOnlySecondInputIsTrue() {
        XorGate XorTest = new XorGate(false, true);
        assertTrue(XorTest.evaluate());
    }

    @Test
    void returnsTrueWhenOnlyFirstInputIsTrue() {
        XorGate XorTest = new XorGate(true, false);
        assertTrue(XorTest.evaluate());
    }

    @Test
    void returnsFalseWhenBothInputsAreTrue() {
        XorGate XorTest = new XorGate(true, true);
        assertFalse(XorTest.evaluate());
    }
}
