import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Commit commit = new Commit();

        String folderPath = "C:\\Users\\arina\\IdeaProjects\\OOPLABS\\Lab2\\files";
        File folder = new File(folderPath);

        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println("Invalid folder path.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("What do you want to do? ");
            System.out.println("c - Commit");
            System.out.println("i - Info ");
            System.out.println("s - Status ");
            System.out.println("q - Quit Program");
            System.out.println("Enter command: ");
            String input = scanner.nextLine();
            String[] parts = input.split(" ");
            String command = parts[0].toLowerCase();

            switch (command) {
                case "c":
                    commit.execute(parts);
                    break;
                case "i":
                    Info infoInteraction = new Info();
                    infoInteraction.execute(parts);
                    break;
                case "s":
                    Status status = new Status(commit.getSnapshotTime());
                    status.execute(parts);
                    break;
                case "q":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid command");
            }
        }
    }
}