import java.io.File;
import java.util.Date;

public class Status extends FileFile {
    private Date lastSnapshotTime;

    public Status(Date lastSnapshotTime) {
        this.lastSnapshotTime = lastSnapshotTime;
    }

    @Override
    public void execute(String[] args) {
        String folderPath = "C:\\Users\\arina\\IdeaProjects\\OOPLABS\\Lab2\\files";
        File folder = new File(folderPath);

        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();
            if (files != null) {
                System.out.println("Created Snapshot at: " + lastSnapshotTime);

                for (File file : files) {
                    Date lastModifiedTime = new Date(file.lastModified());
                    String status = (lastModifiedTime.after(lastSnapshotTime)) ? "Changed" : "No Change";
                    System.out.println(file.getName() + " - " + status);
                }
            }
        }
    }
}