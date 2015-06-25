package uk.ac.ncl.provrun.editor;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by simon on 24/06/15.
 */
public class Editor {

    //Simple, start at 1!
    public static String create() {
        return "1";
    }

    //Add one to the current value stored and return it as a string
    public static String update(String val){
        return String.valueOf(Integer.parseInt(val) + 1);
    }

    public static String createFilename() {

        String filename = System.currentTimeMillis() + "_"
                + ThreadLocalRandom.current().nextInt(10) + ""
                + ThreadLocalRandom.current().nextInt(10);

        return filename.hashCode()+"";
    }
}
