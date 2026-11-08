package gate;

public record NotGate(boolean input) implements Gate {

    @Override
    public boolean output() {
        return !input;
    }
}
