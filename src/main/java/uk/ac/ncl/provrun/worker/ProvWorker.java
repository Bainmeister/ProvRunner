package uk.ac.ncl.provrun.worker;

import uk.ac.ncl.provrun.datastore.DataAction;
import uk.ac.ncl.provrun.datastore.DataConn;

/**
 * Created by simon on 23/06/15.
 */
public class ProvWorker implements WorkerFace{

    //A worker will:
    //  write new documents
    //  read existing documents
    //  update existing

    DataConn conn;
    DataAction act;

    //Perform the MongoAction of writing
    public boolean write(String key) { return act.write(key); }

    //Perform the MongoAction of reading
    public boolean read(String key) { return act.read(key); }

    //Perform the MongoAction of reading and then the mongo action of writing
    public boolean update(String key) { return (read(key) && write(key)); }

}
