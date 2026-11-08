package arithmetic;

import gate.OrGate;

/** Adds two bits and a carry-in, using two half adders and an OR gate. */
public record FullAdder(boolean inputA, boolean inputB, boolean carryIn) {

    public boolean sum() {
        return secondHalf().sum();
    }

    public boolean carryOut() {
        return new OrGate(firstHalf().carry(), secondHalf().carry()).evaluate();
    }

    /** Adds the two input bits. */
    private HalfAdder firstHalf() {
        return new HalfAdder(inputA, inputB);
    }

    /** Adds the carry-in to the first half adder's sum. */
    private HalfAdder secondHalf() {
        return new HalfAdder(firstHalf().sum(), carryIn);
    }
}
