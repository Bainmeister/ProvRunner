package uk.ac.ncl.provrun.dataMachine;

import uk.ac.ncl.provrun.editor.Editor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by simon on 24/06/15.
 */
public class FileStore implements DataMachine {


    //This file object should have all the info we need to add, update and read files.
    private File directory;

    private FileStore(File directory){
        this.directory = CheckDirectory(directory);
    }

    public FileStore(String directory) throws IllegalArgumentException{
        this.directory = CheckDirectory(new File(directory));
    }

    public boolean insert(int n)  {

        for(int i = 0; i<n;i++){

            String filename = Editor.createFilename();
            File f = new File(directory.getAbsolutePath(),filename+".txt");
            FileWriter filewriter = null;

            //Create the file and write to it!
            if(!f.exists())
                try {
                    f.createNewFile();
                    filewriter = new FileWriter(f);
                    filewriter.append(Editor.create());
                    filewriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
        }

        return true;
    }


    public boolean read(int n ){

        File files[] = directory.listFiles();

        for(int i = 0; i<n;i++){
            try {
                //Get a random file path form the files in the directory
                String path = files[ThreadLocalRandom.current().nextInt(n)].getAbsolutePath();
                //Don't do anything, just read the file!
                new String(Files.readAllBytes(Paths.get(path)));
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
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
