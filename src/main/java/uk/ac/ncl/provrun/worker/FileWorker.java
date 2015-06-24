package uk.ac.ncl.provrun.worker;

import java.io.File;
import java.nio.file.Files;
import java.util.List;

/**
 * Created by simon on 23/06/15.
 */
public class FileWorker implements WorkerFace{

    private File filepath;
    private String[] files;

    /**
     * We want either a directory to scan, or a file list.
     */
    private FileWorker(){}

    /**
     * This constructor will create a file list based upon the files within a directory.
     * @param filepath
     */
    FileWorker(String filepath){


        //Ensure we have a valid string
        if (filepath == null || filepath.equals(""))
            throw new IllegalArgumentException("Missing filepath");


        File d = new File(filepath);

        //Confirm it is a directory
        if (!d.exists() || !d.isDirectory())
            throw new IllegalArgumentException("Not a real file");

        //load the files in this location into the list!
        this.files = d.list();

    }


    //Perform the MongoAction of writing
    public boolean write(String key) {


        return true;
    }

    //Perform the MongoAction of reading
    public boolean read(String key) { return true; }

    //Perform the MongoAction of reading and then the mongo action of writing
    public boolean update(String key) {return true; }

}
