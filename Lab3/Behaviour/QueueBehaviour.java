package Behaviour;
import Models.Queue;
import java.util.Scanner;

public class QueueBehaviour {

    private Queue queue;

    public QueueBehaviour(Queue queue) {

        this.queue = queue;
    }

    public void performQueueBehaviour(Scanner scanner) {
        while (true) {
            System.out.println(" Which Queue behaviour do you need? : ");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("0. Quit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Input to enqueue to queue: ");
                    int element = scanner.nextInt();
                    queue.enqueue(element);
                    break;
                case 2:
                    int dequeuedInput = queue.dequeue();
                    if (dequeuedInput != -1) {
                        System.out.println("Dequeued input: " + dequeuedInput);
                    }
                    break;
                case 3:
                    int peekedInput = queue.peek();
                    if (peekedInput != -1) {
                        System.out.println("Peeked element from queue: " + peekedInput);
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Error");
            }
        }
    }
}