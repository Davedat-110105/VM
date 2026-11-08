package gate;

public record NotGate(boolean input) implements Gate {

    @Override
    public boolean evaluate() {
        return !input;
    }
}
