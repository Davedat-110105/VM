package gate;

public record XorGate(boolean inputA, boolean inputB) implements Gate {

    @Override
    public boolean output() {
        // Built from AND, OR and NOT on purpose; Java's ^ operator gives the same result.
        return (inputA & !inputB) | (!inputA & inputB);
    }
}
