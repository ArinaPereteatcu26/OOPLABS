package FileFolder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class FileInfo {

    private final String folderPath = "C:\\Users\\arina\\IdeaProjects\\OOPLABS\\Lab2\\files";
    public File getFile(String filename) {
        return new File(folderPath + File.separator + filename);
    }

    public String getCreatedDate(Path path) {
        try {
            BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
            FileTime creationTime = attributes.creationTime();
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(creationTime.toMillis()));
        } catch (IOException e) {
            return "N/A";
        }
    }

}
