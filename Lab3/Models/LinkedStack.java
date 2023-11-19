package Models;

public class LinkedStack implements  Stack{
    private Node top;
    private int size;

    public LinkedStack() {
        top = null;
        size = 0;
    }

    @Override
    public void push(int element) {
        if (size == 5) {
            System.out.println("Full stack");
            return;
        }
        Node newNode = new Node(element);
        newNode.next = top;
        top = newNode;
        size++;
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            System.out.println("Empty stack");
            return -1;
        }
        int element = peek();
        top = top.next;
        size--;
        return element;
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            System.out.println("Empty stack");
            return -1;
        }
        return top.data;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}