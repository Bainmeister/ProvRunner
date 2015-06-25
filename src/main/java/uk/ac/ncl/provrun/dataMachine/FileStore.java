package uk.ac.ncl.provrun.dataMachine;

import uk.ac.ncl.provrun.performance.ActionRecord;

import java.io.File;

/**
 * Created by simon on 24/06/15.
 */
public class FileStore implements DataMachine {

    //TODO

    //This file object should have all the info we need to add, update and read files.
    private File directory;

    private FileStore(File directory){
        this.directory = CheckDirectory(directory);
    }

    public FileStore(String directory){
        //Ensure we have a valid string
        if (directory == null || directory.equals(""))
            throw new IllegalArgumentException("Missing filepath");

        this.directory = CheckDirectory(new File(directory));
    }

    public ActionRecord insert(int n){return new ActionRecord();
    }

    public ActionRecord  read(int n ){return new ActionRecord();
    }

    public ActionRecord  update(int n){
        return new ActionRecord();
    }

    public ActionRecord begin() {
        return null;
    }

    public ActionRecord commit() {
        return null;
    }

    private File CheckDirectory(File f) {
        //Confirm it is a directory
        if (!f.exists() || !f.isDirectory())
            throw new IllegalArgumentException("Not a real directory file");
        return f;
    }


}
