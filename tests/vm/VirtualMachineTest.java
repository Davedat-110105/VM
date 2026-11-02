package vm;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class VirtualMachineTest {
    @Test
    void testMultiplication(){
        OperandStack Ops = new OperandStack();
        List<Instruction>  testInstruction = new ArrayList<Instruction>();
        VirtualMachine testVM = new VirtualMachine(Ops, testInstruction);

        }
    }
}
