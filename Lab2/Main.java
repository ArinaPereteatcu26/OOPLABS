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
            System.out.print("Enter command: ");
            String input = scanner.nextLine();
            String[] parts = input.split(" ");
            String command = parts[0].toLowerCase();

            switch (command) {
                case "commit":
                    commit.execute(parts);
                    break;
                case "info":
                    Info infoInteraction = new Info();
                    infoInteraction.execute(parts);
                    break;
                case "status":
                    Status status = new Status(commit.getSnapshotTime());
                    status.execute(parts);
                    break;
                case "exit":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid command");
            }
        }
    }
}