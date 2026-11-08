package arithmetic;

import gate.AndGate;
import gate.XorGate;

/** Adds two bits. */
public record HalfAdder(boolean inputA, boolean inputB) {

    public record Result(boolean sum, boolean carry) {}

    public Result output() {
        boolean sum = new XorGate(inputA, inputB).output();
        boolean carry = new AndGate(inputA, inputB).output();
        return new Result(sum, carry);
    }
}
