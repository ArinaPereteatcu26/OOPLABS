package Models;

public class ArrayUpStack implements Stack{
    private int[] arr;
    private int size;

    public ArrayUpStack() {
        arr = new int[5];
        size = 0;
    }

    @Override
    public void push(int element) {
        if (size == 5) {
            System.out.println("Full stack!");
            return;
        }
        arr[size++] = element;
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            System.out.println("Empty stack!");
            return -1;
        }
        int element = peek();
        arr[--size] = 0;
        return element;
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            System.out.println("Empty stack!");
            return -1;
        }
        return arr[size - 1];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}