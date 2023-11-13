package Folder;

import FileFolder.FileInfo;

import java.io.File;
import java.util.Scanner;

public class TextFile extends GeneralFile{
    private final FileInfo fileInfo = new FileInfo();
    File file = fileInfo.getFile(fileName);
    int wordCount;
    int lineCount;
    int charCount;

    public TextFile(String fileName, String ext, String createdDate, String lastModifiedDate) {
        super(fileName, ext, createdDate, lastModifiedDate);
        this.lineCount = getLineCount();
        this.wordCount = getWordCount();
        this.charCount = getCharacterCount();
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

    public int getWordCount() {
        try (Scanner scanner = new Scanner(file)) {
            int wordCount = 0;
            while (scanner.hasNext()) {
                scanner.next();
                wordCount++;
            }
            return wordCount;
        } catch (Exception e) {
            return 0;
        }
    }

    public int getCharacterCount() {
        try (Scanner scanner = new Scanner(file)) {
            int characterCount = 0;
            while (scanner.hasNext()) {
                String word = scanner.next();
                characterCount += word.length();
            }
            return characterCount;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                "lineCount= " + lineCount + "\n" +
                "wordCount= " + wordCount + "\n" +
                "characterCount= " + charCount + "\n" ;
    }
}