package Models;

public class ArrayDownQueue implements Queue {
    private int[] arr;
    private int front;
    private int rear;
    private int size;

    public ArrayDownQueue() {
        arr = new int[5];
        front = 4;
        rear = 0;
        size = 5;
    }

    @Override
    public void enqueue(int element) {
        if (front == -1) {
            System.out.println("Full Queue");
            return;
        }
        arr[front] = element;
        front--;
    }

    @Override
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Empty Queue");
            return -1;
        }
        int element = peek();
        for (int i = size - 1; i > front + 1; i--){
            arr[i] = arr[i-1];
        }
        front += 1;
        return element;
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            System.out.println("Empty Queue");
            return -1;
        }
        int peekIndex = size-1;
        return arr[peekIndex];
    }

    @Override
    public boolean isEmpty() {
        return front == size-1;
    }
}