package uk.ac.ncl.provrun.dataMachine;

import uk.ac.ncl.provrun.editor.Editor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
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

            //Create the file and write to it!
            if(!f.exists()) {
                try {
                    f.createNewFile();
                    FileWriter filewriter = new FileWriter(f);
                    filewriter.append(Editor.create()).close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        }

        return true;
    }


    public boolean read(int n ){

        File files[] = directory.listFiles();
        if (files.length <= 0)
            return true;

        for(int i = 0; i<n;i++){
            try {

                //Get a random file path form the files in the directory
                String path = files[ThreadLocalRandom.current().nextInt(n)].getAbsolutePath();

                //Don't do anything, just read the file!
                new String(Files.readAllBytes(Paths.get(path)));
            } catch (IOException e) {
               // e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    public boolean update(int n){

        File files[] = directory.listFiles();
        if (files.length <= 0)
            return true;

        for(int i =0; i<n;i++) {
            try {

                //Get the path of a random file in the file list
                String path = files[ThreadLocalRandom.current().nextInt(files.length)].getAbsolutePath();

                //Get all lines from that file (technically we just need the first)
                //NOTE: Files should be pretty small, so lets not worry about memory!
                List<String> lines = Files.readAllLines(Paths.get(path));

                //Replace the top line
                lines.set(0,Editor.update(lines.get(0)));

                //Write the file back
                Files.write(Paths.get(path), lines);

            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
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
