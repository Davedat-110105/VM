package gate;

public record AndGate(boolean inputA, boolean inputB) implements Gate {

    @Override
    public boolean output() {
        return inputA & inputB;
    }
}
