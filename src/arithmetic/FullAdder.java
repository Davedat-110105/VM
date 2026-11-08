package arithmetic;

import gate.OrGate;

/** Adds two bits and a carry-in, using two half adders and an OR gate. */
public record FullAdder(boolean inputA, boolean inputB, boolean carryIn) {

    public record Result(boolean sum, boolean carryOut) {}

    public Result output() {
        HalfAdder.Result first = new HalfAdder(inputA, inputB).output();
        HalfAdder.Result second = new HalfAdder(first.sum(), carryIn).output();
        boolean carryOut = new OrGate(first.carry(), second.carry()).output();
        return new Result(second.sum(), carryOut);
    }
}
