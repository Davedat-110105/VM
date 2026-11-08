package gate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NotGateTest {
    @Test
    void returnsTrueWhenInputIsFalse() {
        NotGate NotTest = new NotGate(false);
        assertTrue(NotTest.evaluate());
    }

    @Test
    void returnsFalseWhenInputIsTrue() {
        NotGate NotTest = new NotGate(true);
        assertFalse(NotTest.evaluate());
    }
}
