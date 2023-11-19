package Behaviour;

import Models.Stack;

import java.util.Scanner;


public class StackBehaviour {
    private Stack stack;

    public StackBehaviour(Stack stack) {
        this.stack = stack;
    }

    public void performStackBehaviour(Scanner scanner) {
        while (true) {
            System.out.println("Which Stack behaviour do you need? : ");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("0. Quit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Input to push to stack: ");
                    int element = scanner.nextInt();
                    stack.push(element);
                    break;
                case 2:
                    System.out.println("Popped element: " + stack.pop());
                    break;
                case 3:
                    System.out.println("Peeked element: " + stack.peek());
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Error");
            }
        }
    }
}