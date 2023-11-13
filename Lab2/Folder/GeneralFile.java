package Folder;

abstract class GeneralFile {
    String fileName;
    String ext;
    String createdDate;
    String lastModifiedDate;

    public GeneralFile(String fileName, String ext, String createdDate, String lastModifiedDate) {
        this.fileName = fileName;
        this.ext = ext;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
    }

    @Override
    public String toString() {
        return "fileName= " + fileName + '\n' +
                "extension= " + ext + '\n' +
                "createdDate= " + createdDate + '\n' +
                "lastModifiedDate= " + lastModifiedDate + '\n';
    }
}
