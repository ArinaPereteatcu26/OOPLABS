package Models;

public class LinkedQueue implements Queue{
    private Node front;
    private Node rear;
    private int size;

    public LinkedQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    @Override
    public void enqueue(int element) {
        if (size == 5) {
            System.out.println("Full Queue!");
            return;
        }
        Node newNode = new Node(element);
        if (isEmpty()) {
            front = newNode;
        } else {
            rear.next = newNode;
        }
        rear = newNode;
        size++;
    }

    @Override
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Empty Queue!");
            return -1;
        }
        int element = peek();
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return element;
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            System.out.println("Empty Queue!");
            return -1;
        }
        return front.data;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}