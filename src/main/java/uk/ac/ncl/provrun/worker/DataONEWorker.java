package uk.ac.ncl.provrun.worker;

/**
 * Created by simon on 23/06/15.
 */
public class DataONEWorker implements WorkerFace{

    //Perform the MongoAction of writing
    public boolean write(String key) { return true; }

    //Perform the MongoAction of reading
    public boolean read(String key) { return true; }

    //Perform the MongoAction of reading and then the mongo action of writing
    public boolean update(String key) {return true; }

}
