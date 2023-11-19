package Behaviour;

import FileFolder.FileFile;

import java.io.File;
import java.util.Date;

public class Commit extends FileFile {
    private Date snapshotTime;

    public Commit() {
        snapshotTime = new Date();
    }

    @Override
    public void execute(String[] args) {
        snapshotTime = new Date();
        System.out.println("Snapshot time updated to: " + snapshotTime);
    }

    public Date getSnapshotTime() {
        return snapshotTime;
    }
}