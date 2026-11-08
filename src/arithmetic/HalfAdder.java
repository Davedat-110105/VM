package arithmetic;

import gate.AndGate;
import gate.XorGate;

/** Adds two bits. */
public record HalfAdder(boolean inputA, boolean inputB) {

    public boolean sum() {
        return new XorGate(inputA, inputB).evaluate();
    }

    public boolean carry() {
        return new AndGate(inputA, inputB).evaluate();
    }
}
