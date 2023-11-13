package Folder;
import java.io.File;
import FileFolder.FileInfo;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageFile extends GeneralFile{
    String imageSize;
    private final FileInfo fileInfo = new FileInfo();
    File file = fileInfo.getFile(fileName);

    public ImageFile(String fileName, String ext, String createdDate, String lastModifiedDate) {
        super(fileName, ext, createdDate, lastModifiedDate);
        this.imageSize = getImageSize();
    }
    String getImageSize() {
        try {
            BufferedImage image = ImageIO.read(file);
            int width = image.getWidth();
            int height = image.getHeight();
            return width + "x" + height;
        } catch (IOException e) {
            return "0";
        }
    }

    @Override
    public String toString() {
        return super.toString() + "imageSize= " + imageSize + "\n";
    }
}
