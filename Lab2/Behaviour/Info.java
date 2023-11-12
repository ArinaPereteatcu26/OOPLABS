package Behaviour;

import FileFolder.FileFile;
import FileFolder.FileInfo;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.Files;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

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

              System.out.println("File Name: " + file.getName());
              System.out.println("Extension: " + extension);
              String createdDate = fileInfo.getCreatedDate(file.toPath());
              System.out.println("Created Date: " + createdDate);
              System.out.println("Last Modified Date: " + dateFormat.format(new Date(file.lastModified())));

              if (extension.equals("png") || extension.equals("jpg") || extension.equals("jpeg")) {
                  String imageSize = fileInfo.getImageDimensions(file);
                  System.out.println("Image Size: " + imageSize);

              } else if (extension.equals("txt")) {
                  int lineCount = fileInfo.getLineCount(file);
                  int wordCount = fileInfo.getWordCount(file);
                  int characterCount = fileInfo.getCharacterCount(file);
                  System.out.println("Line Count: " + lineCount);
                  System.out.println("Word Count: " + wordCount);
                  System.out.println("Character Count: " + characterCount);
              } else if (extension.equals("py") || extension.equals("java")) {
                  int lineCount = fileInfo.getLineCount(file);
                  int classCount = fileInfo.getClassCount(file);
                  int methodCount = fileInfo.getMethodCount(file);
                  System.out.println("Line Count: " + lineCount);
                  System.out.println("Class Count: " + classCount);
                  System.out.println("Method Count: " + methodCount);
              }
          } else {
              System.out.println("File not found: " + filename);
          }
      }

  }