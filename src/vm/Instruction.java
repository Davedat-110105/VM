package vm;

public class Instruction {
    private final Opcode opcode;
    private final int operand;

    Instruction(Opcode Code, int Operand) {
        opcode = Code;
        operand = Operand;
    }

    Instruction(Opcode Code){
        opcode = Code;
        operand = 0;
    }

    public Opcode getOpcode() {
        return opcode;
    }

    public int getOperand() {
        return operand;
    }
}
