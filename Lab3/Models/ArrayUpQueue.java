package Models;

public class ArrayUpQueue implements Queue{
    private int[] arr;
    private int front;
    private int rear;
    private int size;

    public ArrayUpQueue() {
        arr = new int[5];
        front = 0;
        rear = -1;
        size = 0;
    }

    @Override
    public void enqueue(int element) {
        if (size == 5) {
            System.out.println("Full Queue!");
            return;
        }
        rear = (rear + 1) % 5;
        arr[rear] = element;
        size++;
    }

    @Override
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Empty Queue!");
            return -1;
        }
        int element = peek();
        front = (front + 1) % 5;
        size--;
        return element;
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            System.out.println("Empty Queue!");
            return -1;
        }
        return arr[front];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}