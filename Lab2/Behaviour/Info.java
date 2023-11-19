package Behaviour;
import FileFolder.FileFile;
import FileFolder.FileInfo;
import Folder.CodeFile;
import Folder.ImageFile;
import Folder.TextFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;


  public class Info extends FileFile {
      private final FileInfo fileInfo = new FileInfo();

      @Override
      public void execute(String[] args) {
          if (args.length < 2) {
              System.out.println("Usage: info <filename>");
              return;
          }

          String filename = args[1];
          File file = fileInfo.getFile(filename);

          if (file.exists()) {
              SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
              String extension = filename.substring(filename.lastIndexOf('.') + 1);

              String createdDate = fileInfo.getCreatedDate(file.toPath());
              String lastModifiedDate = dateFormat.format(new Date(file.lastModified()));

              if (extension.equals("png") || extension.equals("jpg") || extension.equals("jpeg")) {
                  ImageFile imageFile = new ImageFile(file.getName(),extension, createdDate,lastModifiedDate);
                  System.out.println(imageFile);

              } else if (extension.equals("txt.txt")) {
                  TextFile textFile = new TextFile(file.getName(),extension, createdDate,lastModifiedDate);
                  System.out.println(textFile);

              } else if (extension.equals("py") || extension.equals("java")) {
                  CodeFile codeFile = new CodeFile(file.getName(),extension, createdDate,lastModifiedDate);
                  System.out.println(codeFile);
              }
          } else {
              System.out.println("File not found: " + filename);
          }
      }

  }