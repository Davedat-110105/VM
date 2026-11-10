package gate;


public record MuxGate(boolean inputA, boolean inputB, boolean selectedLine) implements Gate {

    @Override
    public boolean output() {
        boolean notSelect = new NotGate(selectedLine).output();
        boolean pickA = new AndGate(notSelect, inputA).output();
        boolean pickB = new AndGate(selectedLine, inputB).output();
        return new OrGate(pickA, pickB).output();
    }
}
