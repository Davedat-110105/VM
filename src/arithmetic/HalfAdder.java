package arithmetic;

import gate.AndGate;
import gate.XorGate;

/** Adds two bits. */
public record HalfAdder(boolean inputA, boolean inputB) {

    public record Result(boolean sum, boolean carry) {}

    public Result output() {
        boolean sum = new XorGate(inputA, inputB).evaluate();
        boolean carry = new AndGate(inputA, inputB).evaluate();
        return new Result(sum, carry);
    }
}
