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
        //TODO change this to Java 8 Files method
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

        //TODO improve this with Java 8... not too worried at the moment, just a prototype.
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

        File files[] = directory.listFiles();
        for(int i =0; i<n;i++) {
            try {
                //Get a random file, take its first row value, add 1 to it!
                //TODO make this look nicer!
                String path = files[ThreadLocalRandom.current().nextInt(files.length - 1)].getAbsolutePath();
                List<String> lines = Files.readAllLines(Paths.get(path));
                String s = Editor.update(lines.get(0));
                lines.clear();
                lines.add(s);
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
