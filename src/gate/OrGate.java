package gate;

public record OrGate(boolean inputA, boolean inputB) implements Gate {

    @Override
    public boolean output() {
        return inputA | inputB;
    }
}
