package vm;

import java.util.List;

public class VirtualMachine {
    private final OperandStack Opstack;
    private List<Instruction> InstructionVM;
    private int pc = 0;

    public VirtualMachine (OperandStack stack, List<Instruction> instruction){
        Opstack = stack;
        InstructionVM = instruction;

    }

    public void run() {
        while (pc < InstructionVM.size()) {
            Instruction currentInstruction = InstructionVM.get(pc);
            Opcode code = currentInstruction.getOpcode();
            pc++;
            switch (code) {
                case ADD -> addition();
                case MUL -> multiplication();
                case DIV -> division();
                case SUB -> subtraction();
                case PUSH -> Opstack.push(currentInstruction.getOperand());
                case DUP -> Opstack.push(Opstack.peek());
                case POP -> Opstack.pop();
                case PRINT -> System.out.println(Opstack.peek());
                case HALT -> {
                    return;
                }


            }
        }
    }

    private void addition(){
        int firstNumber = Opstack.pop();
        int secondNumber = Opstack.pop();
        int answer = firstNumber + secondNumber;
        Opstack.push(answer);
    }

    private void subtraction(){
        int subtrahend = Opstack.pop();
        int minuend = Opstack.pop();
        int answer = minuend - subtrahend;
        Opstack.push(answer);
    }

    private void multiplication(){
        int firstNumber = Opstack.pop();
        int secondNumber = Opstack.pop();
        int answer = firstNumber * secondNumber;
        Opstack.push(answer);
    }

    private void division(){
        int divisor = Opstack.pop();
        int dividend = Opstack.pop();

        if (divisor == 0){
            throw new IllegalArgumentException("Cannot divide by zero");
        }

        int answer = dividend / divisor;
        Opstack.push(answer);
    }
}
