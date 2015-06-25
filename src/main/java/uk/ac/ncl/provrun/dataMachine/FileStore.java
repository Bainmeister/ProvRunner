package uk.ac.ncl.provrun.dataMachine;

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

    public FileStore(String directory) throws IllegalArgumentException{
        this.directory = CheckDirectory(new File(directory));
    }

    public boolean insert(int n){
        return true;
    }

    public boolean read(int n ){
        return true;
    }

    public boolean update(int n){
        return true;
    }

    public boolean begin() {
        return true;
    }

    public boolean commit() {
        return true;
    }

    private File CheckDirectory(File f) {
        //Confirm it is a directory
        if (!f.exists() || !f.isDirectory())
            throw new IllegalArgumentException("Not a real directory file");
        return f;
    }


}
