package Folder;

import FileFolder.FileInfo;

import java.io.File;
import java.util.Scanner;

public class CodeFile extends GeneralFile{
    private final FileInfo fileInfo = new FileInfo();
    File file = fileInfo.getFile(fileName);
    int lineCount;
    int classCount;
    int methodCount;

    public CodeFile(String fileName, String ext, String createdDate, String lastModifiedDate) {
        super(fileName, ext, createdDate, lastModifiedDate);
        this.lineCount = getLineCount();
        this.classCount = getClassCount();
        this.methodCount = getMethodCount();
    }

    public int getLineCount() {
        try (Scanner scanner = new Scanner(file)) {
            int lineCount = 0;
            while (scanner.hasNextLine()) {
                scanner.nextLine();
                lineCount++;
            }
            return lineCount;
        } catch (Exception e) {
            return 0;
        }
    }

    public int getClassCount() {
        int classCount = 0;
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.contains("class") || line.contains("enum")) {
                    classCount++;
                }
            }
        } catch (Exception e) {
            classCount = 0;
        }
        return classCount;
    }

    public int getMethodCount() {
        int methodCount = 0;
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.contains("def") || line.contains("public void")) {
                    methodCount++;
                }
            }
        } catch (Exception e) {
            methodCount = 0;
        }
        return methodCount;
    }
    @Override
    public String toString() {
        return super.toString()+
                "lineCount= " + lineCount + "\n" +
                "classCount= " + classCount + "\n" +
                "methodCount= " + methodCount + "\n" ;
    }
}