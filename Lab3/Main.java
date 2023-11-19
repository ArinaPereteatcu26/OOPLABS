import Behaviour.QueueBehaviour;
import Behaviour.StackBehaviour;
import Models.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Which DataStructure do you need? :");
            System.out.println("1. ArrayUpStack");
            System.out.println("2. LinkedStack");
            System.out.println("3. ArrayUpQueue");
            System.out.println("4. LinkedQueue");
            System.out.println("0. Exit");

            int dataStructureChoice = scanner.nextInt();

            switch (dataStructureChoice) {
                case 1:
                    Stack arrayUpStack = new ArrayUpStack();
                    StackBehaviour arrayUpStackOperations = new StackBehaviour(arrayUpStack);
                    arrayUpStackOperations.performStackBehaviour(scanner);
                    break;
                case 2:
                    Stack linkedStack = new LinkedStack();
                    StackBehaviour linkedStackOperations = new StackBehaviour(linkedStack);
                    linkedStackOperations.performStackBehaviour(scanner);
                    break;
                case 3:
                    Queue arrayUpQueue = new ArrayUpQueue();
                    QueueBehaviour arrayUpQueueOperations = new QueueBehaviour(arrayUpQueue);
                    arrayUpQueueOperations.performQueueBehaviour(scanner);
                    break;
                case 4:
                    Queue linkedQueue = new LinkedQueue();
                    QueueBehaviour linkedQueueOperations = new QueueBehaviour(linkedQueue);
                    linkedQueueOperations.performQueueBehaviour(scanner);
                    break;
                case 0:
                    System.out.println("q");
                    System.exit(0);
                default:
                    System.out.println("Error");
            }
        }
    }
}