package Models;

public class ArrayDownStack implements Stack {
    private int[] arr;
    private int size;

    public ArrayDownStack() {
        arr = new int[5];
        size = 5;
    }

    @Override
    public void push(int element) {
        if (size == 0) {
            System.out.println("Full Stack");
            return;
        }
        arr[--size] = element;
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            System.out.println("Empty Stack");
            return -1;
        }
        int element = peek();
        arr[size++] = 0;
        return element;
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            System.out.println("Empty Stack");
            return -1;
        }
        return arr[size];
    }

    @Override
    public boolean isEmpty() {
        return size == 5;
    }
}