package vm;

public class OperandStack {
    private final int capacity = 256;
    private int[] array;
    private int sp = 0;

    public void push(int value) {
        if (sp == array.length){
            throw  new IllegalStateException("Stack is full");
        }

        array[sp] = value;
        sp++;
    }

    public int pop() {
        if (this.isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
        sp--;
        return array[sp];
    }

    public int peek(){
        if (this.isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
        return array[sp-1];
    }

    public int size(){
        return sp;
    }

    public boolean isEmpty(){
        return sp == 0;
    }

    public int capacity() {
        return capacity;
    }

    public OperandStack(){
        this.array = new int[capacity];
    }
}
