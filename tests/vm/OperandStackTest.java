package vm;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperandStackTest {
    @Test
    void testOperandStack() {
        OperandStack OpS;
        OpS = new OperandStack();

        OpS.push(10);

        assertEquals(10, OpS.pop(), "pop should return the same value as inserted");
    }
}
