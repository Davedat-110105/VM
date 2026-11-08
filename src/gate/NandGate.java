package gate;

public record NandGate(boolean inputA, boolean inputB) implements Gate {

    @Override
    public boolean output() {
        return !(inputA & inputB);
    }
}
