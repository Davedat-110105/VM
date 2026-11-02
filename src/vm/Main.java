package vm;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        OperandStack stack = new OperandStack();
        List<Instruction> program = List.of(
                new Instruction(Opcode.PUSH, 6),
                new Instruction(Opcode.PUSH, 4),
                new Instruction(Opcode.MUL),
                new Instruction(Opcode.PRINT),
                new Instruction(Opcode.HALT)
        );

        VirtualMachine vm = new VirtualMachine(stack, program);
        vm.run();
    }
}
