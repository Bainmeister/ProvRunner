package uk.ac.ncl.provrun.dataMachine;

import uk.ac.ncl.provrun.performance.ActionRecord;

import java.io.File;
import java.util.List;

/**
 * Created by simon on 24/06/15.
 */
public class FileStore implements DataMachine {

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

    //TODO
    public ActionRecord insert(int i){return new ActionRecord();}

    //TODO
    public ActionRecord  read(List<String> k){return new ActionRecord();}

    //TODO
    public ActionRecord  update(List<String> k){return new ActionRecord();}

    private File CheckDirectory(File f){
        //Confirm it is a directory
        if (!f.exists() || !f.isDirectory())
            throw new IllegalArgumentException("Not a real directory file");
        return f;
    }

}
